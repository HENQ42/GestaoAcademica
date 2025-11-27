package domain;

public class Aluno extends Pessoa {
    private String matricula;
    private Curso curso;

    public Aluno(String nome, String cpf, String email, String matricula, Curso curso) {
        super(nome, cpf, email);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void solicitarMatricula(Turma turma) {
        boolean sucesso = turma.adicionarAluno(this);
        if (sucesso) {
            System.out.println("Matrícula realizada com sucesso para: " + this.nome);
        } else {
            System.out.println("Não foi possível realizar matrícula.");
        }
    }

    public String consultarHistorico() {
        return "Histórico do aluno: " + this.nome + " (Curso: " + curso.getNome() + ")";
    }

    @Override
    public void apresentar() {
        System.out.println("Sou o aluno " + nome + ", matrícula " + matricula);
    }
}

