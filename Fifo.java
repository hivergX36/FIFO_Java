import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Fifo{
    private float[] fifo;
    private int size;
    private int In_index ;
    private int Out_index;


    public Fifo(int sizechosen) {
        this.size = sizechosen;
        In_index = 0;
        Out_index = 0;
        this.fifo = new float[size];
    }


    void parse_checkNumber(){

    }   

    void parse_data_Fifo(String filename){
        int rows = 0;
        int cols = 0;
        File input = new File(filename);
            try (Scanner scanner = new Scanner(input)) {
                if (scanner.hasNextLine()) {
                    String[] values = scanner.nextLine().split(" ");
                    rows = Integer.parseInt(values[0]);
                    cols = Integer.parseInt(values[1]);
                    this.size = rows * cols;
                    this.fifo = new float[size];
                    for (int i = 0; i < rows; i++) {
                         if (scanner.hasNextLine()) {
                            values = scanner.nextLine().split(" ");
                            for (int j = 0; j < cols; j++) {
                                fifo[i + j] = Float.parseFloat(values[j]);
                            }
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

    }

    public boolean isempty(){
        return Out_index == In_index;
    }

    public boolean isfull(){
        return In_index == size;
    }

    public void push(float value){
        if(!isfull()) {
            fifo[In_index] = value;
            In_index = (In_index + 1) % size;
        } else {
            System.out.println("FIFO is full, cannot push " + value);
        }
    }


          public float pop(){
            if(!isempty()) {
                float value = fifo[Out_index];
                Out_index = (Out_index + 1) % size;
                if (Out_index == In_index) {
                    Out_index = 0;
                    In_index = 0;
                }
                return value;
            } else {
                System.out.println("FIFO is empty, cannot pop");
                return -1; // or throw an exception
            }


    }
}