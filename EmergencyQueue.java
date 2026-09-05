class QueueNode {
    Patient patient;
    QueueNode next;

    public QueueNode(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
}

public class EmergencyQueue {
    private QueueNode front, rear;

    public EmergencyQueue() {
        this.front = this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        if (rear == null) {
            front = rear = newNode;
            System.out.println("Patient added to emergency queue.");
            return;
        }
        rear.next = newNode;
        rear = newNode;
        System.out.println("Patient added to emergency queue.");
    }

    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No patients waiting.");
            return null;
        }
        QueueNode temp = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return temp.patient;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("The emergency queue is currently empty.");
            return;
        }
        QueueNode current = front;
        System.out.println("--- Current Emergency Waiting Queue ---");
        int pos = 1;
        while (current != null) {
            System.out.println(pos++ + ". " + current.patient);
            current = current.next;
        }
    }
}