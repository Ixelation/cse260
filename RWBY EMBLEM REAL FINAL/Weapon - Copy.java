//NEVER MIND EACH GIRL HAS THEIR OWN WEAPON WHAT'S THE POINT
/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon
{
    // instance variables - replace the example below with your own
    private int MGT;
    private int HIT;
    private int WGT;
    private int CRT;
    private boolean isMelee;
    private boolean isRanged;
    private String name;
    /**
     * Constructor for objects of class Weapon
     */
    public Weapon(int might, int hit, int weight, int crit, boolean melee, boolean ranged, String name)
    {
        MGT=might;
        this.HIT=hit;
        WGT=weight;
        CRT = crit;
        isMelee=melee;
        isRanged=ranged;
        this.name = name;
    }

    /*
     * Method for retrieving weight of a weapon for use in battle calculations. 
     */
    public int getWeight(){
        return WGT;
    }
    
    /*
     * Method for retrieving hit of a weapon for use in battle calculations.
     */
    public int getHit(){
        return HIT;
    }
    
    /*
     * Method for retrieving might of a weapon for battle calculations.
     */
    public int getMight(){
        return MGT;
    }
    
    public int getCrit(){
        return CRT;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean isMelee(){
        return isMelee;
    }
    
    public boolean isRanged(){
        return isRanged;
    }
}
