
package Exercicio3_ListaEncadeada;

public class Student {
    
    private int id;
    private String name;
    private double finalGrade;

    public Student(int id, String name, double finalGrade) {
        this.id = id;
        this.name = name;
        this.finalGrade = finalGrade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }
    
}
