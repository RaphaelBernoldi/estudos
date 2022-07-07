package br.com.allpha5.insta.service;

import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.oauth.InstagramService;


public class ConnectInstagram {

    public void connect(){
        InstagramService service = new InstagramAuthService()
                                        .apiKey("your_client_id")
                                        .apiSecret("your_client_secret")
                                        .callback("your_callback_url")
                                        .build();
    }

    public static void main(String[] args) {

    }
}
