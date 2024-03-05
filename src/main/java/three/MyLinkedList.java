package three;

import common.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyLinkedList<T> implements LinkedListIterableInterface<T> {
    private Node<T> head = null;
    private Node<T> tail = null;

    private int size = 0;

    @Override
    public void add(T data) {
        if (head == null) {
            addIfEmpty(data);
            size++;
            return;
        }
        addIfNotEmpty(data);
        size++;
    }

    @Override
    public T get(int targetIndex) {
        if (checkValidBound(targetIndex)) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> currentNode = this.head;
        int currentIndex = 0;
        while (currentIndex < targetIndex) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return currentNode.getData();
    }

    @Override
    public void delete(int targetIndex) {
        if (checkValidBound(targetIndex)) {
            throw new IndexOutOfBoundsException();
        }
        if (targetIndex == 0) {
            deleteIfTargetIndexIsZero();
            return;
        }
        deleteIfTargetIndexIsNotZero(targetIndex);
    }

    @Override
    public String toString() {
        List<String> result = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            result.add(current.getData().toString());
            current = current.getNext();
        }
        return String.join(" -> ", result);
    }

    @Override
    public int getSize() {
        return size;
    }

    private boolean checkValidBound(int targetIndex) {
        return targetIndex < 0 || targetIndex >= size;
    }

    private void addIfNotEmpty(T data) {
        tail.setNext(new Node<>(data));
        tail = tail.getNext();
    }

    private void addIfEmpty(T data) {
        head = new Node<>(data);
        tail = head;
    }

    private void deleteIfTargetIndexIsNotZero(int targetIndex) {
        Node<T> current = head;
        int currentIndex = 0;
        while (currentIndex < targetIndex - 1) {
            current = current.getNext();
            currentIndex++;
        }
        if (current.getNext().getNext() == null) {
            tail = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        size--;
    }

    private void deleteIfTargetIndexIsZero() {
        head = head.getNext();
        size--;
    }

    // two의 MyLinkedList에 추가로 iterator 메소드 구현
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head; // 현재 노드를 가리킬 포인터

            @Override
            public boolean hasNext() {
                return current != null;
            } // 다음 노드가 있는지 검사

            @Override
            public T next() {
                T data = current.getData(); // 현재 노드의 데이터 반환
                current = current.getNext(); // 다음 노드로 이동
                return data;
            }
        };
    }
}
