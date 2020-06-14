
public class Job {

    String Id;//from file
    int ECU;//from file
    PCB p;
    String inter;
    public static int inorm;
    public static int ianorm;

    public Job(String id, int e) {
        this.Id = id;
        this.ECU = e;
        p = new PCB(this.Id);
    }

    public void setECU(int e) {
        this.ECU = e;
    }

    public PCB getPcb() {
        return p;
    }

    public double getECU() {
        return ECU;
    }

    public void setInter(int i) {
        if (i <= 10 && i >= 1) {
            inter = "Normally";
            inorm++;
        } else if (i >= 11 && i <= 15) {
            inter = "Abnormally";
            ianorm++;
        }

    }

    public String getInter() {
        return inter;
    }

}
