public class DoublyLinkedList {

    private DLL_Node head;
    private DLL_Node tail;

    // inicializar mi lista doble
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // head es null
    public boolean isEmpty() {
        return head == null;
    }

    // Insertar nodo al final
    public void InsertAtEnd(int data) {
        DLL_Node newNode = new DLL_Node(data);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.print("Lista vacia");
            return;
        }

        DLL_Node current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print("<--->");
            }

            current = current.next;
        }

        System.out.println();
    }

    public void reverse() {
        if (isEmpty() || head == tail) {
            return;
        }

        DLL_Node current = head;
        DLL_Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public boolean deleteByValue(int data) {

        if (isEmpty()) {
            return false;
        }

        DLL_Node current = head;

        // buscar nodo
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        // eliminar nodo
        if (current == head) { // eliminar primera posición
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (current == tail) { // eliminar última posición
            tail = tail.prev;
            tail.next = null;
        } else { // eliminar en medio
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        return true;
    }
}