package Exercicio3_ListaEncadeada;

public class Main {
    
    public static void main(String[] args) {
      
       int hashTableSize = 15;
       int menuOption = 0;
       HashTable hashTable = new HashTable(hashTableSize);
       UserInterface userInterface = new UserInterface();
       
       while(menuOption != 4){
           
           menuOption = userInterface.MainMenuExercise3(hashTable);
           
       }
    
       
    }
    
}
