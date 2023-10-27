package model;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Book {
    // Attributes representing book data -> using postgresql table 'book'
    private String id;
    private String title;
    private List<String> author;
    private String publisher;
    private String publishedDate;
    private int pagesNumber;   
    private String imageLink;
    private String previewLink;
    private String description;
    private String listId;

    public Book() { }

    public Book(String title, List<String> author, String publisher, String publishedDate, int pagesNumber,
            String imageLink, String previewLink, String description) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.pagesNumber = pagesNumber;
        this.imageLink = imageLink;
        this.previewLink = previewLink;
        this.description = description;
    }

    public Book(String id ,String title, List<String> author, String publisher, String publishedDate, int pagesNumber, String imageLink, String previewLink, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.pagesNumber = pagesNumber;
        this.imageLink = imageLink;
        this.previewLink = previewLink;
        this.description = description;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getListId() {
        return listId;
    }

    public static Book fromJsonString(String rawBookData) throws JsonMappingException, JsonProcessingException{
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(rawBookData, Book.class);
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
                + ", publishedDate=" + publishedDate + ", pagesNumber=" + pagesNumber + ", imageLink=" + imageLink
                + ", previewLink=" + previewLink + ", description=" + description + ", listId=" + listId + "]";
    }

    
}
