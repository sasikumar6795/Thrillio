package com.thrillio.sasi.Controller;

import com.thrillio.sasi.entities.Bookmark;
import com.thrillio.sasi.entities.User;
import com.thrillio.sasi.managers.BookmarkManager;

public class BookmarkController {

	private static BookmarkController instance = new BookmarkController();

	private BookmarkController() {

	}

	public static BookmarkController getInstance() {
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user,bookmark);
	}

}
