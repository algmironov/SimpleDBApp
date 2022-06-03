package pro.sky.simpledbapp.model;

import pro.sky.simpledbapp.model.Author;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(int id, String name, Author author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getId() == book.getId() && getName().equals(book.getName()) && Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAuthor());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                '}';
    }
}
