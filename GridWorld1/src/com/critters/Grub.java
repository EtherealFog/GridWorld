package com.critters;

import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
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
		return directions[(int)(Math.random() * directions.length)];
	}
	
	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> locs = new ArrayList<Location>();
		int direction = getRandomDirection();
		if(maxDistance >= 1) {
			locs.add(getLocation().getAdjacentLocation(direction));
			for(int i = 1; i < maxDistance; i++) {
				Location temp = locs.get(locs.size() - 1);
				locs.add(temp.getAdjacentLocation(direction));
			}
		}
		return locs;
	}
	
	public Location selectMoveLocation(ArrayList<Location> locs) {
		Location loc = null;
		loc = locs.get((int)(Math.random() * locs.size()));
		if(getGrid().get(loc) instanceof Flower || getGrid().get(loc) == null) {
			return loc;
		} else {
			return null;
		}
	}
}
