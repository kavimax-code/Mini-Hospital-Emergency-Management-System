# Mini Hospital Emergency Management System

## Project Overview
The Mini Hospital Emergency Management System is a console-based Java application designed to simulate patient management workflows in a hospital environment. It handles patient registrations, emergency queues, treatment tracking, and visit histories through a user-friendly, formatted console interface.

## Data Structures Implemented
* **Binary Search Tree (BST):** Used to store and manage patient records ordered by unique Patient IDs, allowing efficient insertion, search, deletion, and in-order traversal.
* **Queue:** Manages incoming patients arriving at the emergency unit following the First-In, First-Out (FIFO) principle.
* **Stack:** Stores completed treatment records following the Last-In, First-Out (LIFO) principle for quick retrieval of recently finished treatments.
* **Singly Linked List:** Maintains an individual chronological history of previous hospital visits for each patient.

## Instructions on How to Run It
1. Ensure you have the **Java Development Kit (JDK)** installed on your machine.
2. Clone or download this repository to your local computer.
3. Open your terminal or command prompt inside the project folder.
4. Compile all Java source files by running:
  ```bash
   javac Main.java
   java Main

