
package LinearAttempt;

public class Hash<T> {
    
    private T key;
    private Status status;    // F = Free, B = Busy, R = Removed

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public void Insert(int position, T data, Hash<T>[] hashTable, int tableSize){
        
        int i = 0;
        while(i < tableSize && hashTable[(position + i)%tableSize].status.equals(Status.BUSY)) i += 1;
        
        if(i > tableSize){
            hashTable[(position + i)%tableSize].key = data;
            hashTable[(position + i)%tableSize].status = Status.BUSY;
        }else{
            System.out.println("The table is full!");           
        }
    }
    
     public void Remove(T data, Hash<T>[] hashTable, int tableSize){
        
        int position = search(data);
        while(i < tableSize && hashTable[(position + i)%tableSize].status.equals(Status.BUSY)) i += 1;
        
        if(i > tableSize){
            hashTable[(position + i)%tableSize].key = data;
            hashTable[(position + i)%tableSize].status = Status.BUSY;
        }else{
            System.out.println("The table is full!");           
        }
    }
    
    
}
