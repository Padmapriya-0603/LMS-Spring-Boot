package org.example.lmsspring.controller;
import org.example.lmsspring.model.Book;
import org.example.lmsspring.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/books")
public class BookController {
        private final BookService service;
        public BookController(BookService service) {
            this.service = service;
        }
        @GetMapping
        public List<Book> getBooks() {
            return service.getBooks();
        }
        @PostMapping
    public Book addBook(@RequestBody Book book){
            return service.addBook(book);
        }
        @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return service.getBookById(id);
        }
        @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id){
            service.deleteBook(id);
        }
        @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id,@RequestBody Book book){
            return service.updateBook(id,book);
        }
        @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author){
            return service.getBooksByAuthor(author);
        }
        @GetMapping("/search/{title}")
    public List<Book> searchBooks(@PathVariable String title){
            return service.searchByTitle(title);
        }
        @GetMapping("/status/{status}")
        public List<Book> getBooksByStatus(@PathVariable String status){
            return service.getBooksByStatus(status);
        }
    }
