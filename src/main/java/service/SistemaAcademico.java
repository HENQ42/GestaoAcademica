package service;

import domain.Aluno;
import domain.Curso;
import domain.Professor;
import domain.Turma;
import audit.Logger;
import java.util.ArrayList;
import java.util.List;

public class SistemaAcademico {
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Curso> cursos;
    private List<Turma> turmas;

    public SistemaAcademico() {
        try {
            this.alunos = new ArrayList<>();
            this.professores = new ArrayList<>();
            this.cursos = new ArrayList<>();
            this.turmas = new ArrayList<>();
            Logger.info("Sistema Acadêmico inicializado com sucesso.");
        } catch (Exception e) {
            Logger.error("Erro ao inicializar Sistema Acadêmico.", e);
        }
    }

    public void cadastrarAluno(Aluno a) {
        try {
            if (a == null) {
                throw new IllegalArgumentException("Aluno não pode ser nulo.");
            }
            alunos.add(a);
            Logger.info("Aluno cadastrado no sistema: " + a.getNome());
        } catch (Exception e) {
            Logger.error("Erro ao cadastrar aluno.", e);
        }
    }

    public void cadastrarProfessor(Professor p) {
        try {
            if (p == null) {
                throw new IllegalArgumentException("Professor não pode ser nulo.");
            }
            professores.add(p);
            Logger.info("Professor cadastrado no sistema: " + p.getNome());
        } catch (Exception e) {
            Logger.error("Erro ao cadastrar professor.", e);
        }
    }

    public void cadastrarCurso(Curso c) {
        try {
            if (c == null) {
                throw new IllegalArgumentException("Curso não pode ser nulo.");
            }
            cursos.add(c);
            Logger.info("Curso cadastrado no sistema: " + c.getNome());
        } catch (Exception e) {
            Logger.error("Erro ao cadastrar curso.", e);
        }
    }

    public void cadastrarTurma(Turma t) {
        try {
            if (t == null) {
                throw new IllegalArgumentException("Turma não pode ser nula.");
            }
            turmas.add(t);
            Logger.info("Turma cadastrada no sistema: " + t.getNome());
        } catch (Exception e) {
            Logger.error("Erro ao cadastrar turma.", e);
        }
    }

    public Aluno buscarAluno(String matricula) {
        try {
            for (Aluno a : alunos) {
                if (a.getMatricula().equals(matricula)) {
                    Logger.info("Aluno encontrado: " + a.getNome());
                    return a;
                }
            }
            Logger.info("Aluno com matrícula " + matricula + " não encontrado.");
            return null;
        } catch (Exception e) {
            Logger.error("Erro ao buscar aluno com matrícula: " + matricula, e);
            return null;
        }
    }

    public int totalAlunos() {
        try {
            int total = alunos.size();
            Logger.info("Total de alunos consultado: " + total);
            return total;
        } catch (Exception e) {
            Logger.error("Erro ao contar total de alunos.", e);
            return 0;
        }
    }
}