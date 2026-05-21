package br.com.fiap.gaia.model;

public class Usuario {

    private String nome;
    private String email;
    private int pontos;
    private String nivel;
    private String interessePrincipal;

    public Usuario(String nome, String email, String interessePrincipal) {
        this.nome = nome;
        this.email = email;
        this.interessePrincipal = interessePrincipal;
        this.pontos = 0;
        this.nivel = "Iniciante";
    }

    public void adicionarPontos(int pontos) {
        if (pontos > 0) {
            this.pontos = this.pontos + pontos;
            atualizarNivel();
        }
    }

    public void atualizarNivel() {
        if (this.pontos >= 100) {
            this.nivel = "Avançado";
        } else if (this.pontos >= 50) {
            this.nivel = "Intermediário";
        } else {
            this.nivel = "Iniciante";
        }
    }

    public void comprarAcessorio(Acessorio acessorio) {
        if (this.pontos >= acessorio.getCustoPontos()) {
            this.pontos = this.pontos - acessorio.getCustoPontos();
            acessorio.desbloquear();
            atualizarNivel();
            System.out.println("Acessório comprado com sucesso!");
        } else {
            System.out.println("Pontos insuficientes para comprar o acessório.");
        }
    }

    public void exibirProgresso() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
        System.out.println("Interesse principal: " + this.interessePrincipal);
        System.out.println("Pontos: " + this.pontos);
        System.out.println("Nível: " + this.nivel);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }


    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }


    public String getInteressePrincipal() {
        return interessePrincipal;
    }

    public void setInteressePrincipal(String interessePrincipal) {
        this.interessePrincipal = interessePrincipal;
    }
}