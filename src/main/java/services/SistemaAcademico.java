package service;

import domain.Aluno;
import domain.Curso;
import domain.Professor;
import domain.Turma;
import java.util.ArrayList;
import java.util.List;

public class SistemaAcademico {
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Curso> cursos;
    private List<Turma> turmas;

    public SistemaAcademico() {
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno a) {
        alunos.add(a);
    }

    public void cadastrarProfessor(Professor p) {
        professores.add(p);
    }

    public void cadastrarCurso(Curso c) {
        cursos.add(c);
    }

    public void cadastrarTurma(Turma t) {
        turmas.add(t);
    }

    public Aluno buscarAluno(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public int totalAlunos() {
        return alunos.size();
    }
}

