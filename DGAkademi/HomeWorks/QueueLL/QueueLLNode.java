

class QueueLLNode {
    // Java program for linked-list implementation of queue
// A linked list (LL) node to store a queue entry
    int key;
    QueueLLNode next;

    // constructor to create a new linked list node
    public QueueLLNode(int key)
    {
        this.key = key;
        this.next = null;
    }
}

// A class to represent a queue
// The queue, front stores the front node of LL and rear stores the
// last node of LL
class QueueLL {
    QueueLLNode front, rear;

    public QueueLL()
    {
        this.front = this.rear = null;
    }

    // Method to add an key to the queue.
    void enqueue(int key)
    {

        // Create a new LL node
        QueueLLNode temp = new QueueLLNode(key);

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }

    // Method to remove an key from queue.
    void dequeue()
    {
        // If queue is empty, return NULL.
        if (this.front == null)
            return;

        // Store previous front and move front one node ahead
        QueueLLNode temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
    }
}

