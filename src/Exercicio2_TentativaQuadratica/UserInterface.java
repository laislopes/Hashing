package Exercicio2_TentativaQuadratica;

import java.util.Scanner;

public class UserInterface {
    
    Scanner input = new Scanner(System.in);
    int menuOption = 0;
    
    public int MainMenuExercise1(HashTable hashTable) {

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
                hashTable.insert(ReadFriend());
                break;
            case 2:
                System.out.println("Digite um mês para consultar os aniversariantes: ");
                hashTable.consultBirthdaysOfTheMonth(input.nextInt());
                break;
            case 3:
                System.out.println("Quantidade de pessoas com idade superior a 18 anos: " + hashTable.countPeopleOver18());
                break;
            case 4:
                System.out.println("Digite o nome de um amigo para removê-lo: ");
                hashTable.removeByName(input.next());
                break;
            case 5:
                System.out.println("Digite um mês para remover os aniversariantes: ");
                hashTable.removeBirthdaysOfTheMonth(input.nextInt());
                break;
             case 6:
                break;
            case 7:
                hashTable.showHashTable();
                break;
             default:
                 System.out.println("Opção inválida");
                 break;
                    
                
                
                
                
        }
        
        return menuOption;
    }
    
    private Friend ReadFriend(){

        System.out.println("Digite o nome do seu amigo: ");
        String name = input.next();
        System.out.println("\nDigite o dia do nascimento do seu amigo no formato dd: ");
        int birthDay = input.nextInt();
        System.out.println("\nDigite o mês do nascimento do seu amigo no formato MM: ");
        int birthMonth = input.nextInt();
        System.out.println("\nDigite o ano do nascimento do seu amigo no formato yyyy: ");
        int birthYear = input.nextInt();
        
        return new Friend(name, birthDay, birthMonth, birthYear);
    }
    
  
    

}
