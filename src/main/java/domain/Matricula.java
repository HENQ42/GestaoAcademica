package domain;

import java.util.Date;

public class Matricula {
    private Aluno aluno;
    private Turma turma;
    private Date dataMatricula;
    private double nota1;
    private double nota2;
    private double mediaFinal;
    private int frequencia;
    private String status;

    public Matricula(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
        this.dataMatricula = new Date();
        this.status = "CURSANDO";
        this.frequencia = 100;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void registrarNotas(double n1, double n2) {
        this.nota1 = n1;
        this.nota2 = n2;
        this.calcularMedia();
    }

    public void registrarFrequencia(int faltas) {
        this.frequencia = 100 - faltas;
    }

    public void calcularMedia() {
        this.mediaFinal = (nota1 + nota2) / 2;
        verificarAprovacao();
    }

    public boolean verificarAprovacao() {
        if (mediaFinal >= 6.0 && frequencia >= 75) {
            this.status = "APROVADO";
            return true;
        } else {
            this.status = "REPROVADO";
            return false;
        }
    }

    public String getResumo() {
        return String.format("Aluno: %-20s | Média: %.2f | Freq: %d%% | Status: %s", 
            aluno.getNome(), mediaFinal, frequencia, status);
    }
}

