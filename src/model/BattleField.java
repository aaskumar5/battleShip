package model;

import java.util.ArrayList;
import java.util.List;

public class BattleField {
    List<List<Grid>> grids;
    Integer dimension;

    public BattleField(Integer dimension){
        grids = new ArrayList<>();
        this.dimension = dimension;

        for(int i=0;i<dimension;i++){
            grids.add(new ArrayList<>());
            for(int j=0;j<dimension;j++){
                grids.get(i).add(new Grid(i,j));
            }
        }
    }

    public void printBattleField() {
        for( List<Grid> grids : grids){
            for(Grid grid : grids){
                grid.printGrid();
            }
            System.out.println();
        }
    }

    public Integer getDimension() {
        return dimension;
    }

    public List<List<Grid>> getGrids() {
        return grids;
    }
}
