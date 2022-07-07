package br.com.jaiminho.client;

import br.com.jaiminho.client.request.SendMessageKomuniqueRequest;
import br.com.jaiminho.client.response.SendMessageKomuniqueResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${komunique.name}", url = "${komunique.url}")
public interface KomuniqueClient extends Client {


    @PostMapping("/sms")
    SendMessageKomuniqueResponse sendSms(@RequestHeader("app-id") String apiId
                                       , @RequestHeader("app-token") String appToken
                                       , @RequestBody SendMessageKomuniqueRequest request);


}
