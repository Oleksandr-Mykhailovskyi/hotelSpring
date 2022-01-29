package com.om.hotel.userInfoDataBase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "text")
    private String text;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String e_mail;

    @Column(name = "date_on")
    private String dateOn;

    @Column(name = "date_off")
    private String dateOff;

    @Column(name = "sex")
    private Integer sex;
}
