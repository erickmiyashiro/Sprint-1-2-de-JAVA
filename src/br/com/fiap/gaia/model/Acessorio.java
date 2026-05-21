package br.com.fiap.gaia.model;

public class Acessorio {

    private String nome;
    private String tema;
    private int custoPontos;
    private boolean desbloqueado;

    public Acessorio(String nome, String tema, int custoPontos) {
        this.nome = nome;
        this.tema = tema;
        this.custoPontos = custoPontos;
        this.desbloqueado = false;
    }

    public void desbloquear() {
        this.desbloqueado = true;
    }

    public void exibirAcessorio() {
        System.out.println("Acessório: " + this.nome);
        System.out.println("Tema: " + this.tema);
        System.out.println("Custo em pontos: " + this.custoPontos);

        if (this.desbloqueado) {
            System.out.println("Status: desbloqueado");
        } else {
            System.out.println("Status: bloqueado");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }


    public int getCustoPontos() {
        return custoPontos;
    }

    public void setCustoPontos(int custoPontos) {
        this.custoPontos = custoPontos;
    }


    public boolean isDesbloqueado() {
        return desbloqueado;
    }

    public void setDesbloqueado(boolean desbloqueado) {
        this.desbloqueado = desbloqueado;
    }
}