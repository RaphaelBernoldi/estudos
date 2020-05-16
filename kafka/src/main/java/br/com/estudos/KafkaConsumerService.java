package br.com.estudos;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.Closeable;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerService implements Closeable {

    private KafkaConsumer<String, String> consumer;
    private ConsumerFunction parse;

    public KafkaConsumerService(String groupId, String topic, ConsumerFunction parse) {
        this.consumer = new KafkaConsumer(getProperties(groupId));
        this.consumer.subscribe(Collections.singletonList(topic));
        this.parse = parse;
    }

    private static Properties getProperties(String groupId) {
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1"); //Quantidade de registros por commit
        return properties;
    }

    public void run() {

        while (true) {

            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

            if (!records.isEmpty()) {
                System.out.println(records.count() + " encontrados!");

                for (ConsumerRecord<String, String> r : records) {
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
