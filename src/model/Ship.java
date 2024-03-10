package model;

import model.types.ShipStatus;

public class Ship {
    Integer id;
    String shipName;
    ShipStatus shipStatus;
    Integer size;

    Integer row;
    Integer col;

    public Ship(Integer id, String shipName, Integer size, Integer row, Integer col) {
        this.id = id;
        this.shipName = shipName;
        this.shipStatus = ShipStatus.HEALTHY;
        this.size = size;
        this.row = row;
        this.col = col;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public ShipStatus getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(ShipStatus shipStatus) {
        this.shipStatus = shipStatus;
    }
}
