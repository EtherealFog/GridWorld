package com.bugs;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Random;

public class SnakeBug extends Bug {
	public static final int DEFAULT_LENGTH = 4;
	public static final int GROWTH_FACTOR = 3;
	private int score;
	private int length;
	private ArrayList<Rock> tail;
	
	public SnakeBug() {
		this(DEFAULT_LENGTH);
	}
	
	public SnakeBug(int initLength) {
		length = initLength;
		score = 0;
		tail = new ArrayList<Rock>();
	}
	
	public void act() {
		if(canMove()) {
			move();
		} else {
			javax.swing.JOptionPane.showMessageDialog(null, "Score: " + score, "GAME OVER!", 0);
			System.exit(0);
		}
	}
	
	public void randomFlower() {
		Grid<Actor> gr = getGrid();
		Random r = new Random();
		Location test = new Location(r.nextInt(gr.getNumRows()), r.nextInt(gr.getNumCols()));
		while(!(gr.get(test) == null)) {
			test = new Location(r.nextInt(gr.getNumRows()), r.nextInt(gr.getNumCols()));
		}
		(new Flower()).putSelfInGrid(gr, test);
	}
	
	public void addRock(Location loc) {
		tail.add(0, new Rock());
		tail.get(0).putSelfInGrid(getGrid(), loc);
	}
	
	public void removeTail() {
		tail.remove(tail.size() - 1).removeSelfFromGrid();
	}
	
	public void move() {
		Grid<Actor> gr = getGrid();
		Location current = getLocation();
		Location next = current.getAdjacentLocation(getDirection());
		if(gr.get(next) instanceof Flower) {
			score += 1;
			length += 3;
			randomFlower();
		}
		moveTo(next);
		addRock(current);
		if(tail.size() > length)
			removeTail();
	}
	
	public boolean canMove() {
		Grid gr = getGrid();
		Location next = getLocation().getAdjacentLocation(getDirection());
		if(gr.isValid(next) && !(gr.get(next) instanceof Rock))
			return true;
		return false;
	}
}
