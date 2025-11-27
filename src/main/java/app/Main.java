package app;

import domain.*;
import service.SistemaAcademico;

public class Main {
    public static void main(String[] args) {
        SistemaAcademico sistema = new SistemaAcademico();

        Curso engSoftware = new Curso("Engenharia de Software", 101, 8);
        sistema.cadastrarCurso(engSoftware);

        Disciplina poo = new Disciplina("POO", "SW10", 64, "Conceitos OO");
        engSoftware.adicionarDisciplina(poo);

        Professor profAda = new Professor("Ada Lovelace", "111.222.333-44", "ada@sol.br", "P001", "Doutora");
        sistema.cadastrarProfessor(profAda);

        Aluno alunoAlan = new Aluno("Alan Turing", "999.888.777-66", "alan@sol.br", "202401", engSoftware);
        Aluno alunoGrace = new Aluno("Grace Hopper", "888.777.666-55", "grace@sol.br", "202402", engSoftware);
        
        sistema.cadastrarAluno(alunoAlan);
        sistema.cadastrarAluno(alunoGrace);

        Turma turmaPoo = new Turma("T01", "2024/1", 2024, poo, profAda);
        sistema.cadastrarTurma(turmaPoo);

        System.out.println("--- INICIANDO MATRÍCULAS ---");
        alunoAlan.solicitarMatricula(turmaPoo);
        alunoGrace.solicitarMatricula(turmaPoo);

        System.out.println("\n--- LANÇAMENTO DE NOTAS ---");
        Matricula mAlan = turmaPoo.buscarMatricula("202401");
        if (mAlan != null) {
            profAda.lancarNota(mAlan, 9.5, 8.0);
            profAda.lancarFrequencia(mAlan, 0); 
        }

        Matricula mGrace = turmaPoo.buscarMatricula("202402");
        if (mGrace != null) {
            profAda.lancarNota(mGrace, 10.0, 10.0);
            profAda.lancarFrequencia(mGrace, 2); 
        }

        System.out.println("\n--- ENCERRAMENTO DO SEMESTRE ---");
        turmaPoo.fecharTurma();
        System.out.println(turmaPoo.gerarPauta());
    }
}
