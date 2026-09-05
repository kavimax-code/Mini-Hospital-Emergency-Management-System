import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST patientRecords = new BST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentHistory = new TreatmentStack();

        int choice;
        do {
            System.out.println("\n=== Mini Hospital Emergency Management System ===");
            System.out.println("1. Register Patient (Add to BST)");
            System.out.println("2. Search Patient Record (BST)");
            System.out.println("3. Delete Patient Record (BST)");
            System.out.println("4. Display All Patients Sorted by ID (BST In-order)");
            System.out.println("5. Enqueue Patient to Emergency Unit (Queue)");
            System.out.println("6. Treat Next Emergency Patient (Dequeue)");
            System.out.println("7. Display Emergency Waiting Queue");
            System.out.println("8. Push Treatment Record (Stack)");
            System.out.println("9. Pop Recent Treatment Record (Stack)");
            System.out.println("10. Display Treatment History Stack");
            System.out.println("11. Add Visit to Patient's Visit History (Linked List)");
            System.out.println("12. Display Patient's Visit History");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID (int): ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Medical Condition: ");
                    String condition = scanner.nextLine();

                    Patient p = new Patient(id, name, age, contact, condition);
                    patientRecords.insert(p);
                    System.out.println("Patient registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter Patient ID to Search: ");
                    int searchId = scanner.nextInt();
                    Patient found = patientRecords.search(searchId);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Patient with ID " + searchId + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient ID to Delete: ");
                    int delId = scanner.nextInt();
                    patientRecords.delete(delId);
                    System.out.println("Patient record removed if it existed.");
                    break;

                case 4:
                    System.out.println("--- Patient Records (Ascending Order) ---");
                    patientRecords.inorder();
                    break;

                case 5:
                    System.out.print("Enter Patient ID to send to Emergency Queue: ");
                    int qId = scanner.nextInt();
                    Patient qPatient = patientRecords.search(qId);
                    if (qPatient != null) {
                        emergencyQueue.enqueue(qPatient);
                    } else {
                        System.out.println("Patient not found in records. Register them first.");
                    }
                    break;

                case 6:
                    Patient treated = emergencyQueue.dequeue();
                    if (treated != null) {
                        System.out.println("Now treating patient: " + treated.name);
                    }
                    break;

                case 7:
                    emergencyQueue.displayQueue();
                    break;

                case 8:
                    System.out.print("Enter treatment details: ");
                    String details = scanner.nextLine();
                    System.out.print("Enter timestamp (e.g., 2026-06-07 14:30): ");
                    String time = scanner.nextLine();
                    treatmentHistory.push(details, time);
                    break;

                case 9:
                    TreatmentRecord popped = treatmentHistory.pop();
                    if (popped != null) {
                        System.out.println("Removed recent treatment: " + popped);
                    }
                    break;

                case 10:
                    treatmentHistory.displayStack();
                    break;

                case 11:
                    System.out.print("Enter Patient ID to add visit for: ");
                    int vPid = scanner.nextInt();
                    scanner.nextLine();
                    Patient vPatient = patientRecords.search(vPid);
                    if (vPatient != null) {
                        System.out.print("Enter Visit ID: ");
                        int vId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Visit Date: ");
                        String vDate = scanner.nextLine();
                        System.out.print("Enter Doctor Name: ");
                        String doc = scanner.nextLine();
                        System.out.print("Enter Diagnosis: ");
                        String diag = scanner.nextLine();
                        System.out.print("Enter Treatment given: ");
                        String vt = scanner.nextLine();

                        vPatient.visitHistoryHead = PatientVisitList.addVisit(vPatient.visitHistoryHead, vId, vDate, doc, diag, vt);
                        System.out.println("Visit added to patient history.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 12:
                    System.out.print("Enter Patient ID to view history: ");
                    int viewPid = scanner.nextInt();
                    Patient viewPatient = patientRecords.search(viewPid);
                    if (viewPatient != null) {
                        PatientVisitList.displayVisits(viewPatient.visitHistoryHead);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}