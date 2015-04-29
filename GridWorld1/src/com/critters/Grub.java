package com.critters;

import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class Grub extends Critter {
	private int maxDistance;
	
	public Grub(int distance) {
		maxDistance = distance;
	}
	
	public int getRandomDirection() {
		int[] directions = {Location.NORTH, Location.NORTHEAST, Location.EAST, Location.SOUTHEAST, 
							Location.SOUTH, Location.SOUTHWEST, Location.WEST, Location.NORTHWEST};
		return directions[(int)(Math.random() * 8)];
	}
	
	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> locs = new ArrayList<Location>();
		int direction = getRandomDirection();
		if(maxDistance >= 1) {
			locs.add();
		}
		return locs;
	}
	
	public Location selectMoveLocation(ArrayList<Location> locs) {
		Location loc = null;
		
		
		return loc;
	}
}
