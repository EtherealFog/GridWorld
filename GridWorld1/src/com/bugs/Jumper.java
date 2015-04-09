package com.bugs;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Jumper extends Actor {
	public Jumper(Color c) {
		setColor(c);
	}
	
	public Jumper() {
		this(Color.blue);
	}
	
	public int canMove() {
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return -1;
        Location loc = getLocation();
        Location n1 = loc.getAdjacentLocation(getDirection());
        Location n2 = n1.getAdjacentLocation(getDirection());
        if(!(gr.isValid(n1) || gr.isValid(n2)))
        	return -1;
        if(gr.isValid(n2) && !(gr.get(n2) instanceof Rock || gr.get(n2) instanceof Flower))
        	return 1;
        else if(gr.isValid(n1) && !(gr.get(n1) instanceof Rock || gr.get(n1) instanceof Flower))
        	return 0;
		return -1;
	}
	
	public void move(int num) {
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next;
        if(num == 0)
        	next = loc.getAdjacentLocation(getDirection());
        else if(num == 1)
        	next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
        else {
        	throw new IllegalArgumentException("param should be 1 or 0");
        	
        }
	}
	
	public void act() {
		int check = canMove();
		if(check != -1)
			move(check);
		else
			turn();
	}
	
	public void turn(int num) {
		setDirection(getDirection() + Location.HALF_RIGHT * num);
	}
	
	public void turn() {
		turn(45);
	}
	
}
