package domain;

import audit.Logger;

public class Aluno extends Pessoa {
    private String matricula;
    private Curso curso;

    public Aluno(String nome, String cpf, String email, String matricula, Curso curso) {
        super(nome, cpf, email);
        this.matricula = matricula;
        this.curso = curso;
        Logger.info("Objeto Aluno criado: " + nome + " (Matrícula: " + matricula + ")");
    }

    public String getMatricula() {
        return matricula;
    }

    public void solicitarMatricula(Turma turma) {
        try {
            if (turma == null) {
                throw new IllegalArgumentException("A turma não pode ser nula.");
            }

            boolean sucesso = turma.adicionarAluno(this);
            
            if (sucesso) {
                Logger.info("Matrícula realizada com sucesso para: " + this.nome);
            } else {
                Logger.info("Não foi possível realizar matrícula para: " + this.nome);
            }
        } catch (Exception e) {
            Logger.error("Erro ao solicitar matrícula para " + this.nome, e);
        }
    }

    public String consultarHistorico() {
        try {
            if (curso == null) {
                throw new IllegalStateException("Aluno sem curso vinculado.");
            }
            String historico = "Histórico do aluno: " + this.nome + " (Curso: " + curso.getNome() + ")";
            Logger.info("Histórico consultado para: " + this.nome);
            return historico;
        } catch (Exception e) {
            Logger.error("Erro ao consultar histórico de " + this.nome, e);
            return "Erro ao obter histórico.";
        }
    }

    @Override
    public void apresentar() {
        try {
            String apresentacao = "Sou o aluno " + nome + ", matrícula " + matricula;
            Logger.info(apresentacao);
        } catch (Exception e) {
            Logger.error("Erro ao apresentar aluno " + this.nome, e);
        }
    }
}