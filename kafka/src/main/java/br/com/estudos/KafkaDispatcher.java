package br.com.estudos;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaDispatcher<T> implements Closeable {

    private static final Logger LOG = LoggerFactory.getLogger(ProducerMain.class);
    private final KafkaProducer<String, T>producer;

     public KafkaDispatcher(){
         producer = new KafkaProducer(getProperties());
     }

    private static Properties getProperties(){
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializer.class.getName());
        return properties;
    }

    public void send(String topic, String key, T value) throws ExecutionException, InterruptedException {

        ProducerRecord<String, T> record = new ProducerRecord<String, T>(topic, key, value);
        Callback callback = (data, e) -> {
            if (e != null) {
                LOG.error("Erro " + e.getMessage());
                e.printStackTrace();
                return;
            }
            LOG.info("Topico " + data.topic() + " executado com sucesso!");
        };
        producer.send(record, callback).get();
    }

    @Override
    public void close() {
        producer.close();
    }
}
