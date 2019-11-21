package LinearAttempt;

import java.lang.reflect.Array;

public class HashTable<T extends IHashable> {

    private Element<T>[] elements; 
    
    public HashTable(Class<T> c, int hashTableSize) {
        @SuppressWarnings("unchecked")
        final Element<T>[] elements = (Element<T>[]) Array.newInstance(c, hashTableSize);
        this.elements = elements;
        initializationHashTable();
    }
    
    public void Insert(T value) {

        int position = HashingFunction(value);
        int treatmentCoefficient = getTreatmentCoefficientToInsert(position);
        
        if (treatmentCoefficient < elements.length) {
            elements[(position + treatmentCoefficient) % elements.length] = new Element<T>(value, value.getKey(), HashStatus.BUSY);
        } else {
            System.out.println("The table is full!");
        }
    }

    public void Remove(T value) {

        int position = search(value);
        
        if (position < elements.length) {
            elements[position].setStatus(HashStatus.REMOVED);
        } else {
            System.out.println("The Element is not present.");
        }
    }
    
    public int search(T value){
        
        int position = HashingFunction(value);
        
        int treatmentCoefficient = getTreatmentCoefficientToSearch(position, value);
        
        if(elements[(position + treatmentCoefficient) % elements.length].getKey() == value.getKey()
           && elements[(position + treatmentCoefficient) % elements.length].getStatus() != HashStatus.REMOVED)
            
           return (position + treatmentCoefficient) % elements.length;
        else
            return elements.length; //Element not found.
    }
    
    public void showHashTable(){
        
        for(int i = 0; i < elements.length; i++){
            
            if(elements[i].getStatus().equals(HashStatus.BUSY)){
                System.out.println("Input " + i + ": "
                                   + elements[i].getKey() + " " 
                                   + elements[i].getStatus());
            }
        }
    }
    
    private int HashingFunction(T value) {

        return value.getKey() % elements.length;
    }
    
    private void initializationHashTable(){
        
        for(int i = 0; i < elements.length; i++){
            elements[i] = new Element<T>();
        }
    }
    
    private int getTreatmentCoefficientToInsert(int position){
        
        int i = 0;
        while(i < elements.length 
              && elements[(position + i) % elements.length].getStatus().equals(HashStatus.BUSY))
              i += 1;
        return i;
    }
    
    private int getTreatmentCoefficientToSearch(int position, T value){
        
        int i = 0;
        while(i < elements.length 
              && elements[(position + i) % elements.length].getStatus() != HashStatus.FREE
              && elements[(position + i) % elements.length].getKey() != value.getKey())
              i += 1;
        return i;
    }
}
