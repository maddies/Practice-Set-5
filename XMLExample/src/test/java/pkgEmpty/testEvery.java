package pkgEmpty;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import pkgException.BookException;
import pkgLibrary.Book;
import pkgLibrary.Catalog;

public class testEvery {

	@Test
	public void testAddBook() throws BookException {
		Catalog f = new Catalog();
		Book c = new Book("bkMyNewBookIamAdding", "jones", "monkey", "heyyy", 45.9, 76.8, new Date(), "hi");
		f.AddBook(0, c);
	}

	@Test
	public void testAddBookReplicate() throws BookException {
		Catalog f = new Catalog();
		Book d = new Book("bk111");
		try {
			f.AddBook(0, d);
		} catch (BookException n) {
		}
	}

	@Test
	public void testGetBook() throws BookException {
		Catalog f = new Catalog();
		Book m = f.GetBook("bk102");

	}

	@Test
	public void testGetBookDoesNotExist() throws BookException {
		Catalog f = new Catalog();
		try {
			Book m = f.GetBook("bkMadeline");
		} catch (BookException n) {
		}
	}

}
