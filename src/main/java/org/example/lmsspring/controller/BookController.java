package org.example.lmsspring.controller;
import org.example.lmsspring.dto.BookRequestDTO;
import org.example.lmsspring.dto.BookResponseDTO;
import org.example.lmsspring.model.Book;
import org.example.lmsspring.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService service;
    public BookController(BookService service) {
            this.service = service;
        }
        @GetMapping
        public List<BookResponseDTO> getBooks() {
            return service.getBooks();
        }
        @PostMapping
    public Book addBook(@Valid @RequestBody BookRequestDTO dto){
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setYear(dto.getYear());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        book.setStatus(dto.getStatus());
        return service.addBook(book);
    }
        @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getBookById(id));
    }
        @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id){
            service.deleteBook(id);
        }
        @PutMapping("/{id}")
    public Book updateBook(
            @PathVariable Integer id,
            @Valid @RequestBody BookRequestDTO dto){
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setYear(dto.getYear());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        book.setStatus(dto.getStatus());
        return service.updateBook(id, book);
    }
        @GetMapping("/author/{author}")
    public List<BookResponseDTO> getBooksByAuthor(@PathVariable String author){
            return service.getBooksByAuthor(author);
        }
        @GetMapping("/search/{title}")
    public List<BookResponseDTO> searchBooks(@PathVariable String title){
            return service.searchByTitle(title);
        }
        @GetMapping("/status/{status}")
        public List<BookResponseDTO> getBooksByStatus(@PathVariable String status){
            return service.getBooksByStatus(status);
        }
    }