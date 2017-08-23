package pl.coderslab.bookscatalog;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
public	class	BookController	{
	
	private final BookRepository bookRepository;
	
	
	public BookController(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	
	@GetMapping
	public List <Book> books() {
		return bookRepository.all();
	}
	
	@GetMapping("/{id}")
	public Optional <Book> findById(@PathVariable long id) {
		return bookRepository.findById(id);
	}
	
	@RequestMapping("/helloBook")
	public Book helloBook(){ 
		return new Book(1L, "9788324631766", "Thiniking in Java","Bruce Eckel","Helion","programming");	
	}
	
	@PostMapping
	public Book add(@RequestBody Book book) {
		return bookRepository.add(book);
	}
	
}