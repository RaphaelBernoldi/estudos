package br.com.jaiminho.client.response;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import java.io.Serializable;

@Data
public class SmsDevSendMessageResponse implements Serializable {

    @JsonValue
    private String situacao;
    @JsonValue
    private String codigo;
    @JsonValue
    private String id;
    @JsonValue
    private String descricao;

}
