package dk.boids;

//En LinkedList er bygget op af noder. Hver node indeholder data (payload) og en reference til den næste node
//Listen har altid en head (første element) og ofte også en tail (sidste element)
//Fordelen er at man kan indsætte eller fjerne et element hvor som helst uden at flytte alle de andre.
//Ulempen er at fange et element via indeks er langsomt, da alle elementer skal gennemgås fra starten.
//Bliver typisk brugt, hvis man ofte skal indsætte og fjerne elementer, men ikke god, hvis man bare skal læse (GET) meget.

public class MyLinkedList<T> implements MyList<T> {
    private Node head;  
    private Node tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    private class Node {
        public T data;
        public Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public boolean add(T element) {  // Denne tilføjer til slutningen af listen
        Node newNode = new Node(element);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return true;
        }

        this.tail.next = newNode;
        this.tail = newNode;

        return true;
    }

    @Override
    public boolean remove(T other) {
        if (this.head == null) {  // Denne fjerner første forekomst af elementet
            return false;
        }

        if (this.head.data != null && this.head.data.equals(other)) {
            this.head = this.head.next;
            return true;
        }

        Node prev = this.head;
        Node current = this.head.next;
        while (current != null) {
            if (current.data != null && current.data.equals(other)) {
                prev.next = current.next;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public T get(int index) {
        // TODO: Implementer hentning af element på given position
        return null; 
    }

    @Override
    public T set(int index, T element) {
        // TODO: Implementer erstatning af element på given position
        return null;
    }

    @Override
    public boolean contains(Object o) {
        // TODO: Implementer søgning efter element i listen
        return false;
    }

    // Tail er lig med den sidste node i listen, og dennes next peger ofte på null
    @Override
    public int size() {
        int counter = 0;
        Node current = this.head;
        while (current != null) {
            counter += 1;
            current = current.next;
        }

        return counter;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T[] toArray() {
        // TODO: Implementer konvertering til array
        return null;
    }
}
