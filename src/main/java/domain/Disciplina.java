package domain;

import audit.Logger;

public class Disciplina {
    private String nome;
    private String codigoDisciplina;
    private int cargaHoraria;
    private String ementa;

    public Disciplina(String nome, String codigoDisciplina, int cargaHoraria, String ementa) {
        try {
            this.nome = nome;
            this.codigoDisciplina = codigoDisciplina;
            this.cargaHoraria = cargaHoraria;
            this.ementa = ementa;
            Logger.info("Disciplina criada: " + nome);
        } catch (Exception e) {
            Logger.error("Erro ao criar disciplina: " + nome, e);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getDetalhes() {
        try {
            String detalhes = "Disciplina: " + nome + " (" + codigoDisciplina + ") - " + cargaHoraria + "h";
            Logger.info("Detalhes obtidos para disciplina: " + nome);
            return detalhes;
        } catch (Exception e) {
            Logger.error("Erro ao obter detalhes da disciplina: " + nome, e);
            return "Erro ao obter detalhes.";
        }
    }
}