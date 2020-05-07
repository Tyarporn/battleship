import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Player
{
    private String name;
    private List<Ship> ships;
    private int[][] guessBoard;

    public Player(String name)
    {
        this.name=name;//initializes name
        ships = new ArrayList<Ship>();//creates array of ships
        guessBoard = new int[10][10];//initializes 10x10 guessboard
        populateShips();//populates ships
    }

    public String getName()
    {
        return name;//returns name
    }

    /**
     * Returns how many ships are currently in this
     *   Player's ships List.
     *
     * @return
     */
    public int getNumberOfShips()
    {
        return ships.size();//returns number of ships is
    }

    /**
     * Returns the ship that occupies the specified
     *   Location loc.  Returns null if this Player
     *   does not control a ship at Location loc.
     *
     * @param loc
     * @return
     */
    public Ship getShip(Location loc)
    {
        for (Ship ship : ships)//loops through all ships and their locations to find if the loc is equal to l
            for(Location l : ship.getLocations())
                if(loc.equals(l))
                    return ship;//returns the ship
        return null;

    }

    public void addShip(Ship ship)
    {
        ships.add(ship);//adds ship to ships
    }

    public void removeShip(Ship ship)
    {
        ships.remove(ship);//removes ship
    }

    /**
     * Returns true if this Player controls a ship
     *   at the specified Location loc; false
     *   otherwise.
     *
     * @param loc
     * @return
     */
    public boolean hasShipAtLocation(Location loc)
    {
        for (Ship ship : ships)//loops through all ships and their locations to find if the loc is equal to l
            for(Location l : ship.getLocations())
                if(loc.equals(l))//returns if a ship is detected
                    return true;
        return false;
    }

    public int[][] getGuessBoard()
    {
        return guessBoard;//gets the guessboard
    }

    /**
     * Returns true if obj is an instanceof Player and
     *   instance variables are equivalent.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Player && ((Player) obj).getName().equals(name);//checks if the object is an instance of player
    }

    /**
     * Attack the specified Player at the specified Location.
     *
     * Return true if the attack resulted in a ship sinking;
     *   false otherwise.
     *
     * @param enemy
     * @param loc
     * @return
     */
    public abstract boolean attack(Player enemy, Location loc);

    /**
     * Construct an instance of
     *
     *   AircraftCarrier,
     *   Destroyer,
     *   Submarine,
     *   Cruiser, and
     *   PatrolBoat
     *
     * and add them to this Player's list of ships.
     */
    public abstract void populateShips();
}
