package br.com.jaiminho.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SendMessageKomuniqueResponse implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("destination_number")
    private String destinationNumber;
    private String message;
    private String tag;
    private String price;
    private String status;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("user_reply")
    private Boolean userReply;


}
