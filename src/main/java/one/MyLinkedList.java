package one;

import common.LinkedListInterface;
import common.Node;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList<T> implements LinkedListInterface<T> {
    private Node<T> head = null; // 리스트의 첫 번째 노드
    private int size = 0; // 리스트의 크기

    @Override
    public void add(T data) {
        if (head == null) { // 리스트가 비어있으면
            addIfEmpty(data); // 첫 번째 노드로 추가
            return;
        }
        addIfNotEmpty(data); // 비어있지 않으면 마지막에 추가
    }

    @Override
    public T get(int targetIndex) {
        if (checkValidBound(targetIndex)) { // 인덱스 유효성 검사
            throw new IndexOutOfBoundsException();
        }
        // 타겟 인덱스까지 이동하여 데이터 반환
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
        if (checkValidBound(targetIndex)) { // 인덱스 유효성 검사
            throw new IndexOutOfBoundsException();
        }
        if (targetIndex == 0) { // 첫 번째 노드 삭제
            deleteIfTargetIndexIsZero();
            return;
        }
        deleteIfTargetIndexIsNotZero(targetIndex); // 첫 번째가 아닌 노드 삭제
    }

    @Override
    public String toString() {
        // 리스트의 모든 데이터를 문자열로 변환하여 반환
        List<String> result = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            result.add(current.getData().toString());
            current = current.getNext();
        }
        return String.join(" -> ", result);
    }

    @Override
    public int getSize() { return size; } // 리스트의 크기 반환

    private boolean checkValidBound(int targetIndex) { // 인덱스가 유효한 범위 내에 있는지 검사
        return targetIndex < 0 || targetIndex >= size;
    }

    // 비어있는 리스트에 데이터 추가
    private void addIfEmpty(T data) {
        head = new Node<>(data);
        size++;
    }

    // 비어있지 않은 리스트에 데이터 추가
    private void addIfNotEmpty(T data) {
        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Node<>(data));
        size++;
    }

    // 첫 번째 노드를 삭제
    private void deleteIfTargetIndexIsZero() {
        head = head.getNext();
        size--;
    }

    // 첫 번째가 아닌 노드를 삭제
    private void deleteIfTargetIndexIsNotZero(int targetIndex) {
        Node<T> current = head;
        int currentIndex = 0;
        while (currentIndex < targetIndex - 1) {
            current = current.getNext();
            currentIndex++;
        }
        current.setNext(current.getNext().getNext());
        size--;
    }
}
