package org.example.lmsspring.service;
import org.example.lmsspring.exception.BookNotFoundException;
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
                book.setYear(newBook.getYear());
                book.setTitle(newBook.getTitle());
                book.setAuthor(newBook.getAuthor());
                book.setPrice(newBook.getPrice());
                book.setStatus(newBook.getStatus());
                return repository.save(book);
            }
            throw new BookNotFoundException("Book not found with id " + id);
        }
        public List<Book> getBooksByAuthor(String author) {
            return repository.findByAuthorContaining(author);
        }
        public List<Book> searchByTitle(String title) {
            return repository.findByTitleContaining(title);
        }
        public List<Book> getBooksByStatus(String status){
            return repository.findByStatus(status);
        }
    }
