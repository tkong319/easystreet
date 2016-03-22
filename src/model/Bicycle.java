/*
 * TCSS 305 - Autumn 2015
 * Assignment 3 - EasyStreet
 */

package model;

import java.util.Map;

/**
 * 
 * Represents a bicycle and inherits from AbstractVehicle.
 * @author Tung Kong
 * @version 1 10/27/15
 *
 */
public class Bicycle extends AbstractVehicle {
    
    
    /** Death time of a bicycle. */
    private static final int DEATH_TIME = 25;
    
    /**
     * Constructs a bicycle object by calling parent class constructor.
     * @param theX x that bike starts at.
     * @param theY y that bike starts at.
     * @param theDir direction the bike initially faces.
     */
    public Bicycle(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
    }
    
    /**
     * A bicycle can go on trail, streets, or green lights.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.TRAIL || theTerrain == Terrain.STREET 
                        || theTerrain == Terrain.LIGHT && theLight == Light.GREEN;
    }
    
    /**
     * A bicycle prefers to go on trail, but if trail is not an option,
     * it would prefer to go straight on a street. If it can't go straight, 
     * it will go left. If it can't go left, it will go right. And if all is not an option, 
     * it will reverse.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction desiredDir;
        if (theNeighbors.get(getDirection()) == Terrain.TRAIL) {
            desiredDir = getDirection();
        } else if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
            desiredDir = getDirection().left();
        } else if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
            desiredDir = getDirection().right();
        } else if (theNeighbors.get(getDirection()) == Terrain.STREET 
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
