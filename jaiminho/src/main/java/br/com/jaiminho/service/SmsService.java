package br.com.jaiminho.service;

import br.com.jaiminho.client.SmsDevClient;
import br.com.jaiminho.provider.StrategyProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class SmsService {


    @Autowired
    private SmsDevClient smsDevClient;

    @Autowired
    private StrategyProviderService strategyProviderService;

    public String sendSms(MultipartFile multipartFile
                      , String nameProvider
                      , String msg){
        log.info("Try send by {}", nameProvider);
        return strategyProviderService
                .getProvider(nameProvider)
                .sendSms(multipartFile, msg);



    }
}
