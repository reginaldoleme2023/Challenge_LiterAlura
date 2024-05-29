package br.com.alura.ChallengeLiteralura;

import br.com.alura.ChallengeLiteralura.main.Main;
import br.com.alura.ChallengeLiteralura.repository.AuthorRepository;
import br.com.alura.ChallengeLiteralura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLiteraluraApplication  implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(bookRepository, authorRepository);
		main.showMenu();
	}
}
