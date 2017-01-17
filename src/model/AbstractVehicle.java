/*
 * TCSS 305 - Autumn 2015
 * Assignment 3 - EasyStreet
 */
package model;

import java.util.Map;

/**
 * 
 * Abstract Vehicle class implements Vehicle interface.
 * @author Tung Kong
 * @version 1 10/27/15
 *
 */
public abstract class AbstractVehicle implements Vehicle {
    
    //this is a test
    /** The X coordinate that a vehicle starts at. */
    private final int myOriginalX;
    
    /** The Y coordinate a vehicle starts at. */
    private final int myOriginalY;
    
    /** The direction that a vehicle starts off facing. */
    private final Direction myOriginalDirection;
    
    /** The current X of a vehicle. */
    private int myX;
    
    /** The current Y of a vehicle. */
    private int myY;
    
    /** The current direction a vehicle is facing. */
    private Direction myDirection;
    
    /** The number of moves a vehicle stays dead for. */
    private final int myDeathTime;
    
    /** The number of moves a vehicle has been dead for. */
    private int myMovesUntilRevive;
    
    /** True if a vehicle is alive, false if it is dead. */
    private boolean myStatus;
    
    /**
     * Constructs a vehicle object.
     * @param theX the initial X coordinate of vehicle.
     * @param theY the initial Y coordinate of vehicle.
     * @param theDir the initial direction the vehicle is facing.
     * @param theDeathTime death time of a vehicle.
     */
    protected AbstractVehicle(final int theX, final int theY, 
                              final Direction theDir, final int theDeathTime) {
        myOriginalX = theX;
        myOriginalY = theY;
        myDeathTime = theDeathTime;
        myOriginalDirection = theDir;
        myDirection = theDir;
        myX = theX;
        myY = theY;
        myStatus = true;
    }

    @Override
    public abstract boolean canPass(Terrain theTerrain, Light theLight);

    @Override
    public abstract Direction chooseDirection(Map<Direction, Terrain> theNeighbors);
    
    
    @Override
    public void collide(final Vehicle theOther) {
        if (this.isAlive() && theOther.isAlive() && getDeathTime() > theOther.getDeathTime()) {
            myStatus = false;
        }    
    }

    @Override
    public int getDeathTime() {
        return myDeathTime;
    }

    @Override
    public String getImageFileName() {
        final StringBuilder fileName = new StringBuilder();
        fileName.append(getClass().getSimpleName().toLowerCase());
        if (!isAlive()) {
            fileName.append("_dead");
        }
        fileName.append(".gif");
        return fileName.toString();
    }

    @Override
    public Direction getDirection() {
        return myDirection;
    }

    @Override
    public int getX() {
        return myX;
    }

    @Override
    public int getY() {
        return myY;
    }

    @Override
    public boolean isAlive() {
        return myStatus;
    }

    @Override
    public void poke() {
        if (!isAlive()) {
            myMovesUntilRevive++;
        }
        if (myMovesUntilRevive == getDeathTime()) {
            myStatus = true;
            setDirection(Direction.random());
            myMovesUntilRevive = 0;
        }
        
    }

    @Override
    public void reset() {
        setX(myOriginalX);
        setY(myOriginalY);
        setDirection(myOriginalDirection);
        myStatus = true;
        
    }

    @Override
    public void setDirection(final Direction theDir) {
        myDirection = theDir;
        
    }

    @Override
    public void setX(final int theX) {
        myX = theX;
        
    }

    @Override
    public void setY(final int theY) {
        myY = theY;
        
    }
    
    /**
     * @return the string representation of how long a vehicle has been dead for "Dead for: n" 
     * where n is the number of moves a vehicle has been dead.
     */
    @Override
    public String toString() {
        final StringBuilder deathTime = new StringBuilder();
        deathTime.append("Dead for: ");
        deathTime.append(myMovesUntilRevive);
        return deathTime.toString();
    }

}
