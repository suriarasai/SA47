package characterbuffer;

public class CharacterBuffer {

    char item[];
    int size, front, rear;

    public CharacterBuffer(int size) {
        item = new char[size];
        size = front = rear = 0;
    }

    public CharacterBuffer() { this(16); }

    public void put(char c) throws BufferFull {
        if (size == item.length) throw new BufferFull();
        item[front] = c;
        front = (front+1)%item.length;
        size++;
    }
    
    public char get() throws BufferEmpty {
        char c;
        if (size == 0) throw new BufferEmpty();
        c = item[rear];
        rear = (rear+1)%item.length;
        size--;
        return(c);
    }
}
