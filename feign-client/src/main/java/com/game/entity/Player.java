package com.game.entity;

public class Player {

	private int id;
	private String name;
	private String style;
	private int score;
	private boolean order;

	public String getName() {
		return name;
	}

	public String getStyle() {
		return style;
	}

	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public boolean isOrder() {
		return order;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setOrder(boolean order) {
		this.order = order;
	}

}