package br.com.alura.ChallengeLiteralura.repository;

import br.com.alura.ChallengeLiteralura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository <Author, Long> {
    @Query("SELECT a.name FROM Author a WHERE a.birth_year <= :year AND (a.death_year IS NULL OR a.death_year >= :year)")
    List<String> findlivingAuthorByYear(int year);
}
