package domain;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private int codigoCurso;
    private int qtdSemestres;
    private List<Disciplina> gradeCurricular;

    public Curso(String nome, int codigoCurso, int qtdSemestres) {
        this.nome = nome;
        this.codigoCurso = codigoCurso;
        this.qtdSemestres = qtdSemestres;
        this.gradeCurricular = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina d) {
        this.gradeCurricular.add(d);
    }

    public String getNome() {
        return nome;
    }
}

