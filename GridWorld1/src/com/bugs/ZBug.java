package com.bugs;

import info.gridworld.actor.Bug;

import java.awt.Color;



public class ZBug extends Bug {
	private static final int DEF_SIZE = 4;
	private int size;
	private int step;
	
	public ZBug(Color c, int size) {
		super(c);
		this.size = size;
		step = 0;
		setDirection(90);
	}
	
	public ZBug(int size) {
		this(Color.ORANGE, size);
	}
	
	public ZBug() {
		this(DEF_SIZE);
	}
	
	public void act() {
		if(step == size) {
			setDirection(225);
		} else if(step == 2 * size) {
			setDirection(90);
		}
		
		if(canMove() && step < size * 3) {
			move();
		}
		step++;
	}

}
