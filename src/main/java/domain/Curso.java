package domain;

import java.util.ArrayList;
import java.util.List;
import audit.Logger;

public class Curso {
    private String nome;
    private int codigoCurso;
    private int qtdSemestres;
    private List<Disciplina> gradeCurricular;

    public Curso(String nome, int codigoCurso, int qtdSemestres) {
        try {
            this.nome = nome;
            this.codigoCurso = codigoCurso;
            this.qtdSemestres = qtdSemestres;
            this.gradeCurricular = new ArrayList<>();
            Logger.info("Curso criado: " + nome);
        } catch (Exception e) {
            Logger.error("Erro ao criar curso: " + nome, e);
        }
    }

    public void adicionarDisciplina(Disciplina d) {
        try {
            this.gradeCurricular.add(d);
            Logger.info("Disciplina adicionada ao curso " + this.nome);
        } catch (Exception e) {
            Logger.error("Erro ao adicionar disciplina ao curso " + this.nome, e);
        }
    }

    public String getNome() {
        return nome;
    }
}