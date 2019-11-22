
package Exercicio1_TentativaLinear;

public class Element{

    private Friend friend;
    private int key;
    private HashStatus status;    // F = Free, B = Busy, R = Removed

    public Element(Friend friend, int key, HashStatus status) {
        this.friend = friend;
        this.key = key;
        this.status = status;
    }
    
    public Element(){
        this.status = HashStatus.FREE;
    }

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
    
    public HashStatus getStatus() {
        return status;
    }

    public void setStatus(HashStatus status) {
        this.status = status;
    }
    
}
