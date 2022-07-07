package br.com.jaiminho.provider;

import br.com.jaiminho.client.KomuniqueClient;
import br.com.jaiminho.client.request.SendMessageKomuniqueRequest;
import br.com.jaiminho.client.response.SendMessageKomuniqueResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
@Slf4j
public class KomuniqueProviderService extends Provider {

    @Value("${komunique.id}")
    private String komuniqueId;
    @Value("${komunique.token}")
    private String komuniqueToken;
    @Value("${komunique.enable}")
    private Boolean enable;

    @Autowired
    private KomuniqueClient komuniqueClient;

    @Override
    public String sendSms(MultipartFile multipartFile
                        , String msg) {

        if (!Objects.isNull(enable) && enable) {
            readLines(multipartFile)
                    .stream()
                    .forEach(number -> {
                        log.info("Send msg to {}", number);
                        SendMessageKomuniqueRequest request = SendMessageKomuniqueRequest
                                .builder()
                                .msg("test")
                                .number("+55" + number)
                                .userReply(false)
                                .build();
                        SendMessageKomuniqueResponse response = komuniqueClient.sendSms(komuniqueId, komuniqueToken, request);
                        log.info("retorno komunique : {} - {}", response.getDestinationNumber(), response.getStatus());
                    });
            log.info("Sended");
            return "Sended";

        } else {
            log.info("Provider disabled");
            return "Provider disabled";
        }
    }


}
