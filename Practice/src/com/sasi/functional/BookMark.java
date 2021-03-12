package com.sasi.functional;

public class BookMark {
	private long id;

	private String title;

	private double rating;

	public long getId() {
		return id;
	}

	public BookMark(long id, String title, double rating) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
