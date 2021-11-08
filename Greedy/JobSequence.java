
//https://www.geeksforgeeks.org/job-sequencing-problem/
import java.util.*;

public class JobSequence {

    public static class JobInfo {
        String jobId;
        int deadline;
        int profit;

        public JobInfo(String jobId, int deadline, int profit) {
            this.jobId = jobId;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        JobInfo[] jobs = new JobInfo[n];
        scanner.nextLine();
        int maxDeadline = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String a = scanner.nextLine();
            String[] jobData = a.split(" ");
            jobs[i] = new JobInfo(jobData[0], Integer.parseInt(jobData[1]), Integer.parseInt(jobData[2]));
            if (Integer.parseInt(jobData[1]) > maxDeadline) {
                maxDeadline = Integer.parseInt(jobData[1]);
            }
        }
        String[] result = new String[maxDeadline + 1];
        Arrays.fill(result, "X");
        printJobSequence(jobs, result);
        scanner.close();
    }

    public static void printJobSequence(JobInfo[] jobs, String[] result) {
        // sort on the basis of profit
        Arrays.sort(jobs, new Comparator<JobInfo>() {
            public int compare(JobInfo o1, JobInfo o2) {
                if (o1.profit < o2.profit)
                    return 1;
                if (o1.profit == o2.profit)
                    return 0;
                return -1;
            }

        });
        // take the first job(jobs are sorted by profit) and put it in the last slot
        // according to deadline
        // Ex: if the deadline for a job is 6 then try to put it in the slot 6 first if
        // available otherwise slot 5 and so on
        for (JobInfo jobInfo : jobs) {
            for (int i = jobInfo.deadline; i >= 1; i--) {
                if (result[i].equals("X")) {
                    result[i] = jobInfo.jobId;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(result));
    }

}