package model;

/**
 *
 * @author DLT1CA
 */
public class Hash {

    private int key;
    private char status;
    private People people;

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;

    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

//</editor-fold>
}
