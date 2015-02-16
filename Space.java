import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;
public class Space extends Actor
{
    public int bombCount;
    public void reveal()
    {
        Grid<Actor> gr = getGrid();
        ActorWorld world = Board.world;
        for(int i = 0; i < Board.bombList.size(); i++)
        {
            if(this.getLocation().equals(Board.bombList.get(i).getLocation()))
            {
                world.remove(getLocation());
                Bomb bomb = new Bomb();
                bomb.setColor(null);
                world.add(bomb);
                showEverything(gr);
                if( i == 0)
                {
                    System.out.println("Bomb has been set off.");
                    System.out.println("Game over. You lose");
                }
                return;
            }
        }
        bombCount = 0;
        for(int i = 0; i < findLocs(getLocation()).size(); i++)
        {
            for(int j = 0; j < Board.bombList.size(); j++)
            {
                if(findLocs(getLocation()).get(i).equals(Board.bombList.get(j).getLocation()))
                {
                    bombCount++;
                }
            }
        }
        if(bombCount == 1)
        {
            world.remove(getLocation());
            One one = new One();
            one.setColor(null);
            world.add(one);
            return;
        }
        else if(bombCount == 2)
        {
            world.remove(getLocation());
            Two two = new Two();
            two.setColor(null);
            world.add(two);
            return;
        }
        else if(bombCount == 3)
        {
            world.remove(getLocation());
            Three three = new Three();
            three.setColor(null);
            world.add(three);
            return;
        }
        else if(bombCount == 4)
        {
            world.remove(getLocation());
            Four four = new Four();
            four.setColor(null);
            world.add(four);
            return;
        }
        else if(bombCount == 5)
        {
            world.remove(getLocation());
            Five five = new Five();
            five.setColor(null);
            world.add(five);
            return;
        }
        else if(bombCount == 6)
        {
            world.remove(getLocation());
            Six six = new Six();
            six.setColor(null);
            world.add(six);
            return;
        }
        else if(bombCount == 7)
        {
            world.remove(getLocation());
            Seven seven = new Seven();
            seven.setColor(null);
            world.add(seven);
            return;
        }
        else if(bombCount == 8)
        {
            world.remove(getLocation());
            Eight eight = new Eight();
            eight.setColor(null);
            world.add(eight);
            return;
        }
        else
        {
            ArrayList<Actor> neigh = gr.getNeighbors(getLocation());
            ArrayList<Location> neighLoc = new ArrayList<Location>();
            for(int i = 0; i < neigh.size(); i++)
            {
                neighLoc.add(neigh.get(i).getLocation());
            }
            world.remove(getLocation());
            Zero zero = new Zero();
            zero.setColor(null);
            world.add(zero);
            for(Location l : neighLoc)
            {
                if(gr.get(l) instanceof Empty)
                {
                    Space x = (Space) gr.get(l);
                    x.reveal();
                }
            }
        }
    }
    public void showEverything(Grid<Actor> a)
    {
        for(int i = 0; i < Board.row; i++)
        {
            for(int j = 0; j < Board.col; j++)
            {
                Location loc1 = new Location(i,j);
                if(a.get(loc1) instanceof Empty)
                {
                    Space x = (Space) a.get(loc1);
                    x.reveal();
                }
            }
        }
    }
    public void showBombs()
    {
        for(int x = 0; x < Board.bombList.size(); x++)
        {
            for(int j = 0; j < Board.row; j++)
            {
                for(int k = 0; k < Board.col; k++)
                {
                    Location loc1 = new Location(j,k);
                    if(loc1.equals(Board.bombList.get(x).getLocation()))
                    {
                        Board.world.remove(loc1);
                        Bomb bomb1 = new Bomb();
                        bomb1.setColor(null);
                        Board.world.add(bomb1);
                    }
                }
            }
        }
    }
    public void flag()
    {
        ActorWorld world = Board.world;
        Flag flag = new Flag();
        flag.setColor(null);
        world.remove(getLocation());
        world.add(flag);
        Board.flagCount++;
        for(int i = 0; i < Board.bombList.size(); i++)
        {
            if(flag.getLocation().equals(Board.bombList.get(i).getLocation()))
            {
                Board.flagCountOnBomb++;
            }
        }
        if(Board.flagCountOnBomb == Board.bombs && Board.flagCount == Board.bombs)
        {
            System.out.println("You have successfully flagged all " + Board.bombs + " bombs. You win.");
        }
    }
    public ArrayList<Location> findLocs(Location loc)
    {
        ArrayList<Location> allLocs = new ArrayList<Location>();
        Location ahead = loc.getAdjacentLocation(getDirection());
        Location halfRight = loc.getAdjacentLocation(getDirection() + 45);
        Location right = loc.getAdjacentLocation(getDirection() + 90);
        Location threeQuartRight = loc.getAdjacentLocation(getDirection() + 135);
        Location behind = loc.getAdjacentLocation(getDirection() + 180);
        Location threeQuartLeft = loc.getAdjacentLocation(getDirection() - 135);
        Location left = loc.getAdjacentLocation(getDirection() - 90);
        Location halfLeft = loc.getAdjacentLocation(getDirection() - 45);
        
        allLocs.add(ahead);
        allLocs.add(halfRight);
        allLocs.add(right);
        allLocs.add(threeQuartRight);
        allLocs.add(behind);
        allLocs.add(threeQuartLeft);
        allLocs.add(left);
        allLocs.add(halfLeft);
        return allLocs;
    }
}