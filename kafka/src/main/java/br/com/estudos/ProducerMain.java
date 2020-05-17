package br.com.estudos;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class ProducerMain {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for(int i = 0; i<=5 ; i++) {
            try (KafkaDispatcher<Order> kafkaDispatcher = new KafkaDispatcher()) {
                try (KafkaDispatcher<String> kafkaDispatcherEmail = new KafkaDispatcher()) {

                    String key = UUID.randomUUID().toString();
                    Order order = new Order(UUID.randomUUID().toString(), UUID.randomUUID().toString(), new BigDecimal(Math.random() * 5000 + 1));
                    kafkaDispatcher.send("ECOMMERCE_NEW_ORDER", key, order);
                    kafkaDispatcherEmail.send("ECOMMERCE_SEND_EMAIL", key, "raphaelbernoldi@gmail.com");
                }
            }
        }

    }
}
