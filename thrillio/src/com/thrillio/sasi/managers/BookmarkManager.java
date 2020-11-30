package com.thrillio.sasi.managers;

import com.thrillio.sasi.dao.BookmarkDao;
import com.thrillio.sasi.entities.Book;
import com.thrillio.sasi.entities.Bookmark;
import com.thrillio.sasi.entities.Movie;
import com.thrillio.sasi.entities.User;
import com.thrillio.sasi.entities.UserBookmark;
import com.thrillio.sasi.entities.WebLink;

/**
 * @author Sasikumar
 *
 */
public class BookmarkManager {

	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao bookmarkDao = new BookmarkDao();

	private BookmarkManager() {

	}

	public static BookmarkManager getInstance() {
		return instance;
	}

	/**
	 * @param id
	 * @param title
	 * @param profileUrl
	 * @param releaseYear
	 * @param cast
	 * @param directors
	 * @param genre
	 * @param imdbRating
	 * @return
	 */
	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genre, double imdbRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);

		return movie;
	}

	/**
	 * @param id
	 * @param title
	 * @param profileUrl
	 * @param publicationYear
	 * @param publisher
	 * @param authors
	 * @param genre
	 * @param amazonRating
	 * @return
	 */
	public Book createBook(long id, String title, String profileUrl, int publicationYear, String publisher,
			String[] authors, String genre, double amazonRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setProfileUrl(profileUrl);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);

		return book;
	}

	/**
	 * @param id
	 * @param title
	 * @param profileUrl
	 * @param url
	 * @param host
	 * @return
	 */
	public WebLink createWebLink(long id, String title, String profileUrl, String url, String host) {
		WebLink webLink = new WebLink();
		webLink.setId(id);
		webLink.setTitle(title);
		webLink.setProfileUrl(profileUrl);
		webLink.setUrl(url);
		webLink.setHost(host);

		return webLink;
	}

	public Bookmark[][] getBookmarks() {
		return bookmarkDao.getBookmarks();
	}

	/**
	 * @param user
	 * @param bookmark
	 */
	public void saveUserBookmark(User user, Bookmark bookmark) {
		// user bookmark association -- use that

		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setBookmark(bookmark);
		userBookmark.setUser(user);
		bookmarkDao.saveUserBookmark(userBookmark);

	}

}
