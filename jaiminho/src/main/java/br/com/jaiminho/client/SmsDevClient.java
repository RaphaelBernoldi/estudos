package br.com.jaiminho.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${sms-dev.name}", url = "${sms-dev.url}")
public interface SmsDevClient extends Client {

    @GetMapping("/send")
    String sendSms(@RequestParam("key") String key
                                         , @RequestParam("type") Integer type
                                         , @RequestParam("number")  Long number
                                         , @RequestParam("msg") String msg
                                         , @RequestParam(value = "jobdate", required = false) String jobDate
                                         , @RequestParam(value = "jobtime", required = false) String jobTime);


}
