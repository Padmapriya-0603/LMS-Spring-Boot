package org.example.lmsspring.service;
import org.example.lmsspring.dto.BookResponseDTO;
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
        public Book addBook(Book book){
            return repository.save(book);
        }
        public BookResponseDTO getBookById(Integer id) {
        Book book = repository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
        return convertToDTO(book);
        }
        public void deleteBook(Integer id){
            repository.deleteById(id);
        }
        public Book updateBook(Integer id, Book newBook) {
        Book book = repository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        book.setYear(newBook.getYear());
        book.setTitle(newBook.getTitle());
        book.setAuthor(newBook.getAuthor());
        book.setPrice(newBook.getPrice());
        book.setStatus(newBook.getStatus());
        return repository.save(book);
    }
        public List<BookResponseDTO> getBooksByAuthor(String author) {
            return repository.findByAuthorContaining(author).stream().map(this::convertToDTO).toList();
        }
        public List<BookResponseDTO> searchByTitle(String title) {
            return repository.findByTitleContaining(title).stream().map(this::convertToDTO).toList();
        }
        public List<BookResponseDTO> getBooksByStatus(String status){
            return repository.findByStatus(status).stream().map(this::convertToDTO).toList();
        }
    private BookResponseDTO convertToDTO(Book book) {
        return new BookResponseDTO(book.getId(), book.getTitle(), book.getYear(), book.getAuthor(), book.getPrice(), book.getStatus());
        }
    public List<BookResponseDTO> getBooks() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }
    }
