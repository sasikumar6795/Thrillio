package com.wipro.scholarship;

public class Staff extends User {
	public int id = 2;

	public void printId() {
		System.out.println("id: " + id);
		System.out.println("super.id: " + super.id);
	}

	public void printUserType() {
		System.out.println("Staff");
	}

	/*public void postAReview() {
		System.out.println("Staff: postAReview");
	}*/

}