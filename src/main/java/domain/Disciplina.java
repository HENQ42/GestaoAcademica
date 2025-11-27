package domain;

public class Disciplina {
    private String nome;
    private String codigoDisciplina;
    private int cargaHoraria;
    private String ementa;

    public Disciplina(String nome, String codigoDisciplina, int cargaHoraria, String ementa) {
        this.nome = nome;
        this.codigoDisciplina = codigoDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.ementa = ementa;
    }

    public String getNome() {
        return nome;
    }

    public String getDetalhes() {
        return "Disciplina: " + nome + " (" + codigoDisciplina + ") - " + cargaHoraria + "h";
    }
}

