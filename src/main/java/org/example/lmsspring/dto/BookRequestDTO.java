package org.example.lmsspring.dto;
import jakarta.validation.constraints.*;
public class BookRequestDTO {
    @NotBlank(message = "Title cannot be empty")
    private String title;
    @Min(value = 1000, message = "Year must be greater than or equal to 1000")
    @Max(value = 2100, message = "Year must be less than or equal to 2100")
    private int year;
    @NotBlank(message = "Author cannot be empty")
    private String author;
    @Positive(message = "Price must be positive")
    private double price;
    @NotBlank(message = "Status cannot be empty")
    private String status;
    public BookRequestDTO() {
    }
    public BookRequestDTO(String title, int year, String author, double price, String status) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.price = price;
        this.status = status;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}