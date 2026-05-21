package br.com.fiap.gaia.model;

public class Avatar {

    private String nome;
    private String personalidade;
    private Acessorio acessorioAtual;

    public Avatar(String nome, String personalidade) {
        this.nome = nome;
        this.personalidade = personalidade;
        this.acessorioAtual = null;
    }

    public void apresentarUsuario(Usuario usuario) {
        System.out.println("Olá, " + usuario.getNome() + "!");
        System.out.println("Eu sou " + this.nome + ", seu avatar inteligente da SoulUp.");
        System.out.println("Minha personalidade é: " + this.personalidade);
        System.out.println("Vou te ajudar com missões sustentáveis.");
    }

    public MissaoSustentavel sugerirMissao(Usuario usuario) {
        String interesse = usuario.getInteressePrincipal();

        if (interesse.equalsIgnoreCase("energia")) {
            return new MissaoSustentavel(
                    "Economizar energia",
                    "Aproveite a luz natural por 2 horas durante o dia.",
                    "Energia",
                    50
            );
        } else if (interesse.equalsIgnoreCase("agua") || interesse.equalsIgnoreCase("água")) {
            return new MissaoSustentavel(
                    "Economizar água",
                    "Reduza o tempo do banho e evite desperdício de água.",
                    "Água",
                    40
            );
        } else if (interesse.equalsIgnoreCase("reciclagem")) {
            return new MissaoSustentavel(
                    "Separar resíduos",
                    "Separe lixo reciclável e lixo orgânico durante o dia.",
                    "Reciclagem",
                    45
            );
        } else if (interesse.equalsIgnoreCase("transporte")) {
            return new MissaoSustentavel(
                    "Mobilidade sustentável",
                    "Use transporte público, bicicleta ou caminhada em um trajeto curto.",
                    "Transporte",
                    60
            );
        } else {
            return new MissaoSustentavel(
                    "Ação sustentável diária",
                    "Realize uma pequena ação sustentável hoje e registre seu progresso.",
                    "Geral",
                    30
            );
        }
    }

    public String gerarMensagemMotivacional(Usuario usuario) {
        if (usuario.getPontos() >= 100) {
            return "Parabéns, " + usuario.getNome() + "! Você está em um nível avançado de impacto sustentável.";
        } else if (usuario.getPontos() >= 50) {
            return "Muito bem, " + usuario.getNome() + "! Continue completando missões para evoluir ainda mais.";
        } else {
            return "Vamos começar, " + usuario.getNome() + "! Pequenas atitudes também geram impacto.";
        }
    }

    public void trocarAcessorio(Acessorio acessorio) {
        if (acessorio.isDesbloqueado()) {
            this.acessorioAtual = acessorio;
            System.out.println("Acessório trocado com sucesso!");
            System.out.println("Acessório atual: " + acessorio.getNome());
        } else {
            System.out.println("Não foi possível trocar o acessório.");
            System.out.println("Esse acessório ainda está bloqueado.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getPersonalidade() {
        return personalidade;
    }

    public void setPersonalidade(String personalidade) {
        this.personalidade = personalidade;
    }


    public Acessorio getAcessorioAtual() {
        return acessorioAtual;
    }

    public void setAcessorioAtual(Acessorio acessorioAtual) {
        this.acessorioAtual = acessorioAtual;
    }
}