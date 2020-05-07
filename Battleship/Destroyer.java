public class Destroyer extends Ship
{
    /**
     * Construct a Destroyer with a length
     * of 4 and the specified Locations.
     *
     * @param locations
     */
    public Destroyer(Location... locations)
    {
        super(4);//creates ship with length 4
        addLocation(locations);//adds location to locations
    }
}