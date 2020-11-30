package com.thrillio.sasi.launch;

import com.thrillio.sasi.datastore.DataStore;
import com.thrillio.sasi.entities.Bookmark;
import com.thrillio.sasi.entities.User;
import com.thrillio.sasi.managers.BookmarkManager;
import com.thrillio.sasi.managers.UserManager;
import com.thrillio.sasi.view.View;

public class Launch {

	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		System.out.println("Loading the data ====================");
		DataStore.loadData();

		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();

		/*System.out.println("printing the data ==============");
		printUsers();
		PrintBookmarks();*/

	}

	private static void PrintBookmarks() {
		for (int i = 0; i < bookmarks.length; i++) {
			for (int j = 0; j < bookmarks.length; j++) {
				System.out.println(bookmarks[i][j]);
			}
		}

	}

	private static void printUsers() {
		for (int i = 0; i < users.length; i++) {
			System.out.println(users[i]);
		}

	}

	private static void start() {
		//System.out.println("2. Bookmarking ==============");
		/*for (User user : users) {
			View.bookmark(user, bookmarks);
		}*/
		for (int i = 0; i < users.length; i++) {
			View.browse(users[i], bookmarks);
		}

	}

	public static void main(String[] args) {
		loadData();
		start();
	}

}
