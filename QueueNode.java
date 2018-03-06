/**
 * Created by kevin on 2/24/2018.
 */
public class QueueNode {
    private int data;
    public QueueNode prev;
    public QueueNode next;

    public QueueNode(int data) {
        prev = null;
        this.data = data;
        next = null;
    }

    public QueueNode(QueueNode next, int data) {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }

    public int Data() {
        return data;
    }
}
