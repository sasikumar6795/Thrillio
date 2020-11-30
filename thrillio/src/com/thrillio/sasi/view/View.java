package com.thrillio.sasi.view;

import com.thrillio.sasi.Controller.BookmarkController;
import com.thrillio.sasi.constants.KidFriendlyStatus;
import com.thrillio.sasi.constants.UserType;
import com.thrillio.sasi.datastore.DataStore;
import com.thrillio.sasi.entities.Bookmark;
import com.thrillio.sasi.entities.User;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing" + " "+user.getUserType());
		int bookmarkCount = 0;
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookMarked = getBookmarkDecision(bookmark);
					if (isBookMarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("New item Bookmarked" + " " + bookmark);
					}
				}
				if (user.getUserType().equals(UserType.CHIEF_EDITOR) || user.getUserType().equals(UserType.EDITOR)) {
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getFriendlyStatusDecision(bookmark);
						if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN))
						{
							bookmark.setKidFriendlyStatus(kidFriendlyStatus);
							System.out.println("kid friendly status" + " "+kidFriendlyStatus + " " + bookmark);
						}
					}
				}

			}
		}
	}

	private static String getFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 || Math.random() < 0.8 ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN);

	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {

		return Math.random() < 0.5 ? true : false;
	}

	/*
	 * public static void bookmark(User user, Bookmark[][] bookmarks ) {
	 * System.out.println("\n" + user.getEmail() + " is bookmarking"); //user can
	 * bookmark maximum 5 bookmarks for(int i=0;i<DataStore.USER_BOOKMARK_LIMIT;i++)
	 * { //randomly select 5 of 15 bookmaks //System.out.println(Math.random()); int
	 * typeOffset=(int) (Math.random() * DataStore.BOOKMARKS_TYPES_COUNT); int
	 * boomarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
	 * Bookmark bookmark = bookmarks[typeOffset][boomarkOffset]; //now use has saved
	 * the boomark and this needs to be sent to controller.
	 * BoomarkController.getInstance().saveUserBookmark(user,bookmark);
	 * System.out.println(bookmark); } }
	 */
}
