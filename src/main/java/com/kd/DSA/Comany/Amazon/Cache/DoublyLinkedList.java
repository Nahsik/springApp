package com.kd.DSA.Comany.Amazon.Cache;

class DoublyLinkedList<K, V> {
    private Node<K, V> head, tail;

    public DoublyLinkedList() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void addToFront(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void moveToFront(Node<K, V> node) {
        remove(node);
        addToFront(node);
    }

    public Node<K, V> removeTail() {
        if (tail.prev == head) return null;
        Node<K, V> node = tail.prev;
        remove(node);
        return node;
    }

    public void remove(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
