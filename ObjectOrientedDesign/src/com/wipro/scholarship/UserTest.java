package com.wipro.scholarship;
public class UserTest {
	
	public void printUserType(User u) {
	    u.printUserType();
	}
	
	public void approveReview(Staff s) {
		if (s instanceof Editor) {
			((Editor) s).approveReview(); 
        } else {
        	System.out.println("Invalid object passed!!");
        }
	}

	
	public static void main(String[] args) {
		// Part 1
		User user = new User();
		User staff = new Staff();
		Staff staff1 = new Staff();
		User editor = new Editor();
		
		User chiefEditor = new ChiefEditor();
		//chiefEditor.postAReview();
		staff.postAReview();
		staff1.printId();
		//user.postAReview();
		
		/*UserTest ut = new UserTest();
		ut.printUserType(user);
		ut.printUserType(staff);
		ut.printUserType(editor);
		*/
		// Part 2
		//editor.approveReview();
		//editor.postAReview();
		//editor.saveWebLink();	
		
		// Casting & instanceof demo
		//UserTest ut = new UserTest();
		//ut.approveReview(new Staff());
		//ut.approveReview(new Editor());	
		//ut.approveReview(new ChiefEditor());
	}
}