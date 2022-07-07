package br.com.jaiminho.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class SendMessageKomuniqueRequest implements Serializable {

    @JsonProperty("destination_number")
    private String number;
    @JsonProperty("message")
    private String msg;
    @JsonProperty("tag")
    private String tag;
    @JsonProperty("user_reply")
    private Boolean userReply;

}
