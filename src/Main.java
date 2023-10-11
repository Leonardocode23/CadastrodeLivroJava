import java.rmi.UnexpectedException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> listaLivro = new ArrayList<>();
        Livro metodoLivro = new Livro();


        System.out.println("Bem vindo ao sistema de cadastro de Livros!");


        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("Escolha uma opção: 1 - Cadastrar Livro / 2 - Listar Livros Cadastrados / 0 - Sair");
            opcao = scanner.nextInt();
            System.out.println();

            switch (opcao) {

                case 1:
                    Livro novoLivro = new Livro();
                    Autor novoAutorLivro = new Autor();

                    System.out.println("Digite o titulo do Livro: ");
                    novoLivro.titulo = scanner.next();


                    System.out.println("Digite o Autor do Livro: ");
                    novoAutorLivro.nome = scanner.next();


                    System.out.println("Digite o local de Nascimento do Autor: ");
                    novoAutorLivro.localNasc = scanner.next();
                    System.out.println();

                    System.out.println("Digite o valor do Livro: ");
                    novoLivro.preco = Float.parseFloat(scanner.next());
                    System.out.println();

                    System.out.println("Digite quando foi lançado (dd/MM/aaaa): ");
                    LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Period periodo = Period.between(date, LocalDate.now());

                    novoLivro.dataNascimento = String.valueOf(date);

                    if (periodo.getYears() >= 5) {
                        System.out.println("O livro tem mais de 5 Anos de Lançamento! ");
                    } else {
                        System.out.println("So pode cadastrar Livros com mais de 5 anos de Lançamento!!");
                        break;
                    }

                   novoLivro.autor = novoAutorLivro;

                    listaLivro.add(novoLivro);

                    System.out.println("Cadastro realizado com sucesso!");
                    break;

                case 2:

                    if (listaLivro.size() > 0) {

                        for (Livro cadaLivro : listaLivro) {
                            System.out.println();
                            System.out.println("Titulo: " + cadaLivro.titulo);
                            System.out.println("Autor: " + cadaLivro.autor.nome);
                            System.out.println("Local de Nascimento: " + cadaLivro.autor.localNasc );
                            System.out.println("Preço: " + cadaLivro.preco);
                            System.out.println("Data de Lançamento: " + cadaLivro.dataNascimento);
                            System.out.println();

                        }

                    } else {
                        System.out.println("Lista vazia");
                    }

                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida, Digite uma Opecao Valida!");
                    break;
            }
        } while (opcao != 0);


    }

}