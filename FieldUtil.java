package org.acme.Util;


import org.acme.Anotacao.Type;
import org.acme.exceptions.ValidacaoException;
import org.acme.models.Categoria;
import org.acme.models.DTO.DTO;
import org.acme.models.DTO.ProdutoDTO;
import org.acme.models.Model;
import org.acme.models.Produto;

import javax.enterprise.context.ApplicationScoped;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;

@ApplicationScoped
public class FieldUtil {

    public String updateStringToGetorSet(Field attribute) {
        return attribute.getName().replaceFirst(attribute.getName().substring(0, 1), attribute.getName().substring(0, 1).toUpperCase());
    }

    public void updateFieldsDtoToModel(Model oldObject, DTO newObject) {
        Field[] attributes = newObject.getClass().getDeclaredFields();
        for (Field attribute : attributes) {
            try {
                attribute.setAccessible(true);
                if (attribute.get(newObject) != null && attribute.getAnnotation(Type.class) == null) {
                    oldObject.getClass().getDeclaredMethod("set" + updateStringToGetorSet(attribute), attribute.getType()).invoke(oldObject, attribute.get(newObject));
                }else if(attribute.getAnnotation(Type.class) != null && attribute.get(newObject) != null) {
                    montaSubClasse(attribute.getAnnotation(Type.class).value(),attribute.get(newObject));
                    oldObject.getClass().getDeclaredMethod("set" + updateStringToGetorSet(attribute), attribute.getAnnotation(Type.class).value()).invoke(oldObject, (Object) null);
                }else if(attribute.getAnnotation(Type.class) == null) {
                    oldObject.getClass().getDeclaredMethod("set" + updateStringToGetorSet(attribute), attribute.getType()).invoke(oldObject, (Object) null);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }

    public void updateFieldsModelToDTO(Model model, DTO dto) {
        Field[] attributes = model.getClass().getDeclaredFields();
        for (int i = 0; i < attributes.length - 5; i++) {
            try {
                attributes[i].setAccessible(true);
                if (attributes[i].get(model) != null) {
                    dto.getClass().getDeclaredMethod("set" + updateStringToGetorSet(attributes[i]), attributes[i].getType()).invoke(dto, attributes[i].get(model));
                }
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }

    public HashMap createHashMap(Model model, DTO dto) {
        Field[] attributes = dto.getClass().getDeclaredFields();
        HashMap hashMap = new HashMap();
        for (Field field : attributes) {
            try {
                field.setAccessible(true);
                if (field.get(dto) != null) {
                    hashMap.put(field.getName(), field.get(dto));
                }
            } catch (Throwable t) {
                throw new RuntimeException();
            }
        }
        return hashMap;

    }

    private Object montaSubClasse(Class value, Object model) {
        try{
            Object declaredConstructor = value.getDeclaredConstructor().newInstance();
            updateFieldsDtoToModel((Model) model, (DTO) declaredConstructor);
            return declaredConstructor;
        }catch (Throwable t){
            t.printStackTrace();
            ValidacaoException validacaoException = new ValidacaoException();
            validacaoException.add("Erro no sistema, favor informar o suporte");
            validacaoException.lancaErro();
            return null;
        }

    }


}
