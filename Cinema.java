// Breno Borges e Yan Barreto

import java.util.Scanner;
import java.time.LocalTime;

class Cinema {
    public static Filme escolherFilme(Scanner input, Filme filme1, Filme filme2, Filme filme3) {
        int opcao;

        do {
            System.out.print(
                    "== Escolha um dos filmes ==\n" +
                            "1- " + filme1.getTitulo() + " | " + filme1.cCategoria() + "\n" +
                            "2- " + filme2.getTitulo() + " | " + filme2.cCategoria() + "\n" +
                            "3- " + filme3.getTitulo() + " | " + filme3.cCategoria() + "\n" +
                            "0- Voltar\n\n" +
                            ": ");
            opcao = input.nextInt();

            if (opcao < 0 || opcao > 3) {
                System.out.println("Opção Inválida! Tente novamente.");
            }
        } while (opcao < 0 || opcao > 3);

        switch (opcao) {
            case 1:
                return filme1;
            case 2:
                return filme2;
            case 3:
                return filme3;
            default:
                return null;
        }
    }

    public static void gerenciarFilme(Scanner input, Filme filme1, Filme filme2, Filme filme3) {
        Filme filme = escolherFilme(input, filme1, filme2, filme3);

        if (filme == null) {
            return;
        }

        int opcao;
        do {
            System.out.print(
                    "== MENU FILME ==\n" +
                            "1- Consultar os dados do filme\n" +
                            "2- Alterar a categoria\n" +
                            "3- Alterar a sinopse\n" +
                            "0- Voltar ao menu principal\n\n" +
                            ": ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    String classificacao;
                    if (filme.getClassificacao() == 0) {
                        classificacao = "Livre";
                    } else {
                        classificacao = filme.getClassificacao() + " anos";
                    }
                    System.out.println(
                            "== Dados do filme ==\n" +
                                    "Titúlo: " + filme.getTitulo() + "\n" +
                                    "Duração: " + filme.getDuracao() + " minutos\n" +
                                    "Classificação etária: " + classificacao + "\n" +
                                    "Categoria: " + filme.cCategoria() + "\n" +
                                    "Sinopse: " + filme.getSinopse());
                    break;
                case 2:
                    System.out.print(
                            "== Categorias disponíveis ==\n" +
                                    "- Ação\n" +
                                    "- Aventura\n" +
                                    "- Comédia\n" +
                                    "- Drama\n" +
                                    "- Terror\n\n" +
                                    "Digite a nova categoria: ");
                    String categoria = input.nextLine();

                    if (filme.altCategorias(categoria)) {
                        System.out.println("Categoria alterada com sucesso!");
                    } else {
                        System.out.println("Categoria inválida! Alteração recusada.");
                    }
                    break;
                case 3:
                    System.out.print("Digite a nova sinopse do filme: ");
                    String sinopse = input.nextLine();

                    filme.setSinopse(sinopse);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void informacoesCinema(Scanner input, Sessao sessao1, Sessao sessao2, Sessao sessao3,
            Sessao sessao4, Sessao sessao5) {
        int opcao;

        do {
            System.out.print(
                    "== Informações cinema ==\n" +
                            "1- Consultar o preço integral do ingresso\n" +
                            "2- Alterar o preço integral do ingresso\n" +
                            "3- Consultar os totais de ingressos vendidos e arrecadação\n" +
                            "0- Voltar ao menu principal\n\n" +
                            ": ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.printf("Preço integral: R$ %.2f%n", Sessao.cPrecoingresso());
                    break;
                case 2:
                    System.out.print("Digite o novo preço integral dos ingressos: ");
                    double preco = input.nextDouble();

                    if (Sessao.altPrecoingresso(preco)) {
                        System.out.println("Preço alterado com sucesso!");
                    } else {
                        System.out.println("Preço inválido! Alteração recusada.");
                    }
                    break;
                case 3:
                    int totalIngressos = sessao1.cIngreVend() +
                            sessao2.cIngreVend() +
                            sessao3.cIngreVend() +
                            sessao4.cIngreVend() +
                            sessao5.cIngreVend();

                    double totalArrecadado = sessao1.cValorArre() +
                            sessao2.cValorArre() +
                            sessao3.cValorArre() +
                            sessao4.cValorArre() +
                            sessao5.cValorArre();

                    System.out.println("Total de ingressos vendidos: " + totalIngressos);
                    System.out.printf("Preço integral: R$ %.2f%n", totalArrecadado);
                default:
                    break;
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Filmes
        Filme filme1 = new Filme("Gente grande", 102, "Comédia", 12);

        Filme filme2 = new Filme("Homem aranha: Um novo dia", 150, "Ação", 12);

        Filme filme3 = new Filme("O rei leão", 112);

        // Sessões
        Sessao sessao1 = new Sessao("SO1", filme1, LocalTime.of(15, 0), 100);
        Sessao sessao2 = new Sessao("SO2", filme1, LocalTime.of(19, 0));

        Sessao sessao3 = new Sessao("SO3", filme2, LocalTime.of(14, 0), 105);
        Sessao sessao4 = new Sessao("SO4", filme2, LocalTime.of(18, 0));

        Sessao sessao5 = new Sessao("SO5", filme3, LocalTime.of(15, 0), 92);

        // Menu
        int opcao;
        do {
            System.out.print(
                    "==== MENU PRINCIPAL ====\n" +
                            "1- Gerenciar filmes\n" +
                            "2- Gerenciar sessões e vender ingressos\n" +
                            "3- Consultar e atualizar informações do cinema\n" +
                            "0-  Sair\n\n" +
                            ": ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    gerenciarFilme(input, filme1, filme2, filme3);
                    break;
                case 2:

                    break;
                case 3:
                    informacoesCinema(input, sessao1, sessao2, sessao3, sessao4, sessao5);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        input.close();
    }
}