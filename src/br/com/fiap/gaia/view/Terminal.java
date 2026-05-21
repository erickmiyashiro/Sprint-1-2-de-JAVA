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
        System.out.println("energia");
        System.out.println("água");
        System.out.println("reciclagem");
        System.out.println("transporte");
        System.out.print("Digite sua escolha: ");
        String interesse = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email, interesse);
        Avatar avatar = new Avatar("Gaia", "Motivadora");
        Acessorio acessorio = new Acessorio("Boné Gaia", "Natureza", 30);

        System.out.println();
        System.out.println("-------------------------");
        avatar.apresentarUsuario(usuario);

        System.out.println("-------------------------");
        System.out.println("Gaia analisou seu interesse principal...");
        MissaoSustentavel missao = avatar.sugerirMissao(usuario);
        missao.exibirMissao();

        System.out.println("-------------------------");
        System.out.print("Você deseja concluir essa missão agora? Digite sim ou nao: ");
        String respostaMissao = scanner.nextLine();

        if (respostaMissao.equalsIgnoreCase("sim")) {
            missao.concluirMissao(usuario);

            System.out.println("-------------------------");
            String mensagem = avatar.gerarMensagemMotivacional(usuario);
            System.out.println(mensagem);

            System.out.println("-------------------------");
            ConteudoGerado conteudo = new ConteudoGerado("Post automático", missao.getCategoria());
            conteudo.gerarPostAutomatico(usuario, missao);
            conteudo.exibirConteudo();

        } else {
            System.out.println("Tudo bem! A missão continuará pendente para você concluir depois.");
        }

        System.out.println("-------------------------");
        NotificacaoInteligente notificacao = new NotificacaoInteligente(
                "Lembrete Gaia",
                "Progresso do usuário"
        );

        notificacao.gerarNotificacao(usuario);
        notificacao.exibirNotificacao();

        System.out.println("-------------------------");
        System.out.println("Seu progresso atual:");
        usuario.exibirProgresso();

        System.out.println("-------------------------");
        System.out.println("A Gaia encontrou um acessório disponível:");
        acessorio.exibirAcessorio();

        System.out.println("-------------------------");
        System.out.print("Você deseja comprar esse acessório? Digite sim ou nao: ");
        String respostaAcessorio = scanner.nextLine();

        if (respostaAcessorio.equalsIgnoreCase("sim")) {
            usuario.comprarAcessorio(acessorio);

            System.out.println("-------------------------");
            System.out.print("Deseja equipar esse acessório na Gaia? Digite sim ou nao: ");
            String respostaTroca = scanner.nextLine();

            if (respostaTroca.equalsIgnoreCase("sim")) {
                avatar.trocarAcessorio(acessorio);
            } else {
                System.out.println("Acessório comprado, mas ainda não foi equipado.");
            }

        } else {
            System.out.println("Você decidiu não comprar o acessório agora.");
        }

        System.out.println("-------------------------");
        System.out.println("Resumo final do usuário:");
        usuario.exibirProgresso();

        System.out.println("-------------------------");
        System.out.println("Resumo final do acessório:");
        acessorio.exibirAcessorio();

        System.out.println("-------------------------");
        System.out.println("Obrigado por usar o Gaia Smart Bot!");

        scanner.close();
    }
}