package com.haden.prjforstd.fcm;

import com.google.firebase.messaging.*;
import com.haden.prjforstd.demo.domain.entity.Token;
import com.haden.prjforstd.demo.domain.repository.TokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FcmService {

    private final TokenRepository tokenRepository;

    @Autowired
    public FcmService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public void sendByToken(FcmServiceDto dto){
        String token =
                "fpO9B9HkQs-5nUrb0t-2de:APA91bHSK_JgiUJDL4re0dSfEyVAgNwp7C6Cugc05vUoXxg3WiHv6fubih7_czuJggVq6Yl4DUwwQIlzvz2qkVHh7IGPwQnQprd6ZN-6MXmo1jfogRX1t4WQK5ABmT-XaKOkVw_Wa39q";

        Message message = Message.builder()
                .setToken(token)
                .setNotification(
                        Notification.builder()
                                .setTitle(dto.getTitle())
                                .setBody(dto.getContent())
                                .build()
                )
                .setAndroidConfig(
                        AndroidConfig.builder()
                                .setNotification(
                                        AndroidNotification.builder()
                                                .setTitle(dto.getTitle())
                                                .setBody(dto.getContent())
                                                .setClickAction("push_click")
                                                .build()
                                )
                                .build()
                )
                .setApnsConfig(
                        ApnsConfig.builder()
                                .setAps(Aps.builder()
                                        .setCategory("push_click")
                                        .build())
                                .build()
                )
                .putData("type",dto.getType().name())
                .putData("contentId",dto.getContentId().toString())
                .build();

        try {
            String response = FirebaseMessaging.getInstance().send(message);
            log.info("FCMsend-"+response);
        } catch (FirebaseMessagingException e) {
            log.info("FCMexcept-"+ e.getMessage());
        }
    }

    private String getToken(String username) {
        Token token = tokenRepository.findByUsername(username).orElse(null);
        return token.getTokenValue();
    }

}
