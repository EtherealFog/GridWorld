package com.bugs;

import info.gridworld.actor.Bug;

import java.awt.Color;

public class DancingBug extends Bug {
	private int[] a;
	private int step;
	private int move;
	
	public DancingBug(Color c, int[] a) {
		super(c);
		this.a = a;
		step = 0;
		move = 0;
	}
	
	public DancingBug(int[] a) {
		this(Color.blue, a);
	}
	
	@Override
	public void act() {
		if(step < a[move % a.length]) {
			turn();
			step++;
		} else if(canMove()) {
			move();
			step = 0;
			move++;
		}
	}
}
