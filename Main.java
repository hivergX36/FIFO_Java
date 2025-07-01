public class Main {
    public static void main(String[] args) {
        Fifo fifo = new Fifo(5);
        fifo.push(5.0f);
        fifo.push(2.0f);
        fifo.push(3.0f);
        System.out.println(fifo.pop());
        System.out.println(fifo.pop());
        System.out.println(fifo.pop());
    }
}
