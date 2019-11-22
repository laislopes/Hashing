package Exercicio2_TentativaQuadratica;

public class Main {
    
    public static void main(String[] args) {
      
       int hashTableSize = 26;
       int menuOption = 0;
       HashTable hashTable = new HashTable(hashTableSize);
       UserInterface userInterface = new UserInterface();
       
       while(menuOption != 6){
           
           menuOption = userInterface.MainMenuExercise2(hashTable);
           
       }
    
       
    }
    
}
