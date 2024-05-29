package br.com.alura.ChallengeLiteralura.model;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )

    private List<Author> authors;

    private List<String> languages;

    private Integer download_count;

    public Book() {}

    public Book(DataBook dataBook) {
        this.title = dataBook.title();
        this.authors = dataBook.authors().stream().map(da -> new Author(da.name(), da.birth_year(), da.death_year())).toList();
        this.languages = dataBook.languages();
        this.download_count = dataBook.download_count();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getLanguage() {
        return languages;
    }

    public void setLanguage(String language) {
        this.languages = Collections.singletonList(language);
    }

    public Integer getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Integer download_count) {
        this.download_count = download_count;
    }
}
