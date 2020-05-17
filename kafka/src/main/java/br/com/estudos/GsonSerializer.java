package br.com.estudos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Serializer;

public class GsonSerializer<T> implements Serializer<T> {
    @Override
    public byte[] serialize(String s, T object) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(object).getBytes();
    }
}
