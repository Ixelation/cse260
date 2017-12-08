import javafx.scene.image.*;
import java.util.*;
import java.lang.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
/**
 * Write a description of class Unit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Unit
{
    // instance variables - replace the example below with your own
    LinkedHashMap<String, Integer> stats = new LinkedHashMap<String, Integer>();
    //    private int HP;
    //    private int STR;
    //    private int DEF;
    //    private int SPD;
    //    private int MAG;
    //    private int SKL;
    //    private int LCK;
    //    private int RES;
    //    private int RNG;
    private boolean isSelected;
    private boolean hasActed;
    private int XPOS;
    private int YPOS;
    private Image mugshot;
    private Weapon weapon;
    private String name;
    public ImageView map;
    public ImageView battle;
    private int oghp;
    private boolean rangeShowing;
    private int type; //type of unit, player (0) or enemy (1), (3) is empty spacemust implement blocking
    /*
     * Constructor class for the Unit character.  This constructor takes in parameters
     * for their stats as well as their name and weapon.
     * 
     * TO DO: maybe add a class, probably unnecessary since there will only be one level
     */
    public Unit(Image mug, int hp, int x, int y, int strength, int magic, int skill,
    int speed, int luck, int defense, int resistance, int range, Weapon arms, String name, int type){
        weapon=arms;
        this.name=name;
        XPOS=x;
        YPOS=y;
        mugshot=mug;
        hasActed=false;
        oghp=hp;
        stats.put("HP", hp);
        stats.put("STR", strength);
        stats.put("MAG", magic);
        stats.put("SKL", skill);
        stats.put("SPD", speed);
        stats.put("LCK", luck);
        stats.put("DEF", defense);
        stats.put("RES", resistance);
        stats.put("MOV", range);
        stats.put("AS", stats.get("SPD") - (this.weapon.getWeight() - stats.get("STR")));
        stats.put("PP", stats.get("STR") + this.weapon.getMight());
        stats.put("MP", stats.get("MAG") + this.weapon.getMight());        
        stats.put("CR", weapon.getCrit() + (stats.get("SKL")/2));
        stats.put("CE", stats.get("LCK"));
        stats.put("ACC", weapon.getHit() + stats.get("SKL") + (stats.get("LCK")/2));
        stats.put("AVO", stats.get("AS") + (stats.get("LCK")/2));
        this.type=type;
    }

    public Unit(Unit unit){
        this.weapon=unit.getWeapon();
        this.name=unit.getName();
        this.XPOS=unit.getXPos();
        this.YPOS=unit.getYPos();
        this.mugshot=unit.getMug();

        stats.put("HP", this.getStats().get("HP"));
        stats.put("STR", this.getStats().get("STR"));
        stats.put("MAG", this.getStats().get("MAG"));
        stats.put("SKL", this.getStats().get("SKL"));
        stats.put("SPD", this.getStats().get("SPD"));
        stats.put("LCK", this.getStats().get("LCK"));
        stats.put("DEF", this.getStats().get("DEF"));
        stats.put("RES", this.getStats().get("RES"));
        stats.put("MOV", this.getStats().get("MOV"));
        stats.put("AS", unit.getStats().get("SPD") - (this.weapon.getWeight() - unit.getStats().get("STR")));
        stats.put("PP", unit.getStats().get("STR") + this.weapon.getMight());
        stats.put("MP", unit.getStats().get("MAG") + this.weapon.getMight());        
        stats.put("CR", this.weapon.getCrit() + (unit.getStats().get("SKL")/2));
        stats.put("CE", unit.getStats().get("LCK"));
        stats.put("ACC", this.weapon.getHit() + unit.getStats().get("SKL") + (unit.getStats().get("LCK")/2));
        stats.put("AVO", unit.getStats().get("AS") + (unit.getStats().get("LCK")/2));
        this.type=unit.getType();
    }

    public Unit(int i){
        this.type=i;
    }

    public void move(int x, int y, Board board){
        board.setTile(this.getXPos(), this.getYPos());
        board.setTile(x, y, this);
        this.setXPos(x);
        this.setYPos(y);
        //animation????? no.
    }

    public void setActed(boolean boo){
        hasActed=boo;
    }

    /*
     * Attack method for attacking fellow units.  
     */
    public void battle(Unit enemy, VBox messages){
        Random rand = new Random();
        boolean uhit = false;
        boolean ehit = false;
        //SHIT DISPLAYED IN BATTLE MENU: DAMAGE, HIT, CRIT, # of attacks
        boolean unitDoubleAttack = false; //can attacker double
        boolean enemyDoubleAttack = false; //can defender double
        boolean enemyCounter = false; //whether or not the enemy (the one defending) can counter

        int ucc = 1; // critical coefficient
        int ecc = 1; // enemy crit coefficient
        int ubc = this.stats.get("CR") - enemy.getStats().get("CE"); // battle critical rate
        int ebc = enemy.getStats().get("CR") - this.stats.get("CE"); // enemy crit rate
        int damage=0;
        int uba = this.stats.get("ACC") - enemy.getStats().get("AVO"); // battle accuracy
        int eba = enemy.getStats().get("ACC") - this.stats.get("AVO"); // enemy accuracy
        int ucritroll = -1; //unit crit
        int ecritroll = -1; //enemy crit
        int uhitroll = 0;  // unit hit
        int ehitroll = 0; // enemy hit
        //int i=0; //loop counter for attack sequences
        boolean melee=false;
        if ((this.getXPos()==enemy.getXPos() && ((this.getYPos() -1 == enemy.getYPos())||(this.getYPos()+1 == enemy.getYPos())))
        || (this.getYPos()==enemy.getYPos() && ((this.getXPos() -1 == enemy.getXPos())||(this.getXPos()+1 == enemy.getXPos())))) {
            melee=true;
        }
        else {melee=false;}

        if ((this.getWeapon().isMelee()&&enemy.getWeapon().isMelee()) || (this.getWeapon().isRanged()&&enemy.getWeapon().isRanged())){
            enemyCounter=true; 
        }

        if (this.stats.get("AS") - enemy.getStats().get("AS") >= 4) {
            unitDoubleAttack = true; 
        } //can attacker double
        else if (enemyCounter && enemy.getStats().get("AS") - this.stats.get("AS") >= 4) {
            enemyDoubleAttack = true; 
        } //can defender double, only possible if unit can't
        //now we disp gui?
        String hit = "";
        uhitroll = (rand.nextInt()*100)+1;
        String dmg = "";
        String ehealth = "";
        String crit = "";
        if (uhitroll >=uba) {uhit=false;}
        else {uhit=true;}
        if (uhit) {hit = "hits";}
        else {hit = "misses";}
        if (uhit) {
            ucritroll = (rand.nextInt()*100)+1; 
            if (ucritroll <= ubc) {ucc=3; crit = "It's a critical!";} //crit or no
            else {ucc=1; crit = "It's a normal hit.";}
            enemy.setHP(enemy.getStats().get("HP") - ucc*damage(this, enemy));
            dmg = (" for " +ucc*damage(this, enemy) +" damage.");
            ehealth = (enemy.getName() +" now has " +enemy.getStats().get("HP") +" health remaining.");
            //attack animation, send crit maybe, but def miss val
        }
        messages.getChildren().add(new Label((this.getName() +" " +hit +" " +enemy.getName() +"" +dmg +"" +crit +" " +ehealth)));

        if (enemy.getStats().get("HP")<=0){messages.getChildren().add(new Label(enemy.getName() +" is dead.")); return;}
        try        
        {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }
        if (enemyCounter){
            ehitroll = (rand.nextInt()*100)+1;
            if (ehitroll >=eba) {ehit=true; hit = "hits";}
            else {ehit=false; hit = "misses";}
            if (ehit) {
                ecritroll = (rand.nextInt()*100)+1;
                if (ecritroll <= ebc) {ecc=3;  crit = "It's a critical hit!";} //enemy crit
                else {ecc=1;  crit = "It's a normal hit.";}
                this.setHP(this.getStats().get("HP") - ecc*damage(enemy, this));
                dmg = (" for " +ucc*damage(enemy, this) +" damage.");

                ehealth = (this.getName() +" now has " +this.getStats().get("HP") +" health remaining.");

                //disp anim
            }
        }
        if (this.getStats().get("HP")==0){this.die(); return;}

        messages.getChildren().add(new Label((enemy.getName() +" " +hit +" "  +this.getName() +"" +dmg +"" +crit +" " +ehealth)));
        if (this.getStats().get("HP")<=0){messages.getChildren().add(new Label(enemy.getName() +" is dead.")); return;}

        try        
        {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }

        if (enemyDoubleAttack){
            ehitroll = (rand.nextInt()*100)+1;
            if (ehitroll >=eba) {ehit=true; hit = "hits";}
            else {ehit=false; hit = "misses";}
            if (ehit) {
                ecritroll = (rand.nextInt()*100)+1;
                if (ecritroll <= ebc) {ecc=3;  crit = "It's a critical hit!";} //enemy crit
                else {ecc=1;  crit = "It's a normal hit.";}
                this.setHP(this.getStats().get("HP") - ecc*damage(enemy, this));
                dmg = (" for " +ucc*damage(enemy, this) +" damage.");

                ehealth = (this.getName() +" now has " +this.getStats().get("HP") +" health remaining.");

                //disp anim
            }

            if (this.getStats().get("HP")==0){this.die(); return;}

            messages.getChildren().add(new Label((enemy.getName() +" " +hit +" " +crit +" " +this.getName() +"" +dmg +"" +ehealth)));
            try        
            {
                Thread.sleep(1000);
            } 
            catch(InterruptedException ex) 
            {
                Thread.currentThread().interrupt();
            }
        }
        else {
            if (unitDoubleAttack){
                uhitroll = (rand.nextInt()*100)+1;
                if (uhitroll >=uba) {uhit=false;}
                else {uhit=true;}
                if (uhit) {hit = "hits";}
                else {hit = "misses";}
                if (uhit) {
                    ucritroll = (rand.nextInt()*100)+1; 
                    if (ucritroll <= ubc) {ucc=3;  crit = "It's a critical!";} //crit or no
                    else {ucc=1;  crit = "It's a normal hit.";}
                    enemy.setHP(enemy.getStats().get("HP") - ucc*damage(this, enemy));
                    dmg = (" for " +ucc*damage(this, enemy) +" damage.");
                    ehealth = (enemy.getName() +" now has " +enemy.getStats().get("HP") +" health remaining.");
                    //attack animation, send crit maybe, but def miss val
                }
                if (enemy.getStats().get("HP")==0){enemy.die(); return;}
                messages.getChildren().add(new Label((this.getName() +" " +hit +" " +crit +" " +enemy.getName() +"" +dmg +"" +ehealth)));
                try        
                {
                    Thread.sleep(1000);
                } 
                catch(InterruptedException ex) 
                {
                    Thread.currentThread().interrupt();
                }
            }
            this.setActed(true);
        }
    }

    public int damage(Unit unit, Unit enemy){
        int cc = 1; // critical coefficient
        int bc = unit.getStats().get("CR") - enemy.getStats().get("CE"); // battle critical rate
        int damage=0;
        int ba = unit.getStats().get("ACC") - enemy.getStats().get("AVO"); // battle accuracy
        if ((unit.getXPos()==enemy.getXPos() && ((unit.getYPos() -1 == enemy.getYPos())||(unit.getYPos()+1 == enemy.getYPos())))
        || (unit.getYPos()==enemy.getYPos() && ((unit.getXPos() -1 == enemy.getXPos())||(unit.getXPos()+1 == enemy.getXPos())))) {
            //if enemy is at melee distance
            damage = (unit.stats.get("PP") - enemy.getStats().get("DEF"));
        }
        else {
            //if enemy is at range
            if (unit.getWeapon().getName().indexOf("Bow")!=-1) {
                damage = (unit.stats.get("PP") - enemy.getStats().get("DEF"));
                //if unit has physical ranged attack, only works for bows
            }
            else {
                damage = (unit.stats.get("MP") - enemy.getStats().get("RES"));
                //all other ranged unit is magic, even Ruby because that's why she has low magic stat
            }
        }
        if (damage<0) {return 0;}
        else {return damage;}
    }

    public Image getMug(){
        return mugshot;
    }

    public int getXPos(){
        return XPOS;
    }

    public int getYPos(){
        return YPOS;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public String getName(){
        return name;
    }

    public void setHP(int health){
        stats.put("HP", health);
    }

    public LinkedHashMap<String, Integer> getStats(){
        return stats;
    }

    public void wait(Board b){
        this.hasActed=true;
        this.isSelected=false;
        b.setTile(this.getXPos(), this.getYPos(), this);
    }

    public void die(){
        //         map(this.getXPos(), this.getYPos())=3;
        //         units[this.getXPos()][this.getYPos()]=new Unit(3);
    }

    public void setSelected(boolean boo){
        isSelected=boo;
    }

    public void setMapView(ImageView iv){
        map = iv;
    }

    public ImageView getMapView(){
        return map;
    }

    public int getType(){
        return type;
    }

    public boolean rangeShown(){
        return rangeShowing;
    }

    public void setXPos(int x){
        XPOS=x;
    }

    public void setRangeShown(boolean x){
        rangeShowing=x;
    }

    public void setYPos(int x){
        YPOS=x;
    }

    public int getOGHP(){
        return oghp; //returns original HP as in full health, the actual HP stat will be the amount of health the unit has remaining
    }
}
