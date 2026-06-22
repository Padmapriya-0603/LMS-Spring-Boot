package org.example.lmsspring.repository;
import org.example.lmsspring.model.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BookRepository {
        private List<Book> books = new ArrayList<>();
        public BookRepository() {
            books.add(new Book(1,"Harry Potter","J.K.Rowling"));
            books.add(new Book(2,"Pride and Prejudice","Jane Austen"));
        }
        public List<Book> getAllBooks() {
            return books;
        }
    }
