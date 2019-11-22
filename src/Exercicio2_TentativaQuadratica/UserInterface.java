package Exercicio2_TentativaQuadratica;

import java.util.Scanner;

public class UserInterface {
    
    Scanner input = new Scanner(System.in);
    int menuOption = 0;
    
    public int MainMenuExercise2(HashTable hashTable) {

        System.out.println("Exercício 2 - Lista 2 ED2\n\n" + 
                           "Menu:\n" +
                           "1 – Inserir (apenas o nome)\n" +
                           "2 – Consultar todas as pessoas\n" +
                           "3 – Consultar uma pessoa\n" +
                           "4 – Consultar as pessoas com uma inicial digitada\n" +
                           "5 – Excluir uma pessoa\n" +
                           "6 – Sair\n\n" +
                           "Digite uma opção: ");

        menuOption = input.nextInt();
        
        switch(menuOption){
            
            case 1:
                System.out.println("Digite o nome da pessoa: ");
                hashTable.insert(new Person(input.next()));
                break;
            case 2:
                hashTable.showHashTable();
                break;
            case 3:
                System.out.println("Digite o nome da pessoa para consultá-la: ");
                hashTable.consultPersonByName(input.next());
                break;
            case 4:
                System.out.println("Digite uma letra para consultar pessoas que possuem essa letra como inicial: ");
                hashTable.consultPeopleByFirstLetterName(input.next());
                break;
            case 5:
                System.out.println("Digite o nome de uma pessoa para removê-la: ");
                hashTable.removeByKey(input.next());
                break;
             case 6:
                break;
             default:
                 System.out.println("Opção inválida");
                 break;
                    
                
                
                
                
        }
        
        return menuOption;
    }

}
