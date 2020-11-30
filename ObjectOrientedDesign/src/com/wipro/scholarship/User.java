package com.wipro.scholarship;

public class User {

	public int id = 1;

	public void printUserType() {
		System.out.println("User");
	}

	public void saveWebLink() {
		System.out.println("User: saveWebLink");
		postAReview();
	}

	public void postAReview() {
		System.out.println("User: postAReview");
	}

	public Review postAReview(String reviewText) {
		System.out.println("User: postAReview");
		Review review = new Review(reviewText);
		return review;
	}
}