package characterbuffer;

public class BufferEmpty extends Exception {
    BufferEmpty() {
        super("Buffer is empty");
    }

    BufferEmpty(String s) {
        super(s);
    }
}