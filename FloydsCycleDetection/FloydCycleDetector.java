package FloydsCycleDetection;

public class FloydCycleDetector {

    private int position;
    private int length;
    private boolean cycle;
    private Node head, tortoise, hare;

    public void detect(Node head) {
        this.head = head;
        this.tortoise = this.hare = head;
        this.cycle = detectCycle();
        if (cycle) {
            System.out.println("Found cycle.");
            this.position = findPosition();
            this.length = cycleLength();
        } else {
            System.out.println("No cycle.");
            this.position = -1;
            this.length = 0;
        }
    }

    public boolean hasCycle() {
        return cycle;
    }

    public int length() {
        return length;
    }

    public int position() {
        return position;
    }

    private boolean detectCycle() {
        if (tortoise == null || tortoise.next == null) {
            return false;
        }
        while (hare != null && hare.next != null) {
            System.out.printf("(%d, %d),", tortoise.data, hare.data);
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                System.out.printf("turtle(%d) == hare(%d)%n",
                        tortoise.data, hare.data);
                return true;
            }
        }
        return false;
    }

    private int findPosition() {
        int i = 1;
        tortoise = head;
        System.out.printf("(%d, %d),", tortoise.data, hare.data);
        while (tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
            ++i;
        }
        return i;
    }

    private int cycleLength() {
        int i = 0;
        do {
            hare = hare.next;
            ++i;
        } while (tortoise != hare);
        return i;
    }

    private static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

}