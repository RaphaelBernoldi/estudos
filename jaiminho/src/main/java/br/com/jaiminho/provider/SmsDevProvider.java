package br.com.jaiminho.provider;

import br.com.jaiminho.client.SmsDevClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
@Slf4j
public class SmsDevProvider extends Provider {

    @Value("${sms-dev.key}")
    private String smsDevKey;
    @Value("${sms-dev.type}")
    private Integer smsDevType;
    @Value("${sms-dev.dateSchedule}")
    private String dateSchedule;
    @Value("${sms-dev.hourSchedule}")
    private String hourSchedule;
    @Value("${sms-dev.enable}")
    private Boolean enable;
    @Autowired
    private SmsDevClient smsDevClient;

    @Override
    public String sendSms(MultipartFile multipartFile
                        , String msg){

        if(!Objects.isNull(enable) && enable ){
            readLines(multipartFile)
                    .stream()
                    .forEach(number -> {
                        log.info("Send msg to {}", number);
                        String response = smsDevClient.sendSms(smsDevKey, smsDevType, number, msg, dateSchedule, hourSchedule);
                        log.info("retorno sms-deb : {}", response);
                    });
            log.info("Sended");
            return "Sended";
        }else{
            log.info("Provider disabled");
            return "Provider disabled";
        }


    }


}
