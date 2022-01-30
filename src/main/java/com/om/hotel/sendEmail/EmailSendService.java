package com.om.hotel.sendEmail;

import com.om.hotel.rentRoomsDataBase.RentRoomsRepository;
import com.om.hotel.userInfoDataBase.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private RentRoomsRepository rentRoomsRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    public EmailSendService(RentRoomsRepository rentRoomsRepository, UserInfoRepository userInfoRepository) {
        this.rentRoomsRepository = rentRoomsRepository;
        this.userInfoRepository = userInfoRepository;
    }

    public void sendEmail(Long idUser, Long idRoom) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mojtesthotel@gmail.com");
        message.setTo(userInfoRepository.getById(idUser).getE_mail());
        message.setText("Hello dr. " + userInfoRepository.getById(idUser).getName() + " " + userInfoRepository.getById(idUser).getSurname() + "Thank you for choosing of our hotel, your price is :" + rentRoomsRepository.getById(idRoom).getPrice() + " date on is : " + rentRoomsRepository.getById(idRoom).getDateOn() + " date off is: " + rentRoomsRepository.getById(idRoom).getDateOff());

        mailSender.send(message);


    }
}
