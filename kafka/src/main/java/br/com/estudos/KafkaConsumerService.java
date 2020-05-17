package br.com.estudos;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.Closeable;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

public class KafkaConsumerService<T> implements Closeable {

    private KafkaConsumer<String, T> consumer;
    private ConsumerFunction parse;

    public KafkaConsumerService(String groupId, String topic, ConsumerFunction<T> parse, Class<T> type, Map<String,String> overrrideProperties) {
        this.consumer = new KafkaConsumer(getProperties(type, groupId, overrrideProperties));
        this.consumer.subscribe(Collections.singletonList(topic));
        this.parse = parse;
    }

    public KafkaConsumerService(String groupId, Pattern topic, ConsumerFunction<T> parse, Class<T> type, Map<String,String> overrrideProperties) {
        this.consumer = new KafkaConsumer(getProperties(type, groupId, overrrideProperties));
        this.consumer.subscribe(topic);
        this.parse = parse;
    }

    private Properties getProperties(Class<T> type, String groupId, Map<String,String> overrrideProperties) {
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,  GsonDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1"); //Quantidade de registros por commit
        properties.setProperty(GsonDeserializer.CONFIG_TYPE, type.getName()); //Tipo de classe que será esperada dentro do meu Deserializer
        properties.putAll(overrrideProperties);
        return properties;
    }

    public void run() {

        while (true) {

            ConsumerRecords<String, T> records = consumer.poll(Duration.ofMillis(100));

            if (!records.isEmpty()) {
                System.out.println(records.count() + " encontrados!");

                for (ConsumerRecord<String, T> r : records) {
                    this.parse.parse(r);
                }
            }
        }
    }

    @Override
    public void close() {
        consumer.close();
    }
}
