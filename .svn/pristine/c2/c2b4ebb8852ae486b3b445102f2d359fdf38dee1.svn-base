/*
 * TCSS 305 - Autumn 2015
 * Assignment 3 - EasyStreet
 */

package model;

import java.util.Map;


/**
 * 
 * Represents a human and inherits from AbstractVehicle.
 * @author Tung Kong
 * @version 1 10/27/15
 *
 */
public class Human extends AbstractVehicle {
    
    /** Death time of a human. */
    private static final int DEATH_TIME = 45;
    
    /** The terrain that a human starts on. */
    private final Terrain myInitialTerrain;
    
    /**
     * Constructs a human object by calling parent class constructor.
     * @param theX x that humans start at.
     * @param theY y that humans start at.
     * @param theDir direction human initially faces.
     * @param theTerrain terrain human initially starts on.
     */
    public Human(final int theX, final int theY, final Direction theDir,
                 final Terrain theTerrain) {
        super(theX, theY, theDir, DEATH_TIME);
        myInitialTerrain = theTerrain;
    }

    /**
     * A human can travel on the terrain it initially starts on. If it starts on street,
     * it can also go through lights of any color and vice versa.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean passTerrain;
        if (myInitialTerrain == Terrain.STREET || myInitialTerrain == Terrain.LIGHT) {
            passTerrain = theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT;
        } else {
            passTerrain = theTerrain == myInitialTerrain;
        }
        return passTerrain;
    }

    /**
     * A human randomly chooses the direction it travels. Straight, left, right, or reverse.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction randDir;
        do {
            randDir = Direction.random();
        } while (!canPass(theNeighbors.get(randDir), null));
        return randDir;
    }



}
