package br.com.jaiminho.controller;

import br.com.jaiminho.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/sms")
@Slf4j
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping(value = "/send", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> sendSms(@RequestParam("msg") String msg
                                        , @RequestParam("provider") String provider
                                        , @RequestParam("file") MultipartFile multipartFile){

            return ResponseEntity.ok(smsService.sendSms(multipartFile, provider, msg));

    }

    @GetMapping("/callback")
    public void callback(@RequestParam(value = "id", required = false) String uuid
                       , @RequestParam(value = "id_smsc", required = false) Integer idSmsc
                       , @RequestParam(value = "message_status", required = false) String messageStatus
                       , @RequestParam(value = "level", required = false) Integer level
                       , @RequestParam(value = "connector", required = false) String connector
                       , @RequestParam(value = "subdate", required = false) String subdate
                       , @RequestParam(value = "donedate", required = false) String donedate
                       , @RequestParam(value = "sub", required = false) Integer numberMsgsEqualsSended
                       , @RequestParam(value = "dlvrd", required = false) Integer numberMsgsEqualsDelivered
                       , @RequestParam(value = "err", required = false) String erro
                       , @RequestParam(value = "text", required = false) String message){

        log.info("id = {}, id_smsc = {}, message_status = {}, level = {}, connector = {}, subdate = {}, donedate = {}, sub = {}, dlvrd = {}, err {}, text = {}"
                , uuid, idSmsc, messageStatus, level, connector, subdate, donedate, numberMsgsEqualsSended, numberMsgsEqualsDelivered, erro, message);


    }
}
