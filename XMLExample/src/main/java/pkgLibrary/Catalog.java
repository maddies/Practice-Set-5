package pkgLibrary;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import pkgException.BookException;
//import pkgException.DeckException;
import pkgMain.XMLReader;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;

	@XmlElement(name = "book")
	ArrayList<Book> books;

	public int getId() {
		return id;
	}

	public Catalog() {

	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public Book GetBook(String bid) throws BookException {
		Book b = new Book();
		boolean found = false;
		XMLReader x = new XMLReader();
		Catalog c = x.rdCat();
		ArrayList<Book> arr = c.getBooks();
		
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getId().equals(bid)) {
				b = arr.get(i);
				found = true;
				break;
			}
		}
		if (found == false) {
			throw new BookException("Book not found");
		}
		return b;
		}
	
	public Catalog AddBook(int CatalogID, Book NewBook) throws BookException {
		
		Book b = new Book();
		boolean BookExists = false;
		XMLReader x = new XMLReader();
		Catalog c = x.rdCat();
		ArrayList<Book> arr = c.getBooks();
		
		
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getId().equals(NewBook.getId())) {
				b = arr.get(i);
				BookExists = true;
			}
		}
		
		if (BookExists == true) {
			throw new BookException("Book already exists");
		}
		
		if (BookExists == false) {
		arr.add(NewBook)	;
		}
		
		c.setBooks(arr);//set arraylist
		x.wrtXML(c);
		return c;
		
	}	
		
		

	}

