package org.acme.Util;


import java.time.LocalDate;


public class DateUtil {

    public boolean validaData(LocalDate hoje) {
        return hoje.getMonth().getValue() == 1|| hoje.getMonth().getValue() == 3 || hoje.getMonth().getValue() == 5 || hoje.getMonth().getValue() == 7 || hoje.getMonth().getValue() == 8 ||hoje.getMonth().getValue() == 10 || hoje.getMonth().getValue() == 12;
    }
}
