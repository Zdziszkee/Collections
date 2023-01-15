package me.zdziszkee.stack;

public class Map<K, V> {

    private final Node<K, V>[] entries = (Node<K, V>[]) new Node[1000];

    public V put(K key, V value) {
        final int index = key.hashCode() & (entries.length - 1);
        final Node<K, V> currentValue = entries[index];
        final Node<K, V> next = new Node<>(key, value, null);
        if (currentValue == null) {
            entries[index] = next;
        } else {
            Node<K, V> lastNode = currentValue;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = next;
        }
        return value;
    }

    public V get(K key) {
        final int index = key.hashCode() & (entries.length - 1);
        Node<K, V> node = entries[index];
        if (node == null) {
            return null;
        }
        while (node.next != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return node.value;
    }

    public V remove(K key) {
        return put(key, null);
    }

    private static class Node<K, V> {

        final K key;

        V value;

        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

    }

}
