package ti2cc.app;

import java.util.List;
import java.util.Scanner;

import ti2cc.dao.*;
import ti2cc.model.Livro;

public class Aplicacao {
    //Scanner
    private static Scanner sc = new Scanner(System.in);
    
    //Insert funcion
    private static void insert(String nome, String autor, String genero, int codigo, LivroDAO livroDAO) {   
        //data
        Livro livro = new Livro(codigo, nome, autor, genero);
        if (livroDAO.insert(livro) == true) {
            System.out.println("Inseriu: " + livro.toString());
        }
    }

    //Read function
    private static void read(LivroDAO livroDAO) {
        //data
        List <Livro> livros = livroDAO.get();
        for(Livro l : livros) {
            System.out.println(l.toString());
        }
    }

    //Update funtion
    private static void update(LivroDAO livroDAO) {
        //data - building new book
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Autor: ");
        String autor = sc.next();
        System.out.print("Genero: ");
        String genero = sc.next();
        System.out.print("codigo: ");
        int codigo = sc.nextInt();
        Livro livro = new Livro(codigo, nome, autor, genero);

        if (livroDAO.uptade(livro) == true ) {
            System.out.println("Atualização: " + livro.toString());
        }
    }

    private static void delete(int codigo, LivroDAO livroDAO) {
        if ( livroDAO.delete(codigo) == true ) {
            System.out.println("Livro código: " + codigo + " deletado com sucesso");
        };
    }

    public static void main(String[] args) {
        //data
        String nome = "";
        String autor = "";
        String genero = "";
        int codigo = 1;
        LivroDAO livroDAO = new LivroDAO();

        //show options
        System.out.println("1) Inserir");
        System.out.println("2) Listar");
        System.out.println("3) Atualizar");
        System.out.println("4) Excluir");
        System.out.println("5) Sair");
        System.out.print("Selecione: ");
        int opcao = sc.nextInt();

        switch(opcao) {
            case 1:
                System.out.print("Nome: ");
                nome = sc.next();
                System.out.print("Autor: ");
                autor = sc.next();
                System.out.print("Genero: ");
                genero = sc.next();
                System.out.print("codigo: ");
                codigo = sc.nextInt();
                insert(nome, autor, genero, codigo,livroDAO);
                break;

            case 2:
                read(livroDAO);
                break;
                
            case 3:
                update(livroDAO);
                break;

            case 4:
                System.out.print("codigo: ");
                codigo = sc.nextInt();
                delete(codigo, livroDAO);
                break;
            
            case 5:
                break;
            
            default:
                System.out.println("Opção invalida");

        }
    }
}
