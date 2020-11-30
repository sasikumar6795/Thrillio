package com.sasi.collections;

public class Book /*implements Comparable*/ {
	private String title;
	private String author;
	private int year;

	public Book(String title, String author, int year) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	/*public int hashCode()
	{
		return title.hashCode();
	}
	
	public boolean equals(Object o)
	{
		return (this.year == ((Book)o).getYear() && (this.author.equals((((Book)o).getAuthor()))));
	}
*/
	@Override
	public String toString() {
		//return "Book [title=" + title + ", author=" + author + ", year=" + year + "]";
		return "Book[title=" + title + ", author=" + author + ", year=" + year + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	/*@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.getTitle().compareTo(((Book)o).getTitle());
	}*/

}
