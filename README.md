# Mini Hospital Emergency Management System

**CIT300 – Data Structures and Algorithms — Individual Mid Assignment**

## Project Overview

The Mini Hospital Emergency Management System is a console-based Java application that
simulates core hospital emergency operations: patient registration, emergency queue
management, treatment completion, and per-patient visit history. The system is built
entirely around four data structures implemented from scratch in Java, without relying
on `java.util.Stack`, `java.util.Queue`, or `java.util.LinkedList`.

## Project Structure

```
Hospital management system/
├── Main.java              # Program entry point
├── UI.java                # Console menu display and input handling
├── Patient.java           # Data model for a patient record
├── BST.java               # Binary Search Tree logic (patient records)
├── BSTNode.java           # BST node (patient data + left/right child references)
├── EmergencyQueue.java    # Queue logic (emergency waiting line)
├── QueueNode.java         # Queue node (linked list node for the queue)
├── TreatmentStack.java    # Stack logic (treatment history)
├── StackNode.java         # Stack node (linked list node for the stack)
├── TreatmentRecord.java   # Data model for a completed treatment
├── PatientVisitList.java  # Singly linked list logic (per-patient visit history)
├── VisitNode.java         # Visit node (linked list node for visit history)
└── README.md
```

## Features (Main Menu)

Running the program presents the following menu:

```
=== Mini Hospital Emergency Management System ===
1. Register Patient (Add to BST)
2. Search Patient Record (BST)
3. Delete Patient Record (BST)
4. Display All Patients Sorted by ID (BST In-order)
5. Enqueue Patient to Emergency Unit (Queue)
6. Treat Next Emergency Patient (Dequeue)
7. Display Emergency Waiting Queue
8. Push Treatment Record (Stack)
9. Pop Recent Treatment Record (Stack)
10. Display Treatment History Stack
11. Add Visit to Patient's Visit History (Linked List)
12. Display Patient's Visit History
0. Exit
```

## Data Structures Implemented

### 1. Binary Search Tree — `BST.java` / `BSTNode.java`
Patient records are stored in a Binary Search Tree keyed by **Patient ID**. Each
`BSTNode` holds one `Patient` object plus references to its left and right child
nodes. This supports:
- **Insert** — registering a new patient (menu option 1)
- **Search** — locating a patient by ID (menu option 2)
- **Delete** — removing a patient record (menu option 3)
- **In-order traversal** — displaying every patient in ascending Patient ID order
  (menu option 4)

Each patient record stores: Patient ID, Name, Age, Contact Number, and Medical Condition.

### 2. Queue — `EmergencyQueue.java` / `QueueNode.java`
The emergency waiting line is implemented as a custom linked-node Queue following the
**FIFO (First-In, First-Out)** principle. Supports:
- **Enqueue** — adding a patient to the back of the queue (menu option 5)
- **Dequeue** — removing the next patient for treatment (menu option 6)
- **Display** — listing all patients currently waiting (menu option 7)
- **Empty handling** — displaying the queue or dequeuing when no patients are
  waiting prints a clear message instead of raising an error

### 3. Stack — `TreatmentStack.java` / `StackNode.java`
Completed treatments are recorded in a custom linked-node Stack following the
**LIFO (Last-In, First-Out)** principle. Supports:
- **Push** — recording a newly completed treatment with a timestamp (menu option 8)
- **Pop** — removing the most recently completed treatment (menu option 9)
- **Display** — listing the treatment history, most recent first (menu option 10)
- **Empty handling** — popping or displaying an empty stack prints a clear message
  instead of raising an error

### 4. Singly Linked List — `PatientVisitList.java` / `VisitNode.java`
Each patient's visit history is stored in its own Singly Linked List. Supports:
- **Add** — appending a new visit to a patient's history (menu option 11)
- **Display** — listing a patient's full visit history in order (menu option 12)

Each visit record stores: Visit ID, Visit Date, Doctor Name, Diagnosis, and Treatment.

## How to Run

**Prerequisite:** JDK 17 or later installed (`java -version` to check).

1. Clone or download this repository.
2. Open a terminal inside the project folder.
3. Compile all source files:
   ```bash
   javac Main.java
   ```
4. Run the program:
   ```bash
   java Main
   ```
5. Use the on-screen menu (type a number and press Enter) to navigate between operations.

## Testing Instructions / Sample Walkthrough

Suggested manual test sequence, using sample Patient IDs:

1. **Register two patients** (option 1): e.g. ID `1001` (kavinda, age 24) and ID `1002`
   (amal, age 25).
2. **Search** for ID `1001` (option 2) — confirms the record is found and displayed.
3. **Display all patients** (option 4) — confirms both patients are listed in
   ascending ID order.
4. **Delete** ID `1002` (option 3), then display again — confirms it was removed.
5. **Enqueue** ID `1001` to the emergency queue (option 5), then **display the queue**
   (option 7) — confirms the patient appears in the waiting line.
6. **Treat/dequeue** the patient (option 6), then display the queue again — confirms
   it correctly reports an empty queue.
7. **Push a treatment record** (option 8) with a treatment description and timestamp,
   then **display the stack** (option 10) — confirms it appears at the top.
8. **Pop** the record (option 9), then display again — confirms it was removed and
   the stack correctly reports empty.
9. **Add a visit** to a patient's history (option 11) with a visit ID, date, doctor,
   diagnosis, and treatment, then **display that patient's visit history** (option 12)
   — confirms the visit appears correctly.

Each of these steps should complete without the program crashing, including when run
against an empty queue or stack.

## Notes on Design

- All four core structures (BST, Queue, Stack, Linked List) are built using custom
  node classes (`BSTNode`, `QueueNode`, `StackNode`, `VisitNode`) and manual pointer
  linking, rather than Java's built-in collection classes.
- A patient must be registered in the BST before being enqueued to the emergency
  queue or having a visit added to their history, since Patient ID is used as the
  common key across the system.

## Author

- **Name:** Kavinda Buddhika
- **Student ID:** 23DA02 -0183
- **Module:** CIT300 – Data Structures and Algorithms

