package tp;

public class Synch {
    public static void main(String[] args) {
        CallMe target = new CallMe();

        Caller ob1 = new Caller(target, "Java");
        Caller ob2 = new Caller(target, "Is");
        Caller ob3 = new Caller(target, "Great");

        ob1.t.start();
        ob2.t.start();
        ob3.t.start();

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Caller implements Runnable {
        Thread t;
        String msg;
        CallMe target;

        public Caller(CallMe targ, String s) {
            target = targ;
            msg = s;
            t = new Thread(this);
        }

        @Override
        public void run() {
            synchronized (target) {
                target.call(msg);
            }
        }
    }

    static class CallMe {
        synchronized public void call(String msg) {
            System.out.print(msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(" ");
        }
    }
}
