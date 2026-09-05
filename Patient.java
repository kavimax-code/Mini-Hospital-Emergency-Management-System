public class Patient {
    int patientId;
    String name;
    int age;
    String contactNumber;
    String medicalCondition;
    VisitNode visitHistoryHead; // Head of Singly Linked List for visit history

    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistoryHead = null;
    }

    @Override
    public String toString() {
        return "ID: " + patientId + " | Name: " + name + " | Age: " + age + 
               " | Contact: " + contactNumber + " | Condition: " + medicalCondition;
    }
}