package br.com.alura.ChallengeLiteralura.repository;

import br.com.alura.ChallengeLiteralura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository <Book, Long> {

    Optional<Book> findByTitleContainsIgnoreCase(String title);
    @Query("SELECT b FROM Book b WHERE :language MEMBER OF b.languages")
    List<Book> findBooksByLanguage(@Param("language") String language);
}
