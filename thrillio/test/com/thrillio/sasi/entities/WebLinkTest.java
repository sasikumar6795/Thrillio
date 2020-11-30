package com.thrillio.sasi.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.thrillio.sasi.managers.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1 -- porn in url -- false

		WebLink webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger,Part 2",
				"http://www.javaworld.com",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html", "unknown");

		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse("for porn in url - is kidFriendlyEligible must return false", isKidFriendlyEligible);
		// Test 2 -- porn in title -- false
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming porn Tiger,Part 2",
				"http://www.javaworld.com", "http://www.javaworld.com/article/2072759/core-java/taming--part-2.html",
				"unknown");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse("for porn in title - is kidFriendlyEligible must return false", isKidFriendlyEligible);
		// Test 3 -- adult in host -- false
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Porn Tiger,Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming--part-2.html", "http://www.java.com",
				"adult");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertFalse("for adult in host - is kidFriendlyEligible must return false", isKidFriendlyEligible);

		// Test 4 -- adult in url but not in host --true

		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger,Part 2",
				"http://www.javaworld.com/article/2072759/core-java/adult--part-2.html", "http://www.javaworld.com",
				"unknown");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertTrue("for adult in url but not in host - is kidFriendlyEligible must return true", isKidFriendlyEligible);

		// Test 5 -- adult in title only --true
		webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming adult Tiger,Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming--part-2.html", "http://www.javaworld.com",
				"unknown");
		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		assertTrue("for adult in title only - is kidFriendlyEligible must return true", isKidFriendlyEligible);
	}

}
