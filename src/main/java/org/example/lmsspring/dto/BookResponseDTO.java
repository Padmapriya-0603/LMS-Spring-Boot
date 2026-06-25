package org.example.lmsspring.dto;
public class BookResponseDTO {
    private Integer id;
    private String title;
    private int year;
    private String author;
    private double price;
    private String status;
    public BookResponseDTO() {
    }
    public BookResponseDTO(Integer id, String title, int year, String author, double price, String status) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.author = author;
        this.price = price;
        this.status = status;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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