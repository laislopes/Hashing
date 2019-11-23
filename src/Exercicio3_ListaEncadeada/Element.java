package Exercicio3_ListaEncadeada;

public class Element{

    private Student student;
    private int key;
    private Element next;    // F = Free, B = Busy, R = Removed

    public Element(Student student, int key, Element next) {
        this.student = student;
        this.key = key;
    }
    
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
    
}
