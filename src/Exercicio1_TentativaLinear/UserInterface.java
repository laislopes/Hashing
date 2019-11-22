package Exercicio1_TentativaLinear;

import java.util.Scanner;

public class UserInterface {
    
    Scanner input = new Scanner(System.in);
    int menuOption = 0;
    
    public int MainMenuExercise1(HashTable hashTable) {

        System.out.println("Exercício 1 - Lista 2 ED2\n\n" + 
                           "Menu:\n" +
                           "1 – Cadastrar amigo (nome, dia, mês e ano do aniversário)\n" +
                           "2 – Consultar aniversariantes de um mês\n" +
                           "3 – Contar as pessoas com idade superior a 18 anos\n" +
                           "4 – Excluir uma pessoa pelo nome\n" +
                           "5 – Excluir as pessoas de um mês\n" +
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
