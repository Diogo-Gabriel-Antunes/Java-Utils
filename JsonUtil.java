package org.acme.Util;

import com.google.gson.Gson;
import org.acme.Util.PrimitiveUtil.StringUtil;
import org.acme.exceptions.ValidacaoException;
import org.acme.services.Service;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;

@ApplicationScoped
public class JsonUtil {
    public static void main(String[] args) {
        try{
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
            hashMap.forEach((key,value)->{
                if(!StringUtil.stringValida(String.valueOf(value))){
                    ValidacaoException validacao = new ValidacaoException();
                    validacao.add("Existem campos importantes vazios que não conseguimos identificar");
                    validacao.add("Caso o erro persistir favor entrar em contato com o suporte");
                    validacao.lancaErro();
                }
            });
        }catch (Throwable t){
            t.printStackTrace();
        }
    }
    public static void preValidate(String json,Class classe){
        try{
            Gson gson = new GsonUtil().parser;
            HashMap hashMap = gson.fromJson(json, HashMap.class);
            hashMap.forEach((key,value)->{
                if(!StringUtil.stringValida(String.valueOf(value))){
                    try{
                        ValidacaoException validacao = new ValidacaoException();
                        Field field = classe.getDeclaredField(String.valueOf(key));
                        validacao.add("Caso o erro persistir favor entrar em contato com o suporte");
                        validacao.lancaErro();
                    }catch (Throwable t){
                        t.printStackTrace();
                        ValidacaoException validacao = new ValidacaoException();
                        validacao.add("Existem campos importantes vazios que não conseguimos identificar");
                        validacao.add("Caso o erro persistir favor entrar em contato com o suporte");
                        validacao.lancaErro();
                    }
                }
            });
        }catch (Throwable t){
            t.printStackTrace();
        }
    }
}


