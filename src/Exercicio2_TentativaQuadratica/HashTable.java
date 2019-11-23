package Exercicio2_TentativaQuadratica;

public class HashTable {

    private Element[] elements;

    public HashTable(int hashTableSize) {
        elements = new Element[hashTableSize];
        initializationHashTable();
    }

    public void insert(Person person) {
        
        int key = person.getName().charAt(0);
        int position = HashingFunction(key);
        int k = 1;
        
        while (k <= elements.length
                && elements[position].getStatus().equals(HashStatus.BUSY)) {
            position = (position + k) % elements.length;
            k++;
        }
        if (k <= elements.length) {
            elements[position] = new Element(person, key, HashStatus.BUSY);
            System.out.println("\nPessoa inserida com sucesso!");
        } else {
            System.out.println("A tabela está cheia!");
        }
    }

    public void removeByKey(String name) {

        int position = search(name);

        if (position < elements.length) {
            elements[position].setStatus(HashStatus.REMOVED);
            System.out.println("Pessoa removida com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada na tabela.");
        }
    }

    public int search(String name) {

        int firstLetterName = name.charAt(0);
        int position = HashingFunction(firstLetterName);
        int k = 1;
        
        while (k < elements.length
                && elements[position].getStatus() != HashStatus.FREE
                && elements[position].getKey() != firstLetterName) {
            position = (position + k) % elements.length;
            k++;
        }
        Element element = elements[position];

        if (element.getKey() == firstLetterName
                && element.getStatus() != HashStatus.REMOVED) {
            return position;
        } else {
            return elements.length; //Element not found.
        }
    }

    public void showHashTable() {

        System.out.println("HashTable:\n"
                + "Position:\tKey\tStatus\t  Nome da Pessoa\n");
        for (int i = 0; i < elements.length; i++) {
            
            showElement(i);
        }
    }

    private void showElement(int i) {
        if (elements[i].getStatus().equals(HashStatus.BUSY)) {
            
            System.out.println(i + ":\t\t"
                    + elements[i].getKey() + "\t"
                    + elements[i].getStatus() + "\t  "
                    + elements[i].getPerson().getName() + "\n");
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

    public void consultPersonByName(String name){
        
        showElement(search(name));
    }
    
    public void consultPeopleByFirstLetterName(String name){
        
        System.out.println("\n");
        for (Element element : elements) {
            if (element.getStatus().equals(HashStatus.BUSY)) {
                if (element.getPerson().getName().toUpperCase().charAt(0) == name.toUpperCase().charAt(0)) {
                    System.out.println(element.getPerson().getName() + "\n");
                }
            }
        }
    }
    
}
