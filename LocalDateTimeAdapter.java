package org.acme.Util;

import com.google.gson.*;
import org.eclipse.yasson.internal.serializer.LocalDateTimeTypeDeserializer;

import java.lang.reflect.Type;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter implements JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if(jsonElement.getAsString().length() == 16){

            return LocalDateTime.parse(jsonElement.getAsString(),DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        }else{
            return LocalDateTime.parse(jsonElement.getAsString(),DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

        }
    }
}
