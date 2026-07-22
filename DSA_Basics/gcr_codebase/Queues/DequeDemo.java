package DSA_Basics.gcr_codebase.Queues;

public class DequeDemo {

    public static void main(String[] args) {

        PrintQueue printer = new PrintQueue();

        printer.submitJob(101);
        printer.submitJob(102);
        printer.submitUrgentJob(999);

        while (!printer.isEmpty()) {
            System.out.println(printer.printNextJob());
        }
    }
}
