package characterbuffer.noexception;

public class CharacterBuffer {
    char item[];
    int size, front, rear;

    public CharacterBuffer() { this(16); }   //default set 16 char array

    public CharacterBuffer(int max) {
        item = new char[max];
        size = front = rear = 0;
    }

    public void put(char c) {
        if (size == item.length) {
            System.err.println("CharacterBuffer is full");
        } else {
            item[front] = c;
            front = (front+1)%item.length;
            size++;
        }
    }
        public char get() {
        char c=' ';
        if (size == 0) {
            System.err.println("CharacterBuffer is empty");
        } else {
            c = item[rear];
            rear = (rear+1)%item.length;
            size--;
        }
        return(c);
    }
}

