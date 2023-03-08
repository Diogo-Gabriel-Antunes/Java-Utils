package org.acme.Util.PrimitiveUtil;

import org.acme.exceptions.ValidacaoException;

public class LongUtil {

    public static Long parseFromString(String str){
        try{
            return Long.parseLong(str);
        }catch (Throwable t){
            t.printStackTrace();
            ValidacaoException validacaoException = new ValidacaoException();
            validacaoException.add("Erro na conversão de valores, favor informar o suporte");
            validacaoException.lancaErro();
            return null;
        }
    }
    public static Long parseFromInteger(Integer num){
        try{
            return Long.parseLong(String.valueOf(num));
        }catch (Throwable t){
            t.printStackTrace();
            ValidacaoException validacaoException = new ValidacaoException();
            validacaoException.add("Erro na conversão de valores, favor informar o suporte");
            validacaoException.lancaErro();
            return null;
        }
    }
    public static Long parseFromFloat(Float num){
        try{
            return Long.parseLong(String.valueOf(num));
        }catch (Throwable t){
            t.printStackTrace();
            ValidacaoException validacaoException = new ValidacaoException();
            validacaoException.add("Erro na conversão de valores, favor informar o suporte");
            validacaoException.lancaErro();
            return null;
        }
    }
    public static Long parseFromDouble(Double num){
        try{
            return Long.parseLong(String.valueOf(num));
        }catch (Throwable t){
            t.printStackTrace();
            ValidacaoException validacaoException = new ValidacaoException();
            validacaoException.add("Erro na conversão de valores, favor informar o suporte");
            validacaoException.lancaErro();
            return null;
        }
    }
    public static Boolean isValidDifZero(Long num){
        return num != null && num != 0;
    }
    public static Boolean isValid(Long num){
        return num != null;
    }
}
