import java.util.ArrayList;
import java.util.List;

public class Battleship
{
    private List<Player> players;

    public Battleship()
    {
        players = new ArrayList<Player>();//makes a new arraylist of players

    }

    public Player getPlayer(int i)
    {
        return players.get(i);//returns player
    }

    public void addPlayer(Player player)
    {
        players.add(player);//adds a player to players
    }

    /**
     * Remove any Players from the players List
     *   if all of their ships have been sunk.
     */
    public void upkeep()
    {
        for (int i = players.size() - 1; i >= 0; i--)//loops through players
        {
            if(players.get(i).getNumberOfShips() == 0)//if the num of ships is 0, player is removed
                players.remove(players.get(i));
        }
    }

    /**
     * Returns true if only one Player remains in
     *   the players List; false otherwise.
     *
     * @return
     */
    public boolean gameOver()
    {
        return players.size() == 1;//game over if only 1 player left
    }

    /**
     * Returns the only Player remaining in the
     *   players List if the game is over; returns
     *   null otherwise.
     *
     * @return
     */
    public Player getWinner()
    {
        if (gameOver())//if game over is true
            return players.get(0);//get the last player standing
        return null;
    }
}
