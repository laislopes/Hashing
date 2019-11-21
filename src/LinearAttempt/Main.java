package LinearAttempt;

public class Main {
    
    public static void main(String[] args) {
      
       int hashTableSize = 20;
       int menuOption = 0;
       HashTable hashTable = new HashTable(Friend.class, hashTableSize);
           
       while(menuOption != 6){
           
           UserInterface.MainMenuExercise1();
           menuOption = input.nextInt();
           
           
       }
    
       
    }
    
}
