package domain;

public class Professor extends Pessoa {
    private String registroFuncional;
    private String titulacao;

    public Professor(String nome, String cpf, String email, String registroFuncional, String titulacao) {
        super(nome, cpf, email);
        this.registroFuncional = registroFuncional;
        this.titulacao = titulacao;
    }

    public void lancarNota(Matricula matricula, double nota1, double nota2) {
        matricula.registrarNotas(nota1, nota2);
        System.out.println("Notas lançadas para o aluno " + matricula.getAluno().getNome());
    }

    public void lancarFrequencia(Matricula matricula, int faltas) {
        matricula.registrarFrequencia(faltas);
        System.out.println("Frequência atualizada para o aluno " + matricula.getAluno().getNome());
    }

    @Override
    public void apresentar() {
        System.out.println("Sou o Professor " + nome + ", " + titulacao);
    }
}

