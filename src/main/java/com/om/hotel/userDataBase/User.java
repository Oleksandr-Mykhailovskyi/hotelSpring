package com.om.hotel.userDataBase;

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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "user_ID")
    private String userIdNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "how_many_days")
    private Integer days;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;
}
