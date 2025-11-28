package domain;

import audit.Logger;

public class Professor extends Pessoa {
    private String registroFuncional;
    private String titulacao;

    public Professor(String nome, String cpf, String email, String registroFuncional, String titulacao) {
        super(nome, cpf, email);
        try {
            this.registroFuncional = registroFuncional;
            this.titulacao = titulacao;
            Logger.info("Professor criado: " + nome + " (" + titulacao + ")");
        } catch (Exception e) {
            Logger.error("Erro ao criar professor: " + nome, e);
        }
    }

    public void lancarNota(Matricula matricula, double nota1, double nota2) {
        try {
            if (matricula == null) {
                throw new IllegalArgumentException("Matrícula não pode ser nula.");
            }
            matricula.registrarNotas(nota1, nota2);
            Logger.info("Notas lançadas para o aluno " + matricula.getAluno().getNome());
        } catch (Exception e) {
            Logger.error("Erro ao lançar notas.", e);
        }
    }

    public void lancarFrequencia(Matricula matricula, int faltas) {
        try {
            if (matricula == null) {
                throw new IllegalArgumentException("Matrícula não pode ser nula.");
            }
            matricula.registrarFrequencia(faltas);
            Logger.info("Frequência atualizada para o aluno " + matricula.getAluno().getNome());
        } catch (Exception e) {
            Logger.error("Erro ao lançar frequência.", e);
        }
    }

    @Override
    public void apresentar() {
        try {
            String msg = "Sou o Professor " + nome + ", " + titulacao;
            Logger.info(msg);
        } catch (Exception e) {
            Logger.error("Erro ao apresentar professor " + this.nome, e);
        }
    }
}