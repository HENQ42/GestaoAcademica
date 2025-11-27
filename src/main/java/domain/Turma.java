package domain;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigoTurma;
    private String semestre;
    private int ano;
    private boolean ativa;
    private Disciplina disciplina;
    private Professor professor;
    private List<Matricula> matriculas;

    public Turma(String codigoTurma, String semestre, int ano, Disciplina disciplina, Professor professor) {
        this.codigoTurma = codigoTurma;
        this.semestre = semestre;
        this.ano = ano;
        this.disciplina = disciplina;
        this.professor = professor;
        this.ativa = true;
        this.matriculas = new ArrayList<>();
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (!ativa) return false;
        
        for (Matricula m : matriculas) {
            if (m.getAluno().getMatricula().equals(aluno.getMatricula())) {
                return false; 
            }
        }

        Matricula novaMatricula = new Matricula(aluno, this);
        matriculas.add(novaMatricula);
        return true;
    }

    public Matricula buscarMatricula(String matriculaAluno) {
        for (Matricula m : matriculas) {
            if (m.getAluno().getMatricula().equals(matriculaAluno)) {
                return m;
            }
        }
        return null;
    }

    public String gerarPauta() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== PAUTA: ").append(disciplina.getNome()).append(" ===\n");
        sb.append("Professor: ").append(professor.getNome()).append("\n");
        sb.append("--------------------------------------------------\n");
        for (Matricula m : matriculas) {
            sb.append(m.getResumo()).append("\n");
        }
        sb.append("--------------------------------------------------\n");
        return sb.toString();
    }

    public void fecharTurma() {
        this.ativa = false;
        for (Matricula m : matriculas) {
            m.verificarAprovacao();
        }
    }
}

