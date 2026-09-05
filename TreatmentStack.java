class TreatmentRecord {
    String treatmentDetails;
    String timestamp;

    public TreatmentRecord(String treatmentDetails, String timestamp) {
        this.treatmentDetails = treatmentDetails;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Time: " + timestamp + " | Treatment: " + treatmentDetails;
    }
}

class StackNode {
    TreatmentRecord record;
    StackNode next;

    public StackNode(TreatmentRecord record) {
        this.record = record;
        this.next = null;
    }
}

public class TreatmentStack {
    private StackNode top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(String details, String time) {
        TreatmentRecord record = new TreatmentRecord(details, time);
        StackNode newNode = new StackNode(record);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment record pushed to history stack.");
    }

    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No treatment history to pop.");
            return null;
        }
        StackNode temp = top;
        top = top.next;
        return temp.record;
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("The treatment history stack is empty.");
            return;
        }
        StackNode current = top;
        System.out.println("--- Recent Treatment History Stack (LIFO) ---");
        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }
}