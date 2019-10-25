package LinearAttempt;


public enum Status {
    
    FREE("F"), BUSY("B"), REMOVED("R");
    
    public String statusValue;
    Status(String value){
        statusValue = value;
    }
}
