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

    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mojtesthotel@gmail.com");
        message.setTo(userInfoRepository.findAll().get(userInfoRepository.findAll().size() - 1).getE_mail());
        message.setText("Hello dr. " + userInfoRepository.findAll().get(userInfoRepository.findAll().size() - 1).getName() + " " + userInfoRepository.findAll().get(userInfoRepository.findAll().size() - 1).getSurname() + " Thank you for choosing of our hotel, your price is :" + rentRoomsRepository.findAll().get(rentRoomsRepository.findAll().size() - 1).getPrice() + " date on is : " + rentRoomsRepository.findAll().get(rentRoomsRepository.findAll().size() - 1).getDateOn() + " date off is: " + rentRoomsRepository.findAll().get(rentRoomsRepository.findAll().size() - 1).getDateOff());

        mailSender.send(message);


    }
}
