package org.acme.Util.PrimitiveUtil;

import java.util.List;

public class ArrayUtil {
    public static  Boolean validaArray(List array){
        return !array.isEmpty() || array != null || array instanceof List;
    }
}
