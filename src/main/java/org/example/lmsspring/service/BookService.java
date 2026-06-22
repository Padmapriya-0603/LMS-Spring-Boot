package org.example.lmsspring.service;
import org.example.lmsspring.model.Book;
import org.example.lmsspring.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookService {
        private final BookRepository repository;
        public BookService(BookRepository repository) {
            this.repository = repository;
        }
        public List<Book> getBooks() {
            return repository.getAllBooks();
        }
    }
