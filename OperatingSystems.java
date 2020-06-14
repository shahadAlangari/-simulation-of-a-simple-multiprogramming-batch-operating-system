
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;

public class OperatingSystems {

    public static Queue<Job> jobs = new LinkedList<Job>();

    public static void writeJobsIntoFile() throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter("Job.TXT");

            for (int i = 0; i < 100; ++i) {
                writer.write("Job ID :\n");
                writer.write(i + "\n");
                writer.write("ECU :\n");
                writer.write(genrateECU() + "\n");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            writer.close();
        }
    }

    public static int genrateECU() {
        return (int) (Math.random() * (512 - 16)) + 16;
    }

    public static Queue<Job> generateJobs() {
        Queue<Job> j = new LinkedList<Job>();
        Job temp = null;
        String id;
        int ecu;
        try {
            Scanner input = new Scanner(new File("Job.txt"));
            System.out.println("processes are new!");
            while (input.hasNextLine()) {
                input.nextLine();
                id = input.nextLine();
                input.nextLine();
                ecu = Integer.parseInt(input.nextLine());
                temp = new Job(id, ecu);
                j.add(temp);
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return j;
    }

    public static void main(String[] args) throws IOException {

        writeJobsIntoFile();
        Queue<Job> jobs = generateJobs();
        for(int i = 0; i<100 ; i++) {
        	Job current = jobs.poll();
        	System.out.println("Job ID: "+current.Id);
        	System.out.println("Job ECU: "+current.ECU);
        	System.out.println("Job State: "+current.p.getState());
        	System.out.println("\n");
        	jobs.add(current);
        }
        Hardware.JobsInHardDisk(jobs);
        while (!Hardware.HardDisk.isEmpty()) {
           jobs =CPU.executeProcesses();

        }// end while
        System.out.println("Total number of jobs processed: " + Hardware.NumOfP);

        double Normally = CPU.countNormalTerminiation;
        double Abnomrally = CPU.contAbnormalTerminiation;

        System.out.println("The number of jobs that have completed their execution normally:  " + Job.inorm);
        System.out.println("The number of jobs that have completed their execution abnormally: " + Job.ianorm);

        try {
            FileWriter writer1 = new FileWriter("Result.TXT");

            writer1.write("The number of jobs that have completed their execution normally:  " + Job.inorm + "\n" + "The number of jobs that have completed their execution abnormally: " + Job.ianorm + "\nTotal number of jobs: " + 100);
            for(int i = 0; i< 100; i++) {
				 Job job1 = jobs.poll();
				 writer1.write("\nID: "+ job1.p.id);
				 writer1.write("\nCUT: "+job1.p.cut);
				 writer1.write("\nState: "+ job1.getInter());
			 }
            writer1.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
