package Exercicio3_ListaEncadeada;

public enum HashStatus {
    
    FREE("F"), BUSY("B"), REMOVED("R");
    
    public String statusValue;
    HashStatus(String value){
        statusValue = value;
    }
}
