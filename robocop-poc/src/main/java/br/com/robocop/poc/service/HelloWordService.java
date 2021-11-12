package br.com.robocop.poc.service;

import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.exceptions.IGLoginException;
import com.github.instagram4j.instagram4j.requests.accounts.AccountsLogoutRequest;
import com.github.instagram4j.instagram4j.requests.friendships.FriendshipsActionRequest;
import com.github.instagram4j.instagram4j.requests.friendships.FriendshipsPendingRequest;
import com.github.instagram4j.instagram4j.requests.tags.TagsSearchRequest;
import com.github.instagram4j.instagram4j.responses.IGResponse;
import com.github.instagram4j.instagram4j.responses.friendships.FriendshipStatusResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class HelloWordService {

    //private static final String USER_PAPAI = "raphaelbernoldi";
    //private static final String PASSWORD_PAPAI = "2524500979800751";

    private static final String USER_PAPAI = "fox_judite";
    private static final String PASSWORD_PAPAI = "!\"e.B\"hjuu>$6`a";

    private final IGClient user;

    public HelloWordService(IGClient user) {
        this.user = user;
    }

// !"e.B"hjuu>$6`a

    public static void main(String[] args){
        IGClient user = login(USER_PAPAI, PASSWORD_PAPAI);
        HelloWordService helloWordService = new HelloWordService(user);
        //helloWordService.postFotoPerfil("/home/raphael/Pictures/fotos_judite/foto_perfil.jpg");
        //helloWordService.acceptFriends();



    }

    public void searchPostNyHashTag(String hashTag){

        new TagsSearchRequest(hashTag)
                ;
    }

    public void acceptFriends(){
        new FriendshipsPendingRequest()
            .execute(user)
            .thenAccept(usersPending -> {
                usersPending
                        .getUsers()
                        .forEach(userPending -> {
                            log.info("{} quer add, aceita?", userPending.getUsername());
                            //alguma lógica
                            FriendshipStatusResponse response = new FriendshipsActionRequest(userPending.getPk(), FriendshipsActionRequest.FriendshipsAction.APPROVE).execute(user).join();
                            log.info("{} Accept with success, msg: {}", userPending.getUsername(),response.getMessage());

                        });

            });
    }

    public void getFriends(){

    }

    public void postFotoPerfil(String path){
        IGClient user = login(USER_PAPAI, PASSWORD_PAPAI);
        user
                .getActions()
                .account()
                .setProfilePicture(new File(path))
                .thenAccept(accountsUserResponse -> {
                    log.info("Success uploaded {}", accountsUserResponse.getMessage());
                })
                .join();

    }

    private void helloWordAPI(){
        HelloWordService helloWordService = new HelloWordService(user);
        IGClient client = helloWordService.login(USER_PAPAI, PASSWORD_PAPAI);
        client
                .getActions()
                .timeline()
                .feed()
                .forEach(feed -> {

                    System.out.println(feed.getMessage());
                    feed
                            .getFeed_items()
                            .forEach(feedTime -> {
                                log.info("FeedTimr: {}", feedTime);
                            });
                });
    }


    public IGResponse logout(IGClient client){
        return new AccountsLogoutRequest().execute(client).join();

    }
    public static IGClient login(String userName, String password)  {
        try {
            return IGClient.builder()
                    .username(userName)
                    .password(password)
                    .login();
        } catch (IGLoginException e) {
            log.error("Falha ao realizar login, msg {}, login response {}", e.getMessage(), e.getLoginResponse());
            e.printStackTrace();
            return null;
        }
    }




}
