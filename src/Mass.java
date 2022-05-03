import java.util.Arrays;

public class Mass implements Runnable {

    private int[] mass;
    private int size;

    public Mass(int[] mass) {
        this.mass = mass;
    }

    public Mass(int size) {
        this.size = size;
    }

    public int[] getMass() {
        return mass;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void run() {

        String currentThreadName = Thread.currentThread().getName();
        if ("GENERATE".equals(currentThreadName)) {
            createMass();
        } else if ("SUMM".equals(currentThreadName)) {
            sumMass(mass);

        } else if ("AVG".equals(Thread.currentThread().getName())) {
            AVG(mass);


        }
    }

    public void createMass() {
        mass = new int[size];
        for (int i = 0; i < size; i++) {
            mass[i] = (int) (Math.random() * 100);
        }


    }

    public int sumMass(int[] mass) {

        int sum = 0;

        for (int x : mass) {
            sum += x;
        }
        return sum;
    }

    public double AVG(int[] mass) {

        int sum = 0;

        for (int x : mass) {
            sum += x;
        }

        return (double) sum / mass.length;

    }


}
