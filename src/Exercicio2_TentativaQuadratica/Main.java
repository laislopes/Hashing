package Exercicio2_TentativaQuadratica;

import Exercicio1_TentativaLinear.*;

public class Main {
    
    public static void main(String[] args) {
      
       int hashTableSize = 20;
       int menuOption = 0;
       HashTable hashTable = new HashTable(hashTableSize);
       UserInterface userInterface = new UserInterface();
       
       while(menuOption != 6){
           
           menuOption = userInterface.MainMenuExercise1(hashTable);
           
           
       }
    
       
    }
    
}
