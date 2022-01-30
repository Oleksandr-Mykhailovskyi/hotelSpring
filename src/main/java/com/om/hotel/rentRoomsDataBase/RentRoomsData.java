package com.om.hotel.rentRoomsDataBase;

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
    public class RentRoomsData {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "roomId")
        private Long roomId;

        @Column(name = "price")
        private Integer price;

        @Column(name = "text")
        private String text;

        @Column(name = "breakfast")
        private Boolean breakfast;

        @Column(name = "howManyPeople")
        private Integer howManyPeople;

        @Column(name = "vegan_breakfast")
        private Boolean veganBreakfast;

        @Column(name = "date_on")
        private String dateOn;

        @Column(name = "date_off")
        private String dateOff;

}
