import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.Color;
import java.util.ArrayList;
public class Bomb extends Actor
{
    public boolean explode;
    public Bomb()
    {
        explode = false;
    }
    public void explode()
    {
        explode = true;
    }
}