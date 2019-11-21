
package LinearAttempt;

public class Element<T>{

    private T value;
    private int key;
    private HashStatus status;    // F = Free, B = Busy, R = Removed

    public Element(T value, int key, HashStatus status) {
        this.value = value;
        this.key = key;
        this.status = status;
    }
    
    public Element(){
        this.status = HashStatus.FREE;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
    
    public HashStatus getStatus() {
        return status;
    }

    public void setStatus(HashStatus status) {
        this.status = status;
    }
    
}
