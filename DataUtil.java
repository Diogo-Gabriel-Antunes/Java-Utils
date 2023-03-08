package org.acme.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DataUtil {
    DateTimeFormatter localDaTimeFormatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss")
            .withResolverStyle(ResolverStyle.STRICT);
    public static boolean validaLocalDateMaiorQueHoje(LocalDate localDate) {
        if (localDate.isBefore(LocalDate.now())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validaLocalDateDentroDesseAno(LocalDate localDate) {
        LocalDate hoje = LocalDate.now();
        if (localDate.isAfter(LocalDate.of(hoje.getYear(), 1, 1))) {
            if (localDate.isBefore(LocalDate.of(hoje.getYear(), 12, 31))) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    public static boolean validaLocalDateTimeMaiorQueHoje(LocalDateTime localDateTime) {
        if (localDateTime.isBefore(LocalDateTime.now())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validaLocalDateTimeDentroDesseAno(LocalDateTime localDateTime) {
        LocalDateTime hoje = LocalDateTime.now();
        if (localDateTime.isAfter(LocalDateTime.of(hoje.getYear(), 1, 1, 0, 0))) {
            if (localDateTime.isBefore(LocalDateTime.of(hoje.getYear(), 12, 0, 0, 0))) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean validaLocalDateTime(LocalDateTime dataDaSaida) {
        try{
            LocalDateTime dataHora = null;
            if(dataDaSaida == null){
                return false;
            }
            LocalDateTime.parse(dataDaSaida.toString(),localDaTimeFormatter);
            return true;
        }catch (DateTimeParseException e){
            return false;
        }
    }
}
