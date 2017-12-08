import java.util.ArrayList;
import javafx.scene.control.Button;
public class Board{
    private int[][] map;
    private Unit[][] units;
    int cols;
    int rows;
    Unit active;
    public Board(int x, int y){
        rows=x;
        cols=y;

        map = new int[x][y];
        units = new Unit[x][y];
        for (int i=0; i<x; i++){
            for (int j=0; j<y; j++){
                map[i][j]=3;
            }
        }
    }

    public boolean anySelected(){
        for (int i=0; i<8; i++){
            for (int j=0; j<6; j++){
                if (map[i][j]==2){return true;}
            }
        }
        return false;
    }

    public Unit[][] getMap(){
        return units;
    }

    public void setTile(int x, int y, Unit value){
        units[x][y]=value;
        map[x][y]=value.getType();
    }

    public void setTile(int x, int y){
        units[x][y]=null;
        map[x][y]=3;
    }

    public Unit getUnit(int x, int y){
        return units[x][y];
    }

    public Unit getSelectedUnit(){
        return active;
    }

    public boolean isUnit(int x, int y){
        if (map[x][y]==3||map[x][y]==5){
            return false;
        }
        return true;
    }

    public void placeUnit(Unit unit){
        units[unit.getXPos()][unit.getYPos()]=unit;
        map[unit.getXPos()][unit.getYPos()]=unit.getType();
    }

    public void setActive(Unit unit){
        for (int i=0; i<8; i++){
            for (int j=0; j<6; j++){
                if ((map[i][j]==1||map[i][j]==0)&&units[i][j]!=unit){
                    units[i][j].setSelected(false);
                }
                if (map[i][j]==0&&units[i][j]==unit){
                    active=unit;
                    active.setSelected(true);
                    map[i][j]=2;
                }
            }
        }
    }

    public void refreshBoard(Button[][] b){
        for (int i=0; i<8; i++){
            for (int j=0; j<6; j++){
                if (map[i][j]==2){
                    active.setSelected(false);
                    map[i][j]=units[i][j].getType();
                }
                if (b[i][j].getStyle().equals("-fx-background-color: #822828;")){
                    continue;
                }
                if (map[i][j]==0) {
                    b[i][j].setStyle("-fx-background-color: #4286f4; ");
                    b[i][j].setOpacity(0.4);
                }
                else if (map[i][j]==1){
                    b[i][j].setStyle("-fx-background-color: #822828; ");
                    b[i][j].setOpacity(0.4);
                }
                else {
                    b[i][j].setOpacity(0.0);
                    b[i][j].setStyle("-fx-background-color: #ffffff; ");
                }
            }
        }
    }
    
    public void unshowEnemyRange(Button[][] b){
        for (int i=0; i<8; i++){
            for (int j=0; j<6; j++){
                if (b[i][j].getStyle().equals("-fx-background-color: #822828; ")&&map[i][j]==3){
                    b[i][j].setOpacity(0.0);
                    b[i][j].setStyle("-fx-background-color: #ffffff; ");
                    System.out.println(i +" " +j +" set to white transparent");
                }
            }
        }
    }

    public ArrayList<Unit> checkOptions(int x, int y){
        int rng=0, inc=0;
        boolean both=false;
        if (active.getWeapon().isMelee()) {
            if (active.getWeapon().isRanged()){
                rng = 2; both=true;
            }
            else {
                rng=1;
            }
        }
        else {
            rng=2; 
        }
        ArrayList<Unit> eops = new ArrayList<Unit>();
        int ectr = 0;
        int diff=0;
        int type = -1;
        if (active.getType()==1) {System.out.println("Enemy is attacking."); type=0;}
        else {type=1;}
        for (int i=x+rng; i>=x-rng; i--){
            for (int j=y+rng; j>=y+-rng; j--){
                diff=Math.abs(x-i)+Math.abs(y-j);
                System.out.println(diff +" " +i +" " +j);
                if (both) {
                    if (diff==1||diff==2 && i>=0 && i<8 &&j>=0 && j<6){
                        if (map[i][j]==1){
                            eops.add(units[i][j]);
                        }
                    }
                }
                else if (rng==1 && diff==1 && map[i][j]==type && i>=0 && i<8 &&j>=0 && j<6){
                            eops.add(units[i][j]);
                    
                }
                else if (rng==2 && diff==2 && map[i][j]==type && i>=0 && i<8 &&j>=0 && j<6){
                            eops.add(units[i][j]);
                    }
                
            }
        }
        System.out.println(eops.size());
        return eops;
    }
    
    public void refreshBoard(int type){
        for (int i=0; i<8; i++){
            for (int j=0; j<6; j++){
                if (map[i][j]==type){
                    units[i][j].setSelected(false);
                }
            }
        }
    }

    public int getType(int x, int y){
        return map[x][y];
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }
}