package br.com.alura.ChallengeLiteralura.main;

import br.com.alura.ChallengeLiteralura.model.Book;
import br.com.alura.ChallengeLiteralura.model.Data;
import br.com.alura.ChallengeLiteralura.model.DataBook;
import br.com.alura.ChallengeLiteralura.repository.AuthorRepository;
import br.com.alura.ChallengeLiteralura.repository.BookRepository;
import br.com.alura.ChallengeLiteralura.service.ConsumeApi;
import br.com.alura.ChallengeLiteralura.service.DataConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

public class Main  {

    private Scanner scan = new Scanner(System.in);
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private ConsumeApi consumeApi = new ConsumeApi();
    private DataConvert dataConvert = new DataConvert();
    private final String ADDRESS = "https://gutendex.com/books/?search=";

    public Main(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void showMenu() {

        var option = -1;
        while (option != 0) {
            var menu = """
                    __________________________________
                                        
                    Escolha o número da sua opção: 
                                        
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - listar livros de um determinado idioma 
                                    
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    findBookByTitle();
                    break;
                case 2:
                    System.out.println("option " + option);
                    break;
                case 3:
                    System.out.println("option " + option);
                    break;
                case 4:
                    System.out.println("option " + option);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void findBookByTitle() {

        var result = getdataTitle();

        if(result != null){
            DataBook dataBook = result.dataBooks().get(0);
            Book book = new Book(dataBook);
            var checkBookExists = bookRepository.findByTitleContainsIgnoreCase(book.getTitle());
            if (checkBookExists.isPresent()) {
                System.out.println(" Livro ja Cadastrado!");
            }else{
                bookRepository.save(book);
                System.out.println("Livro cadastrado com sucesso!");
                printBooksDetails(book);
            }





        }

    }

    private Data getdataTitle() {
        System.out.println("Digite o nome do livro que deseja buscar");
        var nameBook = scan.nextLine();
        var json = consumeApi.getData(ADDRESS + nameBook.replace(" ", "+"));
        var data = dataConvert.getData(json, Data.class);
        if (data.dataBooks().isEmpty()) {
            System.out.println(" Livro não encontrado! ");
            return null;
        } else {
            return data;
        }
    }

    private void printBooksDetails(Book book) {
        System.out.println("------------LIVRO-----------------");
        System.out.println("Titulo: " + book.getTitle());
        book.getAuthors().forEach(autor -> System.out.println("Autor: " + autor.getName()));
        System.out.println("Idioma: " + String.join(", ", book.getLanguage()));
        System.out.println("Numero de downloads: " + book.getDownload_count());
        System.out.println("----------------------------------");
    }
}
