
import java.util.*;

public class CPU {

    public static int countNormalTerminiation = 0;
    public static int contAbnormalTerminiation = 0;

    public static Queue<Job> executeProcesses() {
    	Queue<Job> FinalJobs = new LinkedList<Job>();
        Hardware.LoadProcessIntoRam();
        System.out.println("Start execute processes");

        @SuppressWarnings("unused")
        int countJobs = 0;

        //System.out.println("Processes are Ready!");

        while (!Hardware.Ram.isEmpty()) {

            Job job = Hardware.Ram.poll();

            while (job.getPcb().getState() != "Terminated") {

                job.getPcb().setState("Ready");
                
                	System.out.println("Job ID: "+job.Id);
                	System.out.println("Job ECU: "+job.ECU);
                	System.out.println("Job State: "+job.p.getState());
                	System.out.println("\n");
                
                countJobs++;
                while (job.getECU() > job.getPcb().getCUT()) {
                	
                    job.getPcb().setState("Running");
                    job.getPcb().setCUT((job.getPcb().getCUT()) + 1);

                }
                //end while 2
                
                System.out.println("Job ID: "+job.Id);
            	System.out.println("Job ECU: "+job.ECU);
            	System.out.println("Job State: "+job.p.getState());
            	System.out.println("\n");

                int inter = (int) (Math.random() * (15 - 1)) + 1;
                job.setInter(inter);
                job.getPcb().setState("Terminated");
                System.out.println("Job ID: "+job.Id);
            	System.out.println("Job ECU: "+job.ECU);
            	System.out.println("Job State: "+job.p.getState());
            	System.out.println("\n");

            	FinalJobs.add(job);
            }//while 3

        }// end while

        System.out.println("Processes are Terminated!");

        return FinalJobs;
    }
}
