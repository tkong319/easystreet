/*
 * TCSS 305 - Autumn 2015
 * Assignment 3 - EasyStreet
 */

package model;

import java.util.Map;

/**
 * 
 * Represents an ATV and inherits from AbstractVehicle.
 * @author Tung Kong
 * @version 1 10/27/15
 *
 */
public class Atv extends AbstractVehicle {
    
    /** Death time of ATV. */
    private static final int DEATH_TIME = 15;
    
    /**
     * Constructs Atv object by calling parent class constructor.
     * @param theX x that atv starts at.
     * @param theY y that atv starts at.
     * @param theDir direction atv initially faces.
     */
    public Atv(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
    }

    /**
     * An Atv can travel on any terrain except walls.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain != Terrain.WALL;
    }

    /**
     * An Atv randomly chooses to go straight, left, or right and never reverses.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction randDir;
        do {
            randDir = Direction.random();
        } while (randDir == getDirection().reverse() 
                        || !canPass(theNeighbors.get(randDir), null));
        
        return randDir;
    }



}
