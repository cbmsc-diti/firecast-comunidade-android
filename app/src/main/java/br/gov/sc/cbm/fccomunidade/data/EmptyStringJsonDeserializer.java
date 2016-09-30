package br.gov.sc.cbm.fccomunidade.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by bonet on 9/29/16.
 */

public class EmptyStringJsonDeserializer<E> implements JsonDeserializer<Collection<E>> {

    @Override
    public Collection<E> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        System.out.println(json);
        if(json.toString().isEmpty()) {
            System.out.println("Hello");
            return context.deserialize(new JsonArray(), typeOfT);
        } else {
            return context.deserialize(json, typeOfT);
        }
    }
}
