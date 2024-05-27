package br.com.alura.ChallengeLiteralura.main;

import java.util.Scanner;

public class Main {

    private Scanner scan = new Scanner(System.in);


    public void showMenu() {

        var option = -1;
        while(option != 0) {
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

            switch (option) {
                case 1:
                    System.out.println("option " + option);
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
}
