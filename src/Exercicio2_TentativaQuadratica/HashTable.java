package Exercicio2_TentativaQuadratica;

import Exercicio1_TentativaLinear.*;
import java.util.Calendar;

public class HashTable {

    private Element[] elements;

    public HashTable(int hashTableSize) {
        elements = new Element[hashTableSize];
        initializationHashTable();
    }

    public void insert(Friend friend) {

        int position = HashingFunction(friend.getBirthMonth());
        int treatmentCoefficient = getTreatmentCoefficientToInsert(position);

        if (treatmentCoefficient < elements.length) {
            elements[(position + treatmentCoefficient) % elements.length] = new Element(friend, friend.getBirthMonth(), HashStatus.BUSY);
        } else {
            System.out.println("A tabela está cheia!");
        }
    }

    public void removeByKey(int key) {

        int position = search(key);

        if (position < elements.length) {
            elements[position].setStatus(HashStatus.REMOVED);
        } else {
            System.out.println("Amigo não encontrado na tabela.");
        }
    }

    public void removeBirthdaysOfTheMonth(int month) {

        int[] keysBirthdaysOfTheMonth = consultBirthdaysOfTheMonth(month);
        
        for (int i = 0; i < keysBirthdaysOfTheMonth.length; i++) {
            if (keysBirthdaysOfTheMonth[i] != -1) {
                elements[keysBirthdaysOfTheMonth[i]].setStatus(HashStatus.REMOVED);
            }
        }
    }

    public void removeByName(String name) {
        int key = 0;

        for (Element element : elements) {
            if (element.getStatus().equals(HashStatus.BUSY)) {
                if (element.getFriend().getName().equals(name)) {
                    key = element.getKey();
                }
            }
        }

        removeByKey(key);
    }

    public int search(int key) {

        int position = HashingFunction(key);

        int treatmentCoefficient = getTreatmentCoefficientToSearch(position, key);

        Element element = elements[(position + treatmentCoefficient) % elements.length];

        if (element.getKey() == key
                && element.getStatus() != HashStatus.REMOVED) {
            return (position + treatmentCoefficient) % elements.length;
        } else {
            return elements.length; //Element not found.
        }
    }

    public void showHashTable() {

        System.out.println("HashTable:\n"
                + "Position:\tKey\tStatus\n");
        for (int i = 0; i < elements.length; i++) {

            if (elements[i].getStatus().equals(HashStatus.BUSY)) {

                System.out.println(i + ":\t"
                        + elements[i].getKey() + "\t"
                        + elements[i].getStatus() + "\n");
            }
        }
    }

    private int HashingFunction(int key) {

        return key % elements.length;
    }

    private void initializationHashTable() {

        for (int i = 0; i < elements.length; i++) {
            elements[i] = new Element();
        }
    }

    private int getTreatmentCoefficientToInsert(int position) {

        int i = 0;
        while (i < elements.length
                && elements[(position + i) % elements.length].getStatus().equals(HashStatus.BUSY)) {
            i += 1;
        }
        return i;
    }

    private int getTreatmentCoefficientToSearch(int position, int key) {

        int i = 0;
        while (i < elements.length
                && elements[(position + i) % elements.length].getStatus() != HashStatus.FREE
                && elements[(position + i) % elements.length].getKey() != key) {
            i += 1;
        }
        return i;
    }

    public int[] consultBirthdaysOfTheMonth(int month) {

        int[] keysBirthdaysOfTheMonth = initializeKeysBirthdaysOfTheMonth();

        int BirthdaysOfTheMonth = 0;
        System.out.println("Aniversariantes do Mês " + month + ": Nome\tData de Nascimento\n");
        for (int i = 0; i < elements.length; i++) {

            if (elements[i].getStatus().equals(HashStatus.BUSY)) {
                if (elements[i].getFriend().getBirthMonth() == month) {
                    System.out.println(elements[i].getFriend().getName() + "\t"
                            + elements[i].getFriend().getFullBirthday() + "\n");
                    BirthdaysOfTheMonth++;
                    keysBirthdaysOfTheMonth[i] = i;
                }
            }
        }

        if (BirthdaysOfTheMonth == 0) {
            System.out.println("\nNão há nenhum aniversariante no mês consultado.");
        }

        return keysBirthdaysOfTheMonth;
    }

    private int[] initializeKeysBirthdaysOfTheMonth() {
        int[] keysBirthdaysOfTheMonth = new int[20];
        for (int i = 0; i < keysBirthdaysOfTheMonth.length; i++) {
            keysBirthdaysOfTheMonth[i] = -1;
        }
        return keysBirthdaysOfTheMonth;
    }

    public int countPeopleOver18() {

        int year = Calendar.getInstance().get(Calendar.YEAR);
        int PeopleOver18 = 0;
        for (Element element : elements) {
            if (element.getStatus().equals(HashStatus.BUSY) && (year - element.getFriend().getBirthYear() > 18)) {
                PeopleOver18++;
            }
        }
        return PeopleOver18;
    }

}
