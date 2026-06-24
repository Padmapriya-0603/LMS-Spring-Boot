package org.example.lmsspring.config;
import org.example.lmsspring.model.Book;
import org.example.lmsspring.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;
@Component
public class DataLoader implements CommandLineRunner {
    private final BookRepository repository;
    public DataLoader(BookRepository repository) {
        this.repository = repository;
    }
    @Override
    public void run(String... args) {
        try {
            System.out.println("Starting import");
            if(repository.count() == 0) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("books.csv").getInputStream()));
                String line;
                while((line = reader.readLine()) != null) {
                    System.out.println(line);
                    String[] data = line.split(",");
                    Book book = new Book();
                    book.setTitle(data[1]);
                    book.setYear(Integer.parseInt(data[2]));
                    book.setAuthor(data[3]);
                    book.setPrice(Double.parseDouble(data[4]));
                    book.setStatus(data[5]);
                    repository.save(book);
                }
                System.out.println("Books imported successfully.");
            }
        }
        catch(Exception e) {
            System.out.println("ERROR OCCURRED:");
            e.printStackTrace();
        }
    }
}