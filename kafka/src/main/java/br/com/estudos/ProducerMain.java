package br.com.estudos;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerMain {

    private static Logger LOG = LoggerFactory.getLogger(ProducerMain.class);

    public static void main(String[] args) {
        LOG.info("Iniciando");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(getProperties());
        String value = "123456789";
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("LOJA_NOVO_PEDIDO", value, value);
        producer.send(record);

    }

    private static Properties getProperties(){
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return properties;
    }
}
