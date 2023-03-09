package org.acme.Util;

import com.google.gson.Gson;
import org.acme.Anotacao.DTO.LabelForm;
import org.acme.Anotacao.DTO.Type;
import org.acme.Util.PrimitiveUtil.StringUtil;
import org.acme.exceptions.ValidacaoException;

import javax.enterprise.context.ApplicationScoped;
import java.lang.reflect.Field;
import java.util.HashMap;

@ApplicationScoped
public class JsonUtil {
    public static void main(String[] args) {
        try {
            Gson gson = new GsonUtil().parser;
            HashMap hashMap = gson.fromJson(" {\n" +
                    "        \"CNH\": \"Duis\",\n" +
                    "        \"CPF\": \"Etiam gravida molestie\",\n" +
                    "        \"categoriaCNH\": \"c\",\n" +
                    "        \"dataAtualizacao\": \"2023-03-07T00:00:00\",\n" +
                    "        \"dataCriacao\": \"2023-03-07T00:00:00\",\n" +
                    "        \"dataDeValidadeCNH\": \"2024-01-10\",\n" +
                    "        \"email\": \"curabitur.sed.tortor@hotmail.org\",\n" +
                    "        \"endereco\": {\n" +
                    "            \"bairro\": \"Västra Götalands län\",\n" +
                    "            \"cep\": \"886922\",\n" +
                    "            \"codigoCidade\": \"Ukraine\",\n" +
                    "            \"codigoPais\": \"83-88\",\n" +
                    "            \"complemento\": \"Kennan England\",\n" +
                    "            \"descricaoCidade\": \"dis parturient\",\n" +
                    "            \"descricaoPais\": \"Austin Robles\",\n" +
                    "            \"estado\": \"SC\",\n" +
                    "            \"logradouro\": \"460 Velit St.\",\n" +
                    "            \"numero\": \"6\",\n" +
                    "            \"tipoBairro\": \"Bairro\",\n" +
                    "            \"tipoLogradouro\": \"Rua\",\n" +
                    "            \"uuid\": \"9BE473AE-B9B5-5DC9-0F3B-6AEA2A729378\"\n" +
                    "        },\n" +
                    "        \"idade\": 10,\n" +
                    "        \"nome\": \"Diogo\",\n" +
                    "        \"sobrenome\": \"Antunes\",\n" +
                    "        \"telefone\": \"(38)31625-7316\",\n" +
                    "        \"uuid\": \"7BC9BEB7-BBB2-1234-0165-567BE6C2FB98\"\n" +
                    "    }", HashMap.class);
            hashMap.forEach((key, value) -> {
                if (!StringUtil.stringValida(String.valueOf(value))) {
                    ValidacaoException validacao = new ValidacaoException();
                    validacao.add("Existem campos importantes vazios que não conseguimos identificar");
                    validacao.add("Caso o erro persistir favor entrar em contato com o suporte");
                    validacao.lancaErro();
                }
            });
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static String preValidate(String json, Class classe) {
        ValidacaoException validacao = new ValidacaoException();
        Gson gson = new GsonUtil().parser;
        try {
            HashMap hashMap = gson.fromJson(json, HashMap.class);
            hashMap.forEach((key, value) -> {
                if (!StringUtil.stringValida(String.valueOf(value))) {
                    try {
                        Field field = classe.getDeclaredField(String.valueOf(key));
                        if(field.getAnnotation(Type.class) != null && field.getAnnotation(Type.class).value() != null){
                            atributoTipoClasse(field.getAnnotation(Type.class).value(),gson.toJson(value));
                        }else{
                            if (field.getAnnotation(LabelForm.class) != null && StringUtil.stringValida(field.getAnnotation(LabelForm.class).value())) {
                                String label = field.getAnnotation(LabelForm.class).value();
                                validacao.add("Campo " + label + " Esta com algum problema por favor verificar");
                                hashMap.remove(key);
                            }else{
                                validacao.add("Existe algum campo invalido que não foi possivel identificar");
                                hashMap.remove(key);
                            }
                        }
                    } catch (Throwable t) {
                        t.printStackTrace();
                        validacao.add("Existem campos importantes vazios que não conseguimos identificar");
                        hashMap.remove(key);
                    }
                }
            });
            validacao.add("Caso o erro persistir favor entrar em contato com o suporte");
            return gson.toJson(hashMap);
        } catch (Throwable t) {
            t.printStackTrace();
            validacao.add("Caso o erro persistir favor entrar em contato com o suporte");
            return gson.toJson(validacao.getValidacoes());
        }
    }

    private static void atributoTipoClasse(Class value, String json) {
        preValidate(json,value);
    }
}


