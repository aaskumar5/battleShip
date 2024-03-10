package model;

import model.types.GridState;
import model.types.ShipStatus;

public class Grid {
    Integer row;
    Integer col;
    Player player;
    GridState gridState;
    Ship ship;

    public Grid(Integer row,Integer col) {
        this.row = row;
        this.col = col;
        gridState = GridState.SAFE;
    }
    public void printGrid(){
        System.out.print(gridState+ ":" + player.name + " ");
        if(ship != null){
            System.out.print(gridState+ ":" + player.name + ":"+ ship.shipName+" ");
//            System.out.print(ship.shipName + " ");
        } else {
            System.out.print(gridState+ ":" + player.name + "      ");
        }
    }

    public void distroyGrid(Game game){
        this.setGridState(GridState.DISTOYED);
        ship.setShipStatus(ShipStatus.DISTROYED);
        if (ship != null){
            for(int i=ship.row;i<ship.row+ship.size;i++){
                for(int j=ship.col;j<ship.col+ship.size;j++){
                    game.getBattleField().getGrids().get(i).get(j).setGridState(GridState.DISTOYED);
                }
            }
        }
    }

    public boolean isEmptyGrid(){
        return this.ship == null;
    }

    public GridState getGridState() {
        return gridState;
    }

    public void setGridState(GridState gridState) {
        this.gridState = gridState;
    }

    public Ship getShip() {
        return ship;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
    }
}
