
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

    void parse_date(){

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
            In_index++;
        } else {
            System.out.println("FIFO is full, cannot push " + value);
        }


        public void pop(float value){
            if(!isempty()) {
                float value = fifo[Out_index];
                Out_index++;
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
}