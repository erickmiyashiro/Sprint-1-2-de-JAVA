package br.com.fiap.gaia.model;

public class ConteudoGerado {

    private String tipo;
    private String texto;
    private String categoria;

    public ConteudoGerado(String tipo, String categoria) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.texto = "";
    }

    public void gerarPostAutomatico(Usuario usuario, MissaoSustentavel missao) {
        this.texto = "Hoje, " + usuario.getNome() +
                " completou a missão \"" + missao.getTitulo() +
                "\" na categoria " + missao.getCategoria() +
                ". Pequenas atitudes também geram grandes impactos na sustentabilidade!";
    }

    public void exibirConteudo() {
        System.out.println("Tipo de conteúdo: " + this.tipo);
        System.out.println("Categoria: " + this.categoria);
        System.out.println("Texto gerado: " + this.texto);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
