package com.om.hotel.rentRoomsDataBase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRoomsRepository extends JpaRepository<RentRoomsData, Long> {

}
