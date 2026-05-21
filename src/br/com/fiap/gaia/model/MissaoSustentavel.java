package br.com.fiap.gaia.model;

public class MissaoSustentavel {

    private String titulo;
    private String descricao;
    private String categoria;
    private int pontosRecompensa;
    private boolean concluida;

    public MissaoSustentavel(String titulo, String descricao, String categoria, int pontosRecompensa) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.pontosRecompensa = pontosRecompensa;
        this.concluida = false;
    }

    public void concluirMissao(Usuario usuario) {
        if (this.concluida == false) {
            this.concluida = true;
            usuario.adicionarPontos(this.pontosRecompensa);
            System.out.println("Missão concluída com sucesso!");
            System.out.println("Você ganhou " + this.pontosRecompensa + " pontos.");
        } else {
            System.out.println("Essa missão já foi concluída.");
        }
    }

    public void exibirMissao() {
        System.out.println("Missão: " + this.titulo);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Categoria: " + this.categoria);
        System.out.println("Pontos de recompensa: " + this.pontosRecompensa);

        if (this.concluida) {
            System.out.println("Status: concluída");
        } else {
            System.out.println("Status: pendente");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public int getPontosRecompensa() {
        return pontosRecompensa;
    }

    public void setPontosRecompensa(int pontosRecompensa) {
        this.pontosRecompensa = pontosRecompensa;
    }


    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}