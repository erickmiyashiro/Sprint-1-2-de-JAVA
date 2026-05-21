package br.com.fiap.gaia.model;

public class NotificacaoInteligente {

    private String titulo;
    private String mensagem;
    private String gatilho;

    public NotificacaoInteligente(String titulo, String gatilho) {
        this.titulo = titulo;
        this.gatilho = gatilho;
        this.mensagem = "";
    }

    public void gerarNotificacao(Usuario usuario) {
        if (usuario.getPontos() >= 100) {
            this.mensagem = usuario.getNome() +
                    ", você já possui muitos pontos! Continue sua sequência sustentável.";
        } else if (usuario.getPontos() >= 50) {
            this.mensagem = usuario.getNome() +
                    ", você está evoluindo bem! Complete mais uma missão para subir de nível.";
        } else {
            this.mensagem = usuario.getNome() +
                    ", que tal começar uma missão sustentável hoje?";
        }
    }

    public void exibirNotificacao() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Gatilho: " + this.gatilho);
        System.out.println("Mensagem: " + this.mensagem);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


    public String getGatilho() {
        return gatilho;
    }

    public void setGatilho(String gatilho) {
        this.gatilho = gatilho;
    }
}