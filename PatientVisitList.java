public class PatientVisitList {
    
    public static VisitNode addVisit(VisitNode head, int id, String date, String doctor, String diagnosis, String treatment) {
        VisitNode newNode = new VisitNode(id, date, doctor, diagnosis, treatment);
        if (head == null) {
            return newNode;
        }
        VisitNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static VisitNode removeVisit(VisitNode head, int visitId) {
        if (head == null) return null;
        if (head.visitId == visitId) return head.next;

        VisitNode current = head;
        while (current.next != null && current.next.visitId != visitId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Visit ID " + visitId + " removed.");
        } else {
            System.out.println("Visit ID not found.");
        }
        return head;
    }

    public static void displayVisits(VisitNode head) {
        if (head == null) {
            System.out.println("No recorded visits for this patient.");
            return;
        }
        VisitNode current = head;
        System.out.println("--- Patient Visit History ---");
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}