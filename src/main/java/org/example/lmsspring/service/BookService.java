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
            return repository.findAll();
        }
        public Book addBook(Book book){
            return repository.save(book);
        }
        public Book getBookById(Integer id) {
            return repository.findById(id).orElse(null);
        }
        public void deleteBook(Integer id){
            repository.deleteById(id);
        }
        public Book updateBook(Integer id,Book newBook){
            Book book=repository.findById(id).orElseThrow(()->new RuntimeException("Book not found"));
            if(book!=null){
                book.setTitle(newBook.getTitle());
                book.setAuthor(newBook.getAuthor());
                return repository.save(book);
            }
            return null;
        }
        public List<Book> getBooksByAuthor(String author) {
            return repository.findByAuthor(author);
        }
        public List<Book> searchByTitle(String title) {
            return repository.findByTitleContaining(title);
        }
    }
