package pl.coderslab.bookscatalog;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

	private	List<Book> list;
	
	public Book add(Book book) {
		list.add(book);
		return book;
	}
	
	public List<Book> all () {
		return Arrays.asList(
		new Book (1, "978-83-7584", "Pan lodowego ogrodu", "Jarosła Grzędowicz", "Fabryka Snów", "fantastyka"), 
		new Book(2, "990-222-222", "Anioły i Demony", "Down Brown", "Cisz Company", "fantastyka"),
		new Book(3, "333-332-22", "Piąta Góra", "Paolo Coehlo", "Fabryka Snów", "proza"));
	}
		
	public	List<Book> getList() {
	return	list;	
	}
	
	public void setList(List<Book>	list)	{
	this.list = list;	
	}

	public Optional<Book> findById (long id) {
		for(Book book: list)
			if(book.getId()==id) 
				return Optional.of(book);
		return Optional.empty();
	}
	
	public Book update(Book book) {
		final Optional<Book> findById = findById(book.getId());
		findById.ifPresent(b -> {
			b.setIsbn(book.getIsbn());
			b.setAuthor(book.getAuthor());
			b.setTitle(book.getTitle());
			b.setPublisher(book.getPublisher());
			b.setType(book.getType());
		});
		return book;
	}
	
	public Optional<Book> delete (long id) {
		for(Iterator <Book> it = list.iterator(); it.hasNext(); ) {
			final Book book = it.next();
			if (id == book.getId())
				it.remove();
				return Optional.of(book);
		}		
		return Optional.empty();
	}
}