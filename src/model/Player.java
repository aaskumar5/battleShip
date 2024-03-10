package model;

import java.util.List;
import java.util.Scanner;

public class Player {
    Integer id;
    String name;

    List<Ship> ships;

    public Player(Integer id,String name,List<Ship> ships) {
        this.id = id;
        this.name = name;
        this.ships = ships;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

//    public void attack(Scanner sc){
//        System.out.println(name + " chance for next move ");
//
//
//    }
}
