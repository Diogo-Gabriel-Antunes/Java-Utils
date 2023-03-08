package org.acme.Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class GsonUtil {

    public Gson parser = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class,new LocalDateAdapter())
            .registerTypeAdapter(LocalDate.class,new LocalDateAdapter2())
            .registerTypeAdapter(LocalDateTime.class,new LocalDateTimeAdapter())
            .create();

}
