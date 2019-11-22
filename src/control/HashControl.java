package control;

import model.People;
import model.Hash;

/**
 *
 * @author DLT1CA
 */
public class HashControl {

    private int capacity;

    private Hash hashTable[];

    /**
     *
     * @param capacity Construtor para setar a capacidade inicial da lista
     */
    public HashControl(int capacity) {
        this.capacity = capacity;
        hashTable = new Hash[capacity];
        initTable();
        initPeople();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public int getCapacity() {
        return capacity;
    }

    public Hash[] getHashTable() {
        return hashTable;
    }
//</editor-fold>

    private void initTable() {
        for (int i = 0; i < capacity; i++) {
            this.hashTable[i] = new Hash();
            this.hashTable[i].setStatus('L');
        }
    }

    private void initPeople() {
        for (int i = 0; i < capacity; i++) {
            this.hashTable[i].setPeople(new People(""));
        }
    }

    /**
     * Método para uma chave da tabela
     *
     * @param n
     * @return Num Mod tamanho da tabela
     */
    public int hashingFunction(int n) {
        return n % capacity;
    }

    /**
     *
     * @param name
     * @return Retorna a posição onde o nome esta registrado, caso encontrado
     */
    public int search(String name) {
        int k = 1;//0
        int firstChar = name.charAt(0);
        int pos = hashingFunction(firstChar);

        while (k <= capacity 
                && hashTable[pos].getStatus() != 'L' 
                && hashTable[pos].getKey() != firstChar) {
            pos = (pos + k)%capacity;
            k++;
        }
        if (hashTable[pos].getKey() == firstChar
                && hashTable[pos].getStatus() != 'R'
                && hashTable[pos].getPeople().getName().equals(name)) {
            return pos;
        } else {
            return capacity; // not found
        }
    }

    /**
     * Método para uma chave da tabela
     *
     * @param name
     */
    public void remove(String name) {
        int pos = search(name);
        if (pos < capacity) {
            hashTable[pos].setStatus('R');
            System.out.println("Removed Successfully");
        } else {
            System.out.println("The element is not present");
        }
    }

    public void add(People p) {
        int n = p.getName().charAt(0);
        int pos = hashingFunction(n);
        int k = 1;
        
        while (k <= capacity 
                && hashTable[pos].getStatus() != 'L' 
                && hashTable[pos].getStatus() != 'R') {
            pos = (pos + k) % capacity;
            k++;
        }

        if (k <= capacity) {
            hashTable[pos].setPeople(p);
            hashTable[pos].setKey(n);//pegando o primeiro caractere
            hashTable[pos].setStatus('O');
            System.out.println("Friend added Successfully");
        } else {
            System.out.println("Table full");
        }
    }

    public void show() {
        System.out.println("Pos\tKey\tPeople\tStatus");
        for (int i = 0; i < capacity; i++) {
            System.out.println(i + "\t" + hashTable[i].getKey()
                    + "\t" + hashTable[i].getPeople().getName()
                    + "\t" + hashTable[i].getStatus());
        }
    }

    public void show(int p) {
        System.out.println("Pos\tKey\tPeople\tStatus");
        System.out.println(p + "\t" + hashTable[p].getKey()
                + "\t" + hashTable[p].getPeople().getName()
                + "\t" + hashTable[p].getStatus());
    }

    public boolean isEmpty() {
        int count = 0;
        for (int i = 0; i < capacity; i++) {
            if (hashTable[i].getStatus() == 'L' || hashTable[i].getStatus() == 'R') {
                count++;
            }
        }
        return count == capacity;
    }

}
