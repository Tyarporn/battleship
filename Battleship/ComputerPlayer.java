import java.util.Random;

public class ComputerPlayer extends Player
{
    public ComputerPlayer(String name)
    {
        super(name);//creates new player with name
    }

    /**
     * Randomly chooses a Location that has not been
     *   attacked (Location loc is ignored).  Marks
     *   the attacked Location on the guess board
     *   with a positive number if the enemy Player
     *   controls a ship at the Location attacked;
     *   otherwise, if the enemy Player does not
     *   control a ship at the attacked Location,
     *   guess board is marked with a negative number.
     *
     * If the enemy Player controls a ship at the attacked
     *   Location, the ship must add the Location to its
     *   hits taken.  Then, if the ship has been sunk, it
     *   is removed from the enemy Player's list of ships.
     *
     * Return true if the attack resulted in a ship sinking;
     *   false otherwise.
     *
     * @param enemy The Player to attack.
     * @param loc The Location to attack.
     * @return
     */
    @Override
    public boolean attack(Player enemy, Location loc)
    {

            loc = new Location((int)(Math.random() *10),(int)(Math.random() *10));//assigns loc to a random location

        while(getGuessBoard()[loc.getRow()][loc.getCol()] != 0)//while the loc assigned is already guessed, the location is randomized again
            loc = new Location((int)(Math.random() *10),(int)(Math.random() *10));

        if(enemy.hasShipAtLocation(loc))//if the enemy has a ship at location:
        {
            enemy.getShip(loc).takeHit(loc);//enemy ship is hit
            super.getGuessBoard()[loc.getRow()][loc.getCol()] = 1;//updates comp player
            if(enemy.getShip(loc).isSunk())//if the ship is sunk the ship is removed
            {
                enemy.removeShip(enemy.getShip(loc));
                return true;
            }
        }
        else
            super.getGuessBoard()[loc.getRow()][loc.getCol()] = -1;//if its a miss, guessboard is updated to -1



        return false;
    }

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
    @Override
    public void populateShips()
    {
        AircraftCarrier a = new AircraftCarrier(new Location(0,0), new Location(0,1), new Location(0,2), new Location(0,3), new Location(0,4));
        Cruiser c = new Cruiser(new Location(2,0), new Location(2,1), new Location(2,2));
        Destroyer d = new Destroyer(new Location(1,0), new Location(1,1), new Location(1,2), new Location(1,3));
        PatrolBoat p = new PatrolBoat(new Location(3,0), new Location(3,1));
        Submarine s = new Submarine(new Location(4,0), new Location(4,1), new Location(4,2));

        addShip(a);//populates the guessboard with ships (hardcoded)
        addShip(c);
        addShip(d);
        addShip(p);
        addShip(s);
    }
}
