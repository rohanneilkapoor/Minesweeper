import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;
public class Board extends Actor
{
    public static int row;
    public static int col;
    public static int bombs;
    public static Grid<Actor> gr;
    public static void main(String[] args)
    {
        row = 10;
        col = 10;
        bombs = 15;
        ActorWorld world = new ActorWorld(mineGrid());
        
        for(int i = 0; i < bombs; i++)
        {
            Bomb bomb = new Bomb();
            bomb.setColor(null);
            world.add(bomb);
        }
        world.show();
    }
    public static Grid<Actor> mineGrid()
    {
        gr = new BoundedGrid<Actor>(row,col); 
        return gr;
    }
}