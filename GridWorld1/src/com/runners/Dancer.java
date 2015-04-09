package com.runners;

import info.gridworld.actor.ActorWorld;

import com.bugs.DancingBug;

public class Dancer {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.add(new DancingBug(new int[] {2, 4, 3, 1, 1, 7}));
		world.show();
	}
}
