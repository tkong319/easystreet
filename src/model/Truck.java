/*
 * TCSS 305 - Autumn 2015
 * Assignment 3 - EasyStreet
 */

package model;

import java.util.Map;

/**
 * 
 * Represents a truck and inherits from AbstractVehicle.
 * @author Tung Kong
 * @version 1 10/27/15
 *
 */
public class Truck extends AbstractVehicle {
    
    /** Death time of a truck, 0 because it does not die. */
    private static final int DEATH_TIME = 0;
    
    /**
     * Constructs a truck object by calling parent class constructor.
     * @param theX x that truck starts at.
     * @param theY y that truck starts at.
     * @param theDir direction a truck initially faces.
     */
    public Truck(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
    }

    /**
     * A truck can drive on streets and through lights of any color.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT;
        
        
    }

    /**
     * A truck prefers to randomly choose straight, left or right. If none of those are legal,
     * it will reverse.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction randDir;
        Direction temp;
        Direction temp2;
        do {
            randDir = Direction.random();
        } while (randDir == getDirection().reverse());
        temp = randDir;
        if (!canPass(theNeighbors.get(randDir), null)) {
            do {
                randDir = Direction.random();
            } while (randDir == getDirection().reverse() || randDir == temp);
        }
        temp2 = randDir;
        if (!canPass(theNeighbors.get(randDir), null)) {
            do {
                randDir = Direction.random();
            } while (randDir == getDirection().reverse() 
                            || randDir == temp || randDir == temp2);
        }
        if (!canPass(theNeighbors.get(randDir), null)) {
            randDir = getDirection().reverse();
        }
        return randDir;
    }
    

}
