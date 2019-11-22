package Exercicio2_TentativaQuadratica;

public class Element{

    private Person person;
    private int key;
    private HashStatus status;    // F = Free, B = Busy, R = Removed

    public Element(Person person, int key, HashStatus status) {
        this.person = person;
        this.key = key;
        this.status = status;
    }
    
    public Element(){
        this.status = HashStatus.FREE;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
