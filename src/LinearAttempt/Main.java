package LinearAttempt;

import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
      
       int hashTableSize = 20;
       HashTable hashTable = new HashTable(Friend.class, hashTableSize);
       Scanner entrada = new Scanner(System.in);
       
       do
       {
           System.out.println("\nMENU DE OPÇÕES\n" 
                            + "1 - Inserir Elemento"
                            + "2 - Mostrar Tabela"
                            + "3 - Excluir Elemento"
                            + "4 - Sair");
       }
       
    }
    
}
