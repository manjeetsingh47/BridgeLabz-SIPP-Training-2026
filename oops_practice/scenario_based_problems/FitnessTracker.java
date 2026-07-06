package oops_practice.scenario_based_problems;

interface Trackable {

    void logActivity();

    default void resetData() {
        System.out.println("Activity data has been reset.");
    }
}

interface Reportable {

    void generateReport();
}

interface Notifiable {

    void sendAlert();
}

class FitnessDevice implements Trackable, Reportable, Notifiable {

    @Override
    public void logActivity() {
        System.out.println("Activity logged successfully.");
    }

    @Override
    public void generateReport() {
        System.out.println("Fitness report generated.");
    }

    @Override
    public void sendAlert() {
        System.out.println("Alert sent to the user.");
    }
}

public class FitnessTracker {

    public static void main(String[] args) {

        FitnessDevice device = new FitnessDevice();

        device.logActivity();
        device.generateReport();
        device.sendAlert();
        device.resetData();

        Trackable t = device;
        Reportable r = device;
        Notifiable n = device;

        t.logActivity();
        r.generateReport();
        n.sendAlert();
    }
}