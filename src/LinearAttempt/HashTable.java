package LinearAttempt;

public class HashTable {

    private Object[] keys;
    private Object[] values;
    private Status[] status;
    private int hashTableSize;

    public HashTable(int hashTableSize) {
        this.hashTableSize = hashTableSize;
        keys = new Object[hashTableSize];
        values = new Object[hashTableSize];
        status = new Status[hashTableSize];
        initializationHashTable();
    }

    public void Insert(Object key, Object value) {

        int i = 0;
        int position = HashingFunction(key);
        while (i < hashTableSize && status[(position + i) % hashTableSize].equals(Status.BUSY)) {
            i += 1;
        }

        if (i > hashTableSize) {
            keys[(position + i) % hashTableSize] = key;
            values[(position + i) % hashTableSize] = value;
            status[(position + i) % hashTableSize] = Status.BUSY;
        } else {
            System.out.println("The table is full!");
        }
    }

    public void Remove(Object key) {

        int i = 0;
        int position = search(key);
        while (i < hashTableSize && status[(position + i) % hashTableSize].equals(Status.BUSY)) {
            i += 1;
        }

        if (i > hashTableSize) {
            keys[(position + i) % hashTableSize] = key;
            status[(position + i) % hashTableSize] = Status.BUSY;
        } else {
            System.out.println("The table is full!");
        }
    }
    
    public int search(Object key){
        
        int i = 0;
        int position = HashingFunction(key);
        
        while(i < hashTableSize
              && status[(position + i) % hashTableSize] != Status.FREE
              && keys[(position + i) % hashTableSize] != key)
            i += 1;
        
        if(keys[(position + i) % hashTableSize] == key
           && status[(position + i) % hashTableSize] != Status.REMOVED)
            return (position + i) % hashTableSize;
        else
            return hashTableSize; //Element not found.
    }
    
    public void showHashTable(){
        
        for(int i = 0; i < hashTableSize; i++){
            
            if(status[i] == Status.BUSY){
                System.out.println("Input " + i + ": "
                                   + keys[i] + " " 
                                   + status[i]);
            }
        }
    }
    
    private int HashingFunction(Object key) {

        return (int) key % hashTableSize;
    }
    
    private void initializationHashTable(){
        
        for(int i = 0; i < hashTableSize; i++){
            status[i] = Status.FREE;
        }
    }
}
