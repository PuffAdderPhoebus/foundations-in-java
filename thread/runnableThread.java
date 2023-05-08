public class runnableThread implements Runnable{
    private int num;

    public runnableThread(int num){
        this.num = num;
    }

    @Override
    public void run(){
        System.out.println("Hello From Thread: " + String.valueOf(num));
        /**
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
        }
        */
        System.out.println("Goodbye From Thread: " + String.valueOf(num));
    }
}