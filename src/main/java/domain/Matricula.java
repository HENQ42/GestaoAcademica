package domain;

import java.util.Date;
import audit.Logger;

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
        try {
            this.aluno = aluno;
            this.turma = turma;
            this.dataMatricula = new Date();
            this.status = "CURSANDO";
            this.frequencia = 100;
            Logger.info("Matrícula criada para o aluno: " + aluno.getNome());
        } catch (Exception e) {
            Logger.error("Erro ao criar matrícula.", e);
        }
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void registrarNotas(double n1, double n2) {
        try {
            this.nota1 = n1;
            this.nota2 = n2;
            this.calcularMedia();
            Logger.info("Notas registradas para o aluno: " + aluno.getNome());
        } catch (Exception e) {
            Logger.error("Erro ao registrar notas.", e);
        }
    }

    public void registrarFrequencia(int faltas) {
        try {
            this.frequencia = 100 - faltas;
            Logger.info("Frequência atualizada para o aluno: " + aluno.getNome());
        } catch (Exception e) {
            Logger.error("Erro ao registrar frequência.", e);
        }
    }

    public void calcularMedia() {
        try {
            this.mediaFinal = (nota1 + nota2) / 2;
            verificarAprovacao();
            Logger.info("Média calculada: " + mediaFinal);
        } catch (Exception e) {
            Logger.error("Erro ao calcular média.", e);
        }
    }

    public boolean verificarAprovacao() {
        try {
            if (mediaFinal >= 6.0 && frequencia >= 75) {
                this.status = "APROVADO";
                Logger.info("Aluno aprovado: " + aluno.getNome());
                return true;
            } else {
                this.status = "REPROVADO";
                Logger.info("Aluno reprovado: " + aluno.getNome());
                return false;
            }
        } catch (Exception e) {
            Logger.error("Erro ao verificar aprovação.", e);
            return false;
        }
    }

    public String getResumo() {
        try {
            String resumo = String.format("Aluno: %-20s | Média: %.2f | Freq: %d%% | Status: %s", 
                aluno.getNome(), mediaFinal, frequencia, status);
            Logger.info("Resumo gerado para o aluno: " + aluno.getNome());
            return resumo;
        } catch (Exception e) {
            Logger.error("Erro ao gerar resumo.", e);
            return "Erro ao gerar resumo.";
        }
    }
}