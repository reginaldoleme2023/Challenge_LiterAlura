package br.com.alura.ChallengeLiteralura.repository;

import br.com.alura.ChallengeLiteralura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Long> {
}
