import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Ship
{
    private int length;
    private List<Location> locations;
    private List<Location> hitsTaken;

    public Ship(int length)
    {
        this.length=length;//initializes length
        locations = new ArrayList<Location>();//makes an arraylist of locations
        hitsTaken = new ArrayList<Location>();//makes an array list of locations for the hits taken
    }

    public void addLocation(Location... loc)
    {
        Collections.addAll(locations,loc);//adds a locs to locations
    }

    public List<Location> getLocations()
    {
        return locations;//returns locations
    }

    /**
     * Add Location loc to hitsTaken.
     *
     * @param loc
     */
    public void takeHit(Location loc)
    {
        hitsTaken.add(loc);//adds a location to hits taken
    }

    /**
     * Returns true if the number of hits taken is
     *   equal to the length of this ship.
     *
     * @return
     */
    public boolean isSunk()
    {
        return hitsTaken.size() == length;//if the hits taken is equal to the length, then the ship is sunk
    }
}
