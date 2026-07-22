package DSA_Basics.gcr_codebase.Queues;

public class CircularQueueDemo {

    public static void main(String[] args) {

        PacketBuffer queue = new PacketBuffer(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue());

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
