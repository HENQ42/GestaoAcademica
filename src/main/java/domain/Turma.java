package domain;

import java.util.ArrayList;
import java.util.List;
import audit.Logger;

public class Turma {
    private String codigoTurma;
    private String semestre;
    private int ano;
    private boolean ativa;
    private Disciplina disciplina;
    private Professor professor;
    private List<Matricula> matriculas;

    public Turma(String codigoTurma, String semestre, int ano, Disciplina disciplina, Professor professor) {
        try {
            this.codigoTurma = codigoTurma;
            this.semestre = semestre;
            this.ano = ano;
            this.disciplina = disciplina;
            this.professor = professor;
            this.ativa = true;
            this.matriculas = new ArrayList<>();
            Logger.info("Turma criada: " + codigoTurma + " - " + disciplina.getNome());
        } catch (Exception e) {
            Logger.error("Erro ao criar turma: " + codigoTurma, e);
        }
    }

    public boolean adicionarAluno(Aluno aluno) {
        try {
            if (!ativa) {
                Logger.info("Tentativa de matrícula em turma inativa: " + codigoTurma);
                return false;
            }
            
            for (Matricula m : matriculas) {
                if (m.getAluno().getMatricula().equals(aluno.getMatricula())) {
                    Logger.info("Aluno já matriculado nesta turma: " + aluno.getNome());
                    return false; 
                }
            }

            Matricula novaMatricula = new Matricula(aluno, this);
            matriculas.add(novaMatricula);
            Logger.info("Aluno matriculado com sucesso na turma " + codigoTurma + ": " + aluno.getNome());
            return true;
        } catch (Exception e) {
            Logger.error("Erro ao adicionar aluno na turma " + codigoTurma, e);
            return false;
        }
    }

    public Matricula buscarMatricula(String matriculaAluno) {
        try {
            for (Matricula m : matriculas) {
                if (m.getAluno().getMatricula().equals(matriculaAluno)) {
                    Logger.info("Matrícula encontrada para o aluno: " + m.getAluno().getNome());
                    return m;
                }
            }
            Logger.info("Matrícula não encontrada na turma " + codigoTurma + " para o código: " + matriculaAluno);
            return null;
        } catch (Exception e) {
            Logger.error("Erro ao buscar matrícula na turma " + codigoTurma, e);
            return null;
        }
    }

    public String gerarPauta() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("=== PAUTA: ").append(disciplina.getNome()).append(" ===\n");
            sb.append("Professor: ").append(professor.getNome()).append("\n");
            sb.append("--------------------------------------------------\n");
            for (Matricula m : matriculas) {
                sb.append(m.getResumo()).append("\n");
            }
            sb.append("--------------------------------------------------\n");
            Logger.info("Pauta gerada para a turma " + codigoTurma);
            return sb.toString();
        } catch (Exception e) {
            Logger.error("Erro ao gerar pauta da turma " + codigoTurma, e);
            return "Erro ao gerar pauta.";
        }
    }

    public void fecharTurma() {
        try {
            this.ativa = false;
            for (Matricula m : matriculas) {
                m.verificarAprovacao();
            }
            Logger.info("Turma fechada: " + codigoTurma);
        } catch (Exception e) {
            Logger.error("Erro ao fechar turma " + codigoTurma, e);
        }
    }
    
    public String getNome() {
        try {
            return this.disciplina.getNome() + " (" + this.semestre + "/" + this.ano + ")";
        } catch (Exception e) {
            Logger.error("Erro ao obter nome da turma.", e);
            return "Nome Indisponível";
        }
    }
}