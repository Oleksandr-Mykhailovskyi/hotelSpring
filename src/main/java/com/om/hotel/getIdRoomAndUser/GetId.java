package com.om.hotel.getIdRoomAndUser;

public class GetId {
    Long idUser;
    Long IdRoom;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUSer(Long idUSer) {
        this.idUser = idUSer;
    }

    public Long getIdRoom() {
        return IdRoom;
    }

    public void setIdRoom(Long idRoom) {
        IdRoom = idRoom;
    }

    public GetId(Long idUser, Long idRoom) {
        this.idUser = idUser;
        this.IdRoom = idRoom;
    }
}
