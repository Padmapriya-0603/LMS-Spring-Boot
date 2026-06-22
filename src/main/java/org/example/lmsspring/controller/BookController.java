package org.example.lmsspring.controller;
import org.example.lmsspring.model.Book;
import org.example.lmsspring.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class BookController {
        private final BookService service;
        public BookController(BookService service) {
            this.service = service;
        }
        @GetMapping("/books")
        public List<Book> getBooks() {
            return service.getBooks();
        }
    }
