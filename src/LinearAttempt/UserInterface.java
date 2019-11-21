package LinearAttempt;

import java.util.Scanner;

public class UserInterface {
    
    Scanner input = new Scanner(System.in);
    int menuOption = 0;
    
    public void MainMenuExercise1(HashTable hashTable) {

        System.out.println("Exercício 1 - Lista 2 ED2\n" + 
                           "Menu:\n" +
                           "1 – Cadastrar amigo (nome, dia, mês e ano do aniversário)\n" +
                           "2 – Consultar aniversariantes de um mês\n" +
                           "3 – Contar as pessoas com idade superior a 18 anos\n" +
                           "4 – Excluir uma pessoa pelo nome\n" +
                           " 5 – Excluir as pessoas de um mês\n" +
                           " 6 – Sair\n\n" +
                           "Digite uma opção: ");

        menuOption = input.nextInt();
        
        switch(menuOption){
            
            case 1:
                hashTable.Insert(ReadFriend());
                break;
            case 2:
                System.out.println("Digite um mês para consultar os aniversariantes: \n");
                int birthMonth = input.nextInt();
                hashTable.search(birthMonth);
                
                
                
        }
    }
    
    private Friend ReadFriend(){

        System.out.println("Digite o nome do seu amigo: \n");
        String name = input.next();
        System.out.println("Digite o dia do nascimento do seu amigo: \n");
        int birthDay = input.nextInt();
        System.out.println("Digite o mês do nascimento do seu amigo: \n");
        int birthMonth = input.nextInt();
        System.out.println("Digite o ano do nascimento do seu amigo: \n");
        int birthYear = input.nextInt();
        
        return new Friend(name, birthDay, birthMonth, birthYear);
    }
    
    

}
