package org.example.lmsspring.repository;
import org.example.lmsspring.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book,Integer>{
    List<Book> findByAuthorContaining(String author);
    List<Book> findByTitleContaining(String title);
    List<Book> findByStatus(String status);
}
