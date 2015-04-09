package com.runners;

import info.gridworld.actor.ActorWorld;

import com.bugs.SpiralBug;

public class SpiralBugRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.add(new SpiralBug());
		world.show();
		
	}
}
