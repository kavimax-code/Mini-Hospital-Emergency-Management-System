class BSTNode {
    Patient patient;
    BSTNode left, right;

    public BSTNode(Patient patient) {
        this.patient = patient;
        left = right = null;
    }
}

public class BST {
    private BSTNode root;

    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private BSTNode insertRec(BSTNode root, Patient patient) {
        if (root == null) {
            return new BSTNode(patient);
        }
        if (patient.patientId < root.patient.patientId) {
            root.left = insertRec(root.left, patient);
        } else if (patient.patientId > root.patient.patientId) {
            root.right = insertRec(root.right, patient);
        } else {
            // Patient ID already exists in the tree - reject silently overwriting it
            System.out.println("Patient ID " + patient.patientId + " already exists. Registration rejected.");
        }
        return root;
    }

    public Patient search(int patientId) {
        BSTNode result = searchRec(root, patientId);
        return result != null ? result.patient : null;
    }

    private BSTNode searchRec(BSTNode root, int patientId) {
        if (root == null || root.patient.patientId == patientId) {
            return root;
        }
        if (patientId < root.patient.patientId) {
            return searchRec(root.left, patientId);
        }
        return searchRec(root.right, patientId);
    }

    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private BSTNode deleteRec(BSTNode root, int patientId) {
        if (root == null) return null;

        if (patientId < root.patient.patientId) {
            root.left = deleteRec(root.left, patientId);
        } else if (patientId > root.patient.patientId) {
            root.right = deleteRec(root.right, patientId);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.patient = minValue(root.right);
            root.right = deleteRec(root.right, root.patient.patientId);
        }
        return root;
    }

    private Patient minValue(BSTNode root) {
        Patient minv = root.patient;
        while (root.left != null) {
            minv = root.left.patient;
            root = root.left;
        }
        return minv;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.patient);
            inorderRec(root.right);
        }
    }
}