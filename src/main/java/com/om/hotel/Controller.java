package com.om.hotel;

import com.om.hotel.getIdRoomAndUser.GetId;
import com.om.hotel.rentRoomsDataBase.RentRoomsData;
import com.om.hotel.rentRoomsDataBase.RentRoomsRepository;
import com.om.hotel.room.Room;
import com.om.hotel.room.RoomRepository;
import com.om.hotel.sendEmail.SendMail;
import com.om.hotel.userDataBase.UserRepository;
import com.om.hotel.userInfoDataBase.UserInfo;
import com.om.hotel.userInfoDataBase.UserInfoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
class Controller {

    private RentRoomsRepository rentRoomsRepository;

    private UserRepository userRepository;

    private RoomRepository roomRepository;

    private UserInfoRepository userInfoRepository;

    private SendMail sendMail;

    public Controller(RoomRepository roomRepository,
                      UserRepository userRepository,
                      UserInfoRepository userInfoRepository,
                      RentRoomsRepository rentRoomsRepository,
                      SendMail sendMail) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.userInfoRepository = userInfoRepository;
        this.rentRoomsRepository = rentRoomsRepository;
        this.sendMail = sendMail;
    }

    @GetMapping("/sayHi")
    public String sayHi() {
        return "Say HelloWorld";
    }

//    @GetMapping("/get/guestInfo")
//    public List<GuestInfo> guestInfo() {
//        List<Room> allByIsFreeAndIsReady = roomRepository.findAllByIsFreeAndIsReady(true, true);
//
//        List<GuestInfo> collect = allByIsFreeAndIsReady.stream()
//                .map(n -> new GuestInfo(n.getId(), n.getImg(), n.getText(), n.getPrice(), n.getHowManyPeople(), n.getBreakfast()))
//                .collect(Collectors.toList());
//
//        return collect;
//    }
//
//    @GetMapping("/rent/{id}")
//    public Room Rent(@PathVariable Long id) {
//        Room room = roomRepository.findById(id).orElseThrow();
//        room.setIsFree(false);
//        return roomRepository.save(room);
//    }

    @GetMapping("/rent/{id}")
    public Room Rent(@PathVariable Long id) {
        return roomRepository.findById(id).orElseThrow();
    }

    @PostMapping("/info")
    public void setUser(@RequestBody UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }

    @PostMapping("/room")
    public void setRentUser(@RequestBody RentRoomsData room){
         rentRoomsRepository.save(room);
    }

    @PostMapping("/sendEmail")
    public void sendMail(@RequestBody GetId id){
        Long idRoom = id.getIdRoom();
        Long idUSer = id.getIdUSer();
        sendMail.send(idUSer, idRoom);
    }
}
