/*
 * TCSS 305 - Autumn 2015
 * Assignment 3 - EasyStreet
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import model.Direction;
import model.Light;
import model.Terrain;
import model.Truck;
import org.junit.Test;



/**
 * 
 * Tests for Truck class.
 * @author Tung Kong
 * @version 1 10/27/15
 *
 */
public class TruckTest {

    /** Repeats a test 50 times to test for randomness. */
    private static final int TRIES_FOR_RANDOMNESS = 50;
   
    /** Test method for {@link Truck#Truck(int, int, Direction)}.*/
    @Test
    public void testTruckConstructor() {
        final Truck testTruck = new Truck(20, 50, Direction.SOUTH);
        assertEquals(20, testTruck.getX());
        assertEquals(50, testTruck.getY());
        assertEquals(Direction.SOUTH, testTruck.getDirection());
        assertEquals(0, testTruck.getDeathTime());
        assertTrue(testTruck.isAlive());
    }
    
    /** Test method for {@link Truck#canPass(Terrain, Light)}.*/
    @Test
    public void testCanPass() {
        final Truck canPassTruck = new Truck(0, 0, Direction.NORTH); 
        assertTrue(canPassTruck.canPass(Terrain.STREET, null));
        assertTrue(canPassTruck.canPass(Terrain.LIGHT, Light.GREEN));
        assertTrue(canPassTruck.canPass(Terrain.LIGHT, Light.RED));
        assertTrue(canPassTruck.canPass(Terrain.LIGHT, Light.YELLOW));
        assertFalse(canPassTruck.canPass(Terrain.GRASS, null));
        assertFalse(canPassTruck.canPass(Terrain.TRAIL, null));
        assertFalse(canPassTruck.canPass(Terrain.WALL, null));
    }
    
    /** Test method for {@link Truck#chooseDirection(Map<Direction, Terrain>)}.*/
    @Test
    public void testChooseDirection() {
        final Map<Direction, Terrain> testNeighbors = new HashMap<>();
        testNeighbors.put(Direction.NORTH, Terrain.WALL);
        testNeighbors.put(Direction.EAST, Terrain.WALL);
        testNeighbors.put(Direction.WEST, Terrain.GRASS);
        testNeighbors.put(Direction.SOUTH, Terrain.STREET);
        final Truck truck = new Truck(0, 0, Direction.NORTH);
        int tries = 0;
        while (tries < TRIES_FOR_RANDOMNESS) {
            tries = tries + 1;
            final Direction dir = truck.chooseDirection(testNeighbors);
            assertEquals(dir, Direction.SOUTH);         
        }
        testNeighbors.put(Direction.EAST, Terrain.LIGHT);
        testNeighbors.put(Direction.SOUTH, Terrain.STREET);
        tries = 0;
        while (tries < TRIES_FOR_RANDOMNESS) {
            tries = tries + 1;
            final Direction dir = truck.chooseDirection(testNeighbors);
            assertTrue(dir == Direction.EAST || dir == Direction.SOUTH);         
        }
        
    }

}
