package org.acme.Util.PrimitiveUtil;

import org.acme.exceptions.ValidacaoException;

public class IntUtil {

    public static Integer parseFromString(String str){
        try{
            return Integer.parseInt(str);
        }catch (Throwable t){
            t.printStackTrace();
            ValidacaoException validacaoException = new ValidacaoException();
            validacaoException.add("Erro na conversão de valores, favor informar o suporte");
            validacaoException.lancaErro();
            return null;
        }
    }
    public static Integer parseFromLong(Long num){
        try{
            return Integer.parseInt(String.valueOf(num));
        }catch (Throwable t){
            t.printStackTrace();
            ValidacaoException validacaoException = new ValidacaoException();
            validacaoException.add("Erro na conversão de valores, favor informar o suporte");
            validacaoException.lancaErro();
            return null;
        }
    }
    public static Integer parseFromFloat(Float num){
        try{
            return Integer.parseInt(String.valueOf(num));
        }catch (Throwable t){
            t.printStackTrace();
            ValidacaoException validacaoException = new ValidacaoException();
            validacaoException.add("Erro na conversão de valores, favor informar o suporte");
            validacaoException.lancaErro();
            return null;
        }
    }
    public static Integer parseFromDouble(Double num){
        try{
            return Integer.parseInt(String.valueOf(num));
        }catch (Throwable t){
            t.printStackTrace();
            ValidacaoException validacaoException = new ValidacaoException();
            validacaoException.add("Erro na conversão de valores, favor informar o suporte");
            validacaoException.lancaErro();
            return null;
        }
    }
    public static Boolean isValidDifZero(Integer num){
        return num != null && num != 0;
    }
    public static Boolean isValid(Integer num){
        return num != null;
    }
}
