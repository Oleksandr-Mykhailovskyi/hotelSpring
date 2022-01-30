package com.om.hotel.getIdRoomAndUser;

public class GetId {
    Long idUSer;
    Long IdRoom;

    public Long getIdUSer() {
        return idUSer;
    }

    public void setIdUSer(Long idUSer) {
        this.idUSer = idUSer;
    }

    public Long getIdRoom() {
        return IdRoom;
    }

    public void setIdRoom(Long idRoom) {
        IdRoom = idRoom;
    }

    public GetId(Long idUSer, Long idRoom) {
        this.idUSer = idUSer;
        IdRoom = idRoom;
    }
}
