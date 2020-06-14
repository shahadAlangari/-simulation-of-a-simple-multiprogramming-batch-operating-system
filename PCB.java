
public class PCB {

    String id;
    String state;
    int cut;

    public PCB(String id) {
        this.id = id;
        this.cut = 0;
        state = "new";

    }

    public void setState(String s) {
        state = s;
    }

    public String getState() {
        return state;
    }

    public int getCUT() {
        return cut;
    }

    public void setCUT(int c) {
        cut = c;
    }
}
