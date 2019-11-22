package view;

import control.HashControl;
import java.util.Scanner;
import model.People;

/**
 *
 * @author DLT1CA
 */
public class Exe2 {

    public static void main(String[] args) {
        int tam = 26;
        HashControl hc = new HashControl(tam);
        int op = 0;
        String name;
        
        do {
            showMenu();
            op = readInteger();
            
            switch (op) {

                case 1:
                    People p = loadPeople();
                    hc.add(p);
                    break;
                case 2:
                    hc.show();
                    break;
                case 3:
                    System.out.println("Type the name to search");
                    name = readString();
                    
                    if(hc.search(name) == tam)
                        System.out.println("People not found.");
                    else{
                        System.out.println("Found!");
                        hc.show(hc.search(name));
                    }
                    break;
                case 4:
                    
                    break;
                case 5:
                    if (hc.isEmpty()) {
                        System.out.println("Empty");
                    } else {
                        System.out.print("Type the name to remove: ");
                        name = readString();
                        hc.remove(name);
                    }
                    break;
                case 6:
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
                    
            }

        } while (op != 6);

    }

    public static void showMenu() {
        System.out.println("\nOptions Menu\n");
        System.out.println("1 - Add people");
        System.out.println("2 - Consult all");
        System.out.println("3 - Consult one");
        System.out.println("4 - Consult peoples by first letter");
        System.out.println("5 - Remove a people");
        System.out.println("6 - Out");

        System.out.println("Choice an option: ");
    }

    public static int readInteger() {
        Scanner s = new Scanner(System.in);
        try {
            return s.nextInt();
        } catch (Exception e) {
            System.out.println("Error.");
        }
        return 0;
    }

    public static String readString() {
        Scanner s = new Scanner(System.in);
        try {
            return s.next();
        } catch (Exception e) {
            System.out.println("Error.");
        }
        return "";
    }
    
    public static People loadPeople() {
        String name = "";
        System.out.println("Name: ");
        name = readString();

        return new People(name);
    }
}
