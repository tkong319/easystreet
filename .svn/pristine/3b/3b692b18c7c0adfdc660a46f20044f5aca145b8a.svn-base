/*
 * TCSS 305 - Autumn 2015
 * Assignment 3 - EasyStreet
 */

package model;

import java.util.Map;

/**
 * 
 * Represents a car and inherits from AbstractVehicle.
 * @author Tung Kong
 * @version 1 10/27/15
 *
 */
public class Car extends AbstractVehicle {
    
    /** Death time of a Car. */
    private static final int DEATH_TIME = 5;
    
    /**
     * Constructs a car object by calling parent class constructor.
     * @param theX x car starts at.
     * @param theY y car starts at.
     * @param theDir direction car initially faces.
     */
    public Car(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
    }
    

    /**
     * A car can travel on streets and through lights if green or yellow. If light is red,
     * it stops and waits for it to change color.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT 
                        && (theLight == Light.GREEN || theLight == Light.YELLOW);
    }
    
    

    /**
     * A car prefers to go straight. If not straight then right. If not right then left.
     * If none of those options are legal, it will reverse
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction desiredDir;
        
        if (theNeighbors.get(getDirection()) == Terrain.STREET 
                        || theNeighbors.get(getDirection()) == Terrain.LIGHT) {
            desiredDir = getDirection();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.STREET 
                        || theNeighbors.get(getDirection().left()) == Terrain.LIGHT) {
            desiredDir = getDirection().left();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.STREET 
                        || theNeighbors.get(getDirection().right()) == Terrain.LIGHT) {
            desiredDir = getDirection().right();
        } else {
            desiredDir = getDirection().reverse();
        }
        return desiredDir;
    }



}
