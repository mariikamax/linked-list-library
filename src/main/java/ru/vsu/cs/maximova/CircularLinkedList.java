package ru.vsu.cs.maximova;

public class CircularLinkedList<T> implements LinkedList<T> {
    private Node<T> head;
    private int size;

    public CircularLinkedList() {
        head = null;
        size = 0;
    }

    public void addToEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node<T> tail = head.prev;
            tail.next = newNode;
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
        }
        size++;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node<T> tail = head.prev;
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    public Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public T getElementOfIndex(int index) {
        return getNode(index).data;
    }

    public void addOfIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addToEnd(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = getNode(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public boolean removeElement(T data) {
        if (head == null) {
            return false;
        }

        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(data)) {
                if (size == 1) {
                    head = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    if (current == head) {
                        head = head.next;
                    }
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void output() {
        if (head == null) {
            System.out.println("Циклический список: пуст");
            return;
        }
        System.out.print("Циклический список: ");
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("(head)");
    }
}