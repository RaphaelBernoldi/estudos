package br.com.estudos;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;

public class EmailService {

    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        try(KafkaConsumerService kafkaConsumer = new KafkaConsumerService(EmailService.class.getName(), "ECOMMERCE_SEND_EMAIL", emailService::parse, String.class, Map.of())) {
            kafkaConsumer.run();
        }
    }

    private void parse(ConsumerRecord<String, String> record){
        System.out.println("::::::::::::::::::::::::::::::::::::READ-MESSAGE::::::::::::::::::::::::::::::::::::");
        System.out.println(record.key());
        System.out.println(record.topic());
        System.out.println(record.value());
        System.out.println("::::::::::::::::::::::::::::::::::::END-MESSAGE::::::::::::::::::::::::::::::::::::");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
