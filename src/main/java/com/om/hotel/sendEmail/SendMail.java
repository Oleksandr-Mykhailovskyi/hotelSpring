package com.om.hotel.sendEmail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendMail {

    @Autowired
    private EmailSendService sendService;

    public void send(Long idUser, Long idRoom) {
        sendService.sendEmail(idUser, idRoom);
    }
}

