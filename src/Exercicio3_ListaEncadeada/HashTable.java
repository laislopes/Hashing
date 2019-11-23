package Exercicio3_ListaEncadeada;

public class HashTable {

    private Element[] elements;

    public HashTable(int hashTableSize) {
        elements = new Element[hashTableSize];
    }

    public void insert(Student student) {
        
        int position = HashingFunction(student.getId());
        Element newElement = new Element(student, student.getId(), elements[position]);
        elements[position] = newElement;
    }

    public void removeByKey(Student student) {
        
        Element auxiliar, previous;
        int position = HashingFunction(student.getId());
        
        if (elements[position] != null) {
            if (elements[position].getKey() == student.getId()) {
                elements[position] = elements[position].getNext();
            } else {
                auxiliar = elements[position].getNext();
                previous = elements[position];
                while (auxiliar != null && auxiliar.getKey() != student.getId()) {
                    previous = auxiliar;
                    auxiliar = auxiliar.getNext();
                }
                if (auxiliar != null) {
                    previous.getNext().setNext(auxiliar.getNext());
                } else {
                    System.out.println("Aluno não encontrado");
                }
            }
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    public void showHashTable() {

        System.out.println("HashTable:\n"
                + "Position:\tId\t  Nome do Aluno\t  Nota Final\n");
        for (int i = 0; i < elements.length; i++) {
            
            showElement(i);
        }
    }

    private void showElement(int i) {
        
        if (elements[i] != null) {
            
            System.out.println(i + ":\t\t"
                    + elements[i].getStudent().getId() + "\t"
                    + elements[i].getStudent().getName() + "\t\t   "
                    + elements[i].getStudent().getFinalGrade() + "\n");
        }
    }

    private int HashingFunction(int key) {

        return key % elements.length;
    }

    public void consultStudentsByFinalGrade(double finalGrade){
        
        System.out.println("HashTable:\n"
                + "Position:\tId\tNome do Aluno\t   Nota Final\n");
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                if (elements[i].getStudent().getFinalGrade() >= finalGrade) {
                    showElement(i);
                }
            }
        }
    }
    
}
