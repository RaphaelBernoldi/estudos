package br.com.estudos;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class ProducerMain {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        try(KafkaDispatcher kafkaDispatcher = new KafkaDispatcher()) {

            String key = UUID.randomUUID().toString();
            String value = "Teste segundo dia";
            String email = "raphaelbernoldi@gmail.com";

            kafkaDispatcher.send("ECOMMERCE_NEW_ORDER", key, value);
            kafkaDispatcher.send("ECOMMERCE_SEND_EMAIL", email, value);
        }

    }
}
