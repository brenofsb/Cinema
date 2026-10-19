// Breno Ferreira Santos Borges e Yan Barreto Guedes Vieira

import java.util.Scanner;
import java.time.LocalTime;

public class Cinema {

    // ========================= FILMES =========================

    public static Filme escolherFilme(Scanner input, Filme filme1, Filme filme2, Filme filme3) {
        int opcao;

        do {
            System.out.print(
                    "== Escolha um dos filmes ==\n" +
                            "1- " + filme1.getTitulo() + " | " + filme1.getCategoria() + "\n" +
                            "2- " + filme2.getTitulo() + " | " + filme2.getCategoria() + "\n" +
                            "3- " + filme3.getTitulo() + " | " + filme3.getCategoria() + "\n" +
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

    // Usado tanto na consulta do filme quanto nos detalhes da sessão
    public static void exibirDadosFilme(Filme filme) {
        String classificacao;
        if (filme.getClassificacao() == 0) {
            classificacao = "Livre";
        } else {
            classificacao = filme.getClassificacao() + " anos";
        }
        System.out.println(
                "Título: " + filme.getTitulo() + "\n" +
                        "Duração: " + (int) filme.getDuracao() + " minutos\n" +
                        "Classificação etária: " + classificacao + "\n" +
                        "Categoria: " + filme.getCategoria() + "\n" +
                        "Sinopse: " + filme.getSinopse());
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
                    System.out.println("== Dados do filme ==");
                    exibirDadosFilme(filme);
                    System.out.println();
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

                    if (filme.categorias(categoria)) {
                        System.out.println("Categoria alterada com sucesso!");
                    } else {
                        System.out.println("Categoria inválida! Alteração recusada.");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Digite a nova sinopse do filme: ");
                    String sinopse = input.nextLine();

                    filme.setSinopse(sinopse);
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
            }
        } while (opcao != 0);
    }

    // ========================= SESSÕES =========================

    public static Sessao escolherSessao(Scanner input, Sessao sessao1, Sessao sessao2, Sessao sessao3,
            Sessao sessao4, Sessao sessao5) {
        int opcao;

        do {
            System.out.print(
                    "== Escolha uma das sessões ==\n" +
                            "1- " + sessao1.cId() + " | " + sessao1.cFilme().getTitulo() + " | "
                            + sessao1.cHorarioInicio() + "\n" +
                            "2- " + sessao2.cId() + " | " + sessao2.cFilme().getTitulo() + " | "
                            + sessao2.cHorarioInicio() + "\n" +
                            "3- " + sessao3.cId() + " | " + sessao3.cFilme().getTitulo() + " | "
                            + sessao3.cHorarioInicio() + "\n" +
                            "4- " + sessao4.cId() + " | " + sessao4.cFilme().getTitulo() + " | "
                            + sessao4.cHorarioInicio() + "\n" +
                            "5- " + sessao5.cId() + " | " + sessao5.cFilme().getTitulo() + " | "
                            + sessao5.cHorarioInicio() + "\n" +
                            "0- Voltar\n\n" +
                            ": ");
            opcao = input.nextInt();

            if (opcao < 0 || opcao > 5) {
                System.out.println("Opção Inválida! Tente novamente.");
            }
        } while (opcao < 0 || opcao > 5);

        switch (opcao) {
            case 1:
                return sessao1;
            case 2:
                return sessao2;
            case 3:
                return sessao3;
            case 4:
                return sessao4;
            case 5:
                return sessao5;
            default:
                return null;
        }
    }

    public static void detalhesSessao(Sessao sessao) {
        System.out.println(
                "== Detalhes da sessão ==\n" +
                        "Código: " + sessao.cId() + "\n" +
                        "Horário de início: " + sessao.cHorarioInicio() + "\n" +
                        "Horário de término: " + sessao.cHorarioTermino() + "\n" +
                        "-- Filme --");
        exibirDadosFilme(sessao.cFilme());
        System.out.println(
                "-- Ingressos --\n" +
                        "Capacidade máxima: " + sessao.cCapacidade() + "\n" +
                        "Ingressos vendidos: " + sessao.cIngreVend() + "\n" +
                        "Lugares disponíveis: " + sessao.lugarDisponivel());
        System.out.printf("Arrecadação da sessão: R$ %.2f%n", sessao.cValorArre());
    }

    public static void venderIngresso(Scanner input, Sessao sessao) {
        System.out.print(
                "== Tipo de ingresso ==\n" +
                        "1- Integral\n" +
                        "2- Meia-entrada\n" +
                        "0- Cancelar\n\n" +
                        ": ");
        int tipo = input.nextInt();
        input.nextLine();

        if (tipo == 0) {
            return;
        }
        if (tipo != 1 && tipo != 2) {
            System.out.println("Opção inválida! Venda cancelada.");
            return;
        }

        System.out.print("Digite a idade do espectador: ");
        int idade = input.nextInt();
        input.nextLine();

        double valor;
        if (tipo == 1) {
            valor = sessao.vendaIngre(idade);
        } else {
            System.out.print("Digite o número do documento comprobatório: ");
            String documento = input.nextLine();
            valor = sessao.vendaIngre(idade, documento);
        }

        if (valor == -1) {
            System.out.println("Venda recusada: dados inválidos (idade negativa ou documento não informado).");
        } else if (valor == -2) {
            System.out.println("Venda recusada: a idade do espectador não atende à classificação do filme.");
        } else if (valor == -3) {
            System.out.println("Venda recusada: não há lugares disponíveis nesta sessão.");
        } else {
            System.out.printf("Ingresso vendido com sucesso! Valor cobrado: R$ %.2f%n", valor);
        }
    }

    public static void gerenciarSessao(Scanner input, Sessao sessao1, Sessao sessao2, Sessao sessao3,
            Sessao sessao4, Sessao sessao5) {
        Sessao sessao = escolherSessao(input, sessao1, sessao2, sessao3, sessao4, sessao5);

        if (sessao == null) {
            return;
        }

        int opcao;
        do {
            System.out.print(
                    "== MENU SESSÃO ==\n" +
                            "1- Consultar os detalhes da sessão\n" +
                            "2- Vender ingresso\n" +
                            "3- Consultar os lugares disponíveis\n" +
                            "4- Consultar o horário de término\n" +
                            "0- Voltar ao menu principal\n\n" +
                            ": ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    detalhesSessao(sessao);
                    System.out.println();

                    break;
                case 2:
                    venderIngresso(input, sessao);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Lugares disponíveis: " + sessao.lugarDisponivel());
                                        System.out.println();
                    break;
                case 4:
                    System.out.println("Horário de término: " + sessao.cHorarioTermino());
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
            }
        } while (opcao != 0);
    }

    // ========================= INFORMAÇÕES DO CINEMA =========================

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
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.printf("Preço integral: R$ %.2f%n", Sessao.cPrecoingresso());
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Digite o novo preço integral dos ingressos: ");
                    // Lê como texto e aceita vírgula ou ponto como separador decimal
                    String texto = input.nextLine().trim().replace(',', '.');

                    try {
                        double preco = Double.parseDouble(texto);

                        if (Sessao.altPrecoingresso(preco)) {
                            System.out.println("Preço alterado com sucesso!");
                        } else {
                            System.out.println("Preço inválido! Alteração recusada.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Preço inválido! Alteração recusada.");
                    }
                    System.out.println();
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
                    System.out.printf("Valor total arrecadado: R$ %.2f%n", totalArrecadado);
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
            }
        } while (opcao != 0);
    }

    // ========================= MAIN =========================

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

        Sessao sessao5 = new Sessao("SO5", filme3, LocalTime.of(16, 30), 92);

        // Menu
        int opcao;
        do {
            System.out.print(
                    "==== MENU PRINCIPAL ====\n" +
                            "1- Gerenciar filmes\n" +
                            "2- Gerenciar sessões e vender ingressos\n" +
                            "3- Consultar e atualizar informações do cinema\n" +
                            "0- Sair\n\n" +
                            ": ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    gerenciarFilme(input, filme1, filme2, filme3);
                    break;
                case 2:
                    gerenciarSessao(input, sessao1, sessao2, sessao3, sessao4, sessao5);
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
