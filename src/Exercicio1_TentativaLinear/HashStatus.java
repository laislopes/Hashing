package Exercicio1_TentativaLinear;

public enum HashStatus {
    
    FREE("F"), BUSY("B"), REMOVED("R");
    
    public String statusValue;
    HashStatus(String value){
        statusValue = value;
    }
}
