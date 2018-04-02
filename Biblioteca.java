/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;
import java.util.Scanner;
import java.util.ArrayList;

public class Biblioteca {

    public static void main(String[] args) {
        
        ArrayList<Livro> livroList = new ArrayList<Livro>();
        Scanner scanner = new Scanner(System.in);
        GerenteLivro gerente = new GerenteLivro();
        
        povoarLista(livroList);
   
        Boolean continuaLogado = true;
        Boolean adm = false;
        int opcaoTipoUsuario;
        
        System.out.println("Sistema da Biblioteca\n\nPara Login de Gerente digite 1\nPara usar o Sistema digite 2");
        opcaoTipoUsuario = scanner.nextInt();
            
        if(opcaoTipoUsuario == 1){
            adm = realizarLogin(scanner, gerente, adm);
        }else if(opcaoTipoUsuario > 2){
            continuaLogado = false;
        }
        
        while (continuaLogado) {
            
            exibeMenu(adm);

            int opcaoMenu = scanner.nextInt();

            if(opcaoMenu == 0){
                continuaLogado = false;
            }else if(opcaoMenu == 1){
                    exibirLivros(livroList);
            }else if(opcaoMenu == 2 && adm){
                    criarLivros(scanner, livroList);
            }else if(opcaoMenu == 3 && adm){
                    editarLivro(scanner, livroList);
            }else if(opcaoMenu == 4 && adm){
                    removerLivro(scanner, livroList);
            }
        }
    }

    private static Boolean realizarLogin(Scanner scanner, GerenteLivro gerente, Boolean adm) {
        System.out.print("Digite a senha: ");
        int senha = scanner.nextInt();
        if(senha == gerente.getSenha()){
            adm = true;
        }
        return adm;
    }

    private static void criarLivros(Scanner scanner, ArrayList<Livro> livroList) {
        System.out.println("Quantos Livros Gostaria de adicionar ?");
        int numero = scanner.nextInt();
        
        for(int i = 1; i <= numero;i++){
            criarLivro(i, scanner, livroList);
        }
    }

    private static void removerLivro(Scanner scanner, ArrayList<Livro> livroList) {
        System.out.println("Qual a Posição Do Livro na lista ?");
        int remove = scanner.nextInt();
        livroList.remove(remove);
    }

    private static void editarLivro(Scanner scanner, ArrayList<Livro> livroList) {
        System.out.println("Qual Nome do Livro Gostaria de editar ?");
        String novoNome = scanner.next();
        for (Livro livro : livroList) {
            if( novoNome.equals(livro.getTitulo())){
                System.out.println("Qual Novo titulo e Nova:");
                novoNome = scanner.next();
                System.out.println("Qual a Quantidade de Paginas:");
                int pagi = scanner.nextInt();
                livro.EditarLivro(novoNome, pagi);
            }
        }
    }

    private static void criarLivro(int i, Scanner scanner, ArrayList<Livro> livroList) {
        System.out.println("Qual nome do livro" + i + "?");
        String nomeLivro = scanner.next();
        System.out.println("Quantas paginas tem o livro" + i + "?");
        int paginas = scanner.nextInt();
        Livro livro5 = new Livro(nomeLivro, paginas);
        livroList.add(livro5);
    }

    private static void exibirLivros(ArrayList<Livro> livroList) {
        System.out.println("\n\nLista de Livros");
        for (Livro livro : livroList) {
            System.out.println("Indice: " + livroList.indexOf(livro));
            System.out.println("Livro: " + livro.getTitulo());
            System.out.println("Paginas: " + livro.getQtdPaginas()+ "\n");
        }
    }

    private static void exibeMenu(Boolean adm) {
        System.out.println("|- Menu -|");
        System.out.println("0 - Sair do sistema");
        System.out.println("1 - Ver todos Livros");
        
        if(adm){
            System.out.println("2 - Adicionar Livro");
            System.out.println("3 - Editar Livro");
            System.out.println("4 - Apagar Livro");
        }
    }

    private static void povoarLista(ArrayList<Livro> livroList) {
        Livro livro1 = new Livro("Malphite", 55);
        livroList.add(livro1);
        Livro livro2 = new Livro("Rengar", 80);
        livroList.add(livro2);
        Livro livro3 = new Livro("Jhin", 30);
        livroList.add(livro3);
        Livro livro4 = new Livro("Kai'sa", 200);
        livroList.add(livro4);
    }
    
}
