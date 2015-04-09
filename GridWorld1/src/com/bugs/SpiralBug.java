package com.bugs;

import info.gridworld.actor.Bug;

import java.awt.Color;

public class SpiralBug extends Bug {
	private int length;
	private int step;
	
	public SpiralBug(Color c, int startLength) {
		super(c);
		length = startLength;
	}
	
	public SpiralBug(int startLength) {
		this(Color.DARK_GRAY, startLength);
	}
	
	public SpiralBug() {
		this(3);
	}
	
	public void act()
    {
        if (step < length && canMove())
        {
            move();
            step++;
        }
        else
        {
            turn();
            turn();
            step = 0;
            length++;
        }
    }
}
