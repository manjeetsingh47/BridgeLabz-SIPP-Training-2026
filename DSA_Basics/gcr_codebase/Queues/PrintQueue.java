package DSA_Basics.gcr_codebase.Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrintQueue {

    private Deque<Integer> queue = new ArrayDeque<>();

    public void submitJob(int jobId) {
        queue.addLast(jobId);
    }

    public void submitUrgentJob(int jobId) {
        queue.addFirst(jobId);
    }

    public int printNextJob() {
        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}