package br.com.fiap.gaia.view;

import br.com.fiap.gaia.model.Usuario;
import br.com.fiap.gaia.model.Avatar;
import br.com.fiap.gaia.model.Acessorio;
import br.com.fiap.gaia.model.MissaoSustentavel;
import br.com.fiap.gaia.model.ConteudoGerado;
import br.com.fiap.gaia.model.NotificacaoInteligente;

import java.util.Scanner;

public class Terminal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("        GAIA SMART BOT");
        System.out.println("==================================");

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        System.out.println();
        System.out.println("Escolha seu principal interesse sustentável:");
        System.out.println("1 - Energia");
        System.out.println("2 - Água");
        System.out.println("3 - Reciclagem");
        System.out.println("4 - Transporte");
        System.out.print("Digite o número da opção: ");
        int opcaoInteresse = Integer.parseInt(scanner.nextLine());

        String interesse;

        if (opcaoInteresse == 1) {
            interesse = "energia";
        } else if (opcaoInteresse == 2) {
            interesse = "água";
        } else if (opcaoInteresse == 3) {
            interesse = "reciclagem";
        } else if (opcaoInteresse == 4) {
            interesse = "transporte";
        } else {
            interesse = "geral";
        }

        Usuario usuario = new Usuario(nome, email, interesse);
        Avatar avatar = new Avatar("Gaia", "Motivadora");
        Acessorio acessorio = new Acessorio("Boné Gaia", "Natureza", 30);
        NotificacaoInteligente notificacao = new NotificacaoInteligente(
                "Lembrete Gaia",
                "Progresso do usuário"
        );

        MissaoSustentavel missao = null;
        ConteudoGerado conteudo = null;

        int opcao = -1;

        while (opcao != 0) {

            System.out.println();
            System.out.println("==================================");
            System.out.println("              MENU");
            System.out.println("==================================");
            System.out.println("1 - Conversar com a Gaia");
            System.out.println("2 - Receber missão sustentável");
            System.out.println("3 - Ver missão atual");
            System.out.println("4 - Concluir missão");
            System.out.println("5 - Gerar post automático");
            System.out.println("6 - Ver notificação inteligente");
            System.out.println("7 - Comprar acessório");
            System.out.println("8 - Equipar acessório");
            System.out.println("9 - Ver progresso");
            System.out.println("10 - Ver acessório");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            System.out.println();

            switch (opcao) {

                case 1:
                    avatar.apresentarUsuario(usuario);
                    break;

                case 2:
                    missao = avatar.sugerirMissao(usuario);
                    System.out.println("A Gaia analisou seu interesse principal e sugeriu uma missão:");
                    missao.exibirMissao();
                    break;

                case 3:
                    if (missao != null) {
                        missao.exibirMissao();
                    } else {
                        System.out.println("Você ainda não recebeu nenhuma missão.");
                        System.out.println("Escolha a opção 2 para receber uma missão sustentável.");
                    }
                    break;

                case 4:
                    if (missao != null) {
                        missao.concluirMissao(usuario);
                    } else {
                        System.out.println("Você ainda não recebeu uma missão.");
                        System.out.println("Escolha a opção 2 antes de tentar concluir uma missão.");
                    }
                    break;

                case 5:
                    if (missao != null && missao.isConcluida()) {
                        conteudo = new ConteudoGerado("Post automático", missao.getCategoria());
                        conteudo.gerarPostAutomatico(usuario, missao);
                        conteudo.exibirConteudo();
                    } else {
                        System.out.println("Você precisa concluir uma missão antes de gerar um post automático.");
                    }
                    break;

                case 6:
                    notificacao.gerarNotificacao(usuario);
                    notificacao.exibirNotificacao();
                    break;

                case 7:
                    usuario.comprarAcessorio(acessorio);
                    break;

                case 8:
                    avatar.trocarAcessorio(acessorio);
                    break;

                case 9:
                    usuario.exibirProgresso();
                    break;

                case 10:
                    acessorio.exibirAcessorio();
                    break;

                case 0:
                    System.out.println("Encerrando o Gaia Smart Bot...");
                    break;

                default:
                    System.out.println("Opção inválida. Escolha uma opção do menu.");
                    break;
            }
        }

        scanner.close();
    }
}