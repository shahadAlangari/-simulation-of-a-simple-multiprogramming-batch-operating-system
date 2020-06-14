import java.util.*;
public class Hardware {
	
	final static int HDS = 2097152 ; 
	final static int RAM_s = 196608 ; 
	public static Queue<Job> Ram = new LinkedList<Job>();
	public static Queue<Job> HardDisk = new LinkedList<Job>();
	public static int NumOfP = 0;
	
public static void JobsInHardDisk(Queue<Job> newJobs) {
		while (!newJobs.isEmpty()) {
			Job current = newJobs.poll(); 
			
			HardDisk.add(current);  
			NumOfP++;
		}}

public static void LoadProcessIntoRam() { 	
int JobsSize = 0;
while (!HardDisk.isEmpty()) {
Job job = HardDisk.poll(); 
Ram.add(job);
}

}

}
