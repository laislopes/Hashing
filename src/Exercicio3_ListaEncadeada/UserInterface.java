package Exercicio3_ListaEncadeada;

import java.util.Scanner;

public class UserInterface {
    
    Scanner input = new Scanner(System.in);
    int menuOption = 0;
    
    public int MainMenuExercise3(HashTable hashTable) {

        System.out.println("Exercício 3 - Lista 2 ED2\n\n" + 
                           "Menu:\n" +
                           "1 – Cadastrar aluno (código, nome e nota final)\n" +
                           "2 – Consultar aprovados (nota final de, no mínimo, 7)\n" +
                           "3 – Consultar todos os alunos\n" +
                           "4 – Sair\n\n" +
                           "Digite uma opção: ");

        menuOption = input.nextInt();
        
        switch(menuOption){
            
            case 1:
                hashTable.insert(readStudent());
                break;
            case 2:
                hashTable.consultStudentsByFinalGrade(7);
                break;
            case 3:
                hashTable.showHashTable();
                break;
            case 4:
                break;
             default:
                 System.out.println("Opção inválida");
                 break;
                    
                
                
                
                
        }
        
        return menuOption;
    }
    
    private Student readStudent(){
        
        System.out.println("Digite o id do aluno: ");
        int id = input.nextInt();
        System.out.println("\nDigite o nome do aluno: ");
        String name = input.next();
        System.out.println("\nDigite a nota final do aluno: ");
        double finalGrade = input.nextDouble();
    
        return new Student(id, name, finalGrade);
    }
    
            
}
