package com.thrillio.sasi.dao;

import com.thrillio.sasi.datastore.DataStore;
import com.thrillio.sasi.entities.Bookmark;
import com.thrillio.sasi.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks()
	{
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
