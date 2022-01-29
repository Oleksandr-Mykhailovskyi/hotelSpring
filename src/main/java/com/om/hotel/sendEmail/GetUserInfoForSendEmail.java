package com.om.hotel.sendEmail;

import com.om.hotel.rentRoomsDataBase.RentRoomsRepository;
import com.om.hotel.userInfoDataBase.UserInfoRepository;

import java.time.LocalDate;

public class GetUserInfoForSendEmail {

    private RentRoomsRepository rentRoomsRepository;

    private UserInfoRepository userInfoRepository;

    private String name;
    private String surname;
    private LocalDate dateOn;
    private LocalDate dateOff;
    private int price;
    private String email;
    private String sex;

    GetUserInfoForSendEmail(
            UserInfoRepository userInfoRepository,
            RentRoomsRepository rentRoomsRepository
    ) {
        this.userInfoRepository = userInfoRepository;
        this.rentRoomsRepository = rentRoomsRepository;
        takeInfoFromDataBase();
    }

    private void setInformation(String name,
                                String surname,
                                LocalDate dateOn,
                                LocalDate dateOff,
                                int price,
                                String email,
                                String sex) {
        this.name = name;
        this.surname = surname;
        this.dateOn = dateOn;
        this.dateOff = dateOff;
        this.price = price;
        this.email = email;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOn() {
        return dateOn;
    }

    public LocalDate getDateOff() {
        return dateOff;
    }

    public int getPrice() {
        return price;
    }

    private void takeInfoFromDataBase() {
        Long maxUser = Long.parseLong(String.valueOf(userInfoRepository.findAll().size()));
        Long maxRoom = Long.parseLong(String.valueOf(rentRoomsRepository.findAll().size()));
        this.name = String.valueOf(userInfoRepository.findById(Long.valueOf(userInfoRepository.getById(maxUser).getName())));
        this.surname = String.valueOf(userInfoRepository.findById(Long.valueOf(userInfoRepository.getById(maxUser).getSurname())));
        this.dateOn = LocalDate.parse(userInfoRepository.getById(maxUser).getDateOn());
        this.dateOff = LocalDate.parse(userInfoRepository.getById(maxUser).getDateOff());
        this.email = userInfoRepository.getById(maxUser).getE_mail();
        this.price = rentRoomsRepository.getById(maxRoom).getPrice();

        int sexInt = userInfoRepository.getById(maxUser).getSex();

        if (sexInt == 1) {
            this.sex = "Woman";
        } else this.sex = "Man";

        setInformation(name, surname, dateOn, dateOff, price, email, sex);
    }
}
