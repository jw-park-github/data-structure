package two;

import common.LinkedListInterface;
import common.Node;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList<T> implements LinkedListInterface<T> {
    private Node<T> head = null; // 리스트의 시작 노드
    private Node<T> tail = null; // 리스트의 마지막 노드
    private int size = 0; // 리스트의 현재 크기

    @Override
    public void add(T data) {
        if (head == null) { // 리스트가 비어있을 때
            addIfEmpty(data); // 첫 번째 노드로 추가
            size++; // 크기 증가
            return;
        }
        addIfNotEmpty(data); // 리스트가 비어있지 않을 때 추가
        size++; // 크기 증가
    }

    // 특정 인덱스의 노드 데이터 반환
    @Override
    public T get(int targetIndex) {
        if (checkValidBound(targetIndex)) { // 인덱스 유효성 검사
            throw new IndexOutOfBoundsException();
        }
        Node<T> currentNode = this.head; // 시작 노드부터 탐색 시작
        int currentIndex = 0;
        while (currentIndex < targetIndex) { // 타겟 인덱스까지 이동
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return currentNode.getData(); // 데이터 반환
    }

    // 특정 인덱스의 노드 삭제
    @Override
    public void delete(int targetIndex) {
        if (checkValidBound(targetIndex)) { // 인덱스 유효성 검사
            throw new IndexOutOfBoundsException();
        }
        if (targetIndex == 0) { // 첫 번째 노드 삭제
            deleteIfTargetIndexIsZero();
            return;
        }
        deleteIfTargetIndexIsNotZero(targetIndex); // 그 외의 경우 삭제
    }

    // 리스트를 문자열로 변환
    @Override
    public String toString() {
        List<String> result = new ArrayList<>();
        Node<T> current = head;
        while (current != null) { // 모든 노드 순회
            result.add(current.getData().toString());
            current = current.getNext();
        }
        return String.join(" -> ", result); // 연결하여 반환
    }

    // 리스트 크기 반환
    @Override
    public int getSize() {
        return size;
    }

    // 인덱스가 유효한 범위 내인지 검사
    private boolean checkValidBound(int targetIndex) {
        return targetIndex < 0 || targetIndex >= size;
    }

    // 비어있지 않은 리스트에 노드 추가
    private void addIfNotEmpty(T data) {
        tail.setNext(new Node<>(data)); // 마지막 노드 뒤에 새 노드 추가
        tail = tail.getNext(); // 새 노드를 마지막 노드로 설정
    }

    // 리스트가 비어있을 때 노드 추가
    private void addIfEmpty(T data) {
        head = new Node<>(data); // 새 노드를 첫 번째 노드로 설정
        tail = head; // 첫 번째 노드가 마지막 노드이기도 함
    }

    // 첫 번째가 아닌 노드 삭제
    private void deleteIfTargetIndexIsNotZero(int targetIndex) {
        Node<T> current = head;
        int currentIndex = 0;
        while (currentIndex < targetIndex - 1) { // 삭제할 노드의 이전 노드까지 이동
            current = current.getNext();
            currentIndex++;
        }
        if (current.getNext().getNext() == null) { // 마지막 노드를 삭제하는 경우
            tail = current; // 현재 노드를 마지막 노드로 설정
        }
        current.setNext(current.getNext().getNext()); // 삭제할 노드를 리스트에서 제거
        size--; // 크기 감소
    }

    // 첫 번째 노드 삭제
    private void deleteIfTargetIndexIsZero() {
        head = head.getNext(); // 두 번째 노드를 첫 번째 노드로 설정
        if (head == null) { // 리스트가 비었을 경우
            tail = null; // 마지막 노드도 null로 설정
        }
        size--; // 크기 감소
    }
}
