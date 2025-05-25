/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.academia;
import com.mycompany.academia.database.Conexao;
import com.mycompany.academia.model.Aluno;
import com.mycompany.academia.model.FichaTreino;
import com.mycompany.academia.model.Plano;
import com.mycompany.academia.repository.AlunoRepositoryDB;
import com.mycompany.academia.repository.FichaTreinoRepositoryDB;
import com.mycompany.academia.repository.PlanorepositoryDB;
import java.util.Scanner;
/**
 *
 * @author USUARIO
 */
public class Academia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlunoRepositoryDB alunoRepo = new AlunoRepositoryDB();
        PlanorepositoryDB planoRepo = new PlanorepositoryDB();
        FichaTreinoRepositoryDB fichaRepo = new FichaTreinoRepositoryDB();

        while (true) {
            System.out.println("\n=== Sistema de Gestão de Academia ===");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Adicionar Plano");
            System.out.println("4. Listar Planos");
            System.out.println("5. Adicionar Ficha de Treino");
            System.out.println("6. Listar Fichas de um Aluno");
            System.out.println("7. Alterar dados de de um Aluno");
            System.out.println("8. Deletar dados de de um Aluno");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    alunoRepo.adicionar(new Aluno(nome, email));
                    System.out.println("Aluno adicionado.");
                    break;
                case 2:
                    System.out.println("Alunos:");
                    for (Aluno a : alunoRepo.listar()) {
                        System.out.println(a.getId() + " - " + a.getNome() + " (" + a.getEmail() + ")");
                    }
                    break;
                case 3:
                    System.out.print("Nome do Plano: ");
                    String nomePlano = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricaoPlano = scanner.nextLine();

                    planoRepo.adicionar(new Plano(nomePlano, descricaoPlano));
                    System.out.println("Plano adicionado.");
                    break;
                case 4:
                    System.out.println("Planos:");
                    for (Plano p : planoRepo.listar()) {
                        System.out.println(p.getId() + " - " + p.getNome() + " - " + p.getDescricao());
                    }
                    break;
                case 5:
                    System.out.print("ID do Aluno: ");
                    int alunoId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descrição da ficha: ");
                    String descFicha = scanner.nextLine();
                    fichaRepo.adicionar(new FichaTreino(alunoId, descFicha));
                    System.out.println("Ficha adicionada.");
                    break;
                case 6:
                    System.out.print("ID do Aluno: ");
                    int idConsulta = scanner.nextInt();
                    System.out.println("Fichas do aluno:");
                    for (FichaTreino f : fichaRepo.listarPorAluno(idConsulta)) {
                        System.out.println(f.getId() + " - " + f.getDescricao());
                    }
                    break;
                case 7:
                    System.out.println("Digite o email referente aoaluno que deseja alterar dados: ");
                    String email_antigo = scanner.nextLine();
                    System.out.println("Digite o nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.println("Digite novo email: ");
                    String novoEmail = scanner.nextLine();
                    AlunoRepositoryDB aluno = new AlunoRepositoryDB();
                    alunoRepo.update(novoNome, novoEmail, email_antigo);
                   break;
                case 8:
                    System.out.print("Digite email referente ao aluno que deseja deletar dados: ");
                    String emailDeletar = scanner.nextLine();
                    AlunoRepositoryDB alunoRe = new AlunoRepositoryDB();
                    alunoRe.deletar(emailDeletar);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
}
