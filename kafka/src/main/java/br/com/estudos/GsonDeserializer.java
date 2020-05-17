package br.com.estudos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class GsonDeserializer<T> implements Deserializer<T> {

    public static final String CONFIG_TYPE = "br.com.estudos.config_type";
    private Class<T> type;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        String typeName = String.valueOf(configs.get(CONFIG_TYPE));
        try {
             type = (Class<T>) Class.forName(typeName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Type for deserialize is not exist in classpath", e);
        }
    }

    @Override
    public T deserialize(String s, byte[] bytes) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(new String(bytes), type);
    }
}
