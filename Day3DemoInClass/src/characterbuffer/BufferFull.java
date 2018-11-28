package characterbuffer;
public class BufferFull extends Exception {
    BufferFull() {
        super("Buffer is full");
    }

    BufferFull(String s) {
        super(s);
    }
}
