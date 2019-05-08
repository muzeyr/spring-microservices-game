package com.game.entity;

public class Position {
	private int row;
	private int col;
	private String name;

	public Position(int row, int col, String name) {
		this.row = row;
		this.col = col;
		this.name = name;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[ row:" + getRow() + ",col:" + getCol() + ",name:" + getName() + " ]";
	}

}