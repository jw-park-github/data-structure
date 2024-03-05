package four;

import two.MyLinkedList;

// 큐(MyQueue)을 연결 리스트(MyLinkedList)로 구현.
public class MyQueue<T> implements QueueInterface<T> {
    private final MyLinkedList<T> linkedList = new MyLinkedList<>(); // 내부적으로 MyLinkedList 사용

    @Override
    public void push(T item) {
        linkedList.add(item); // 큐의 끝에 항목 추가
    }

    @Override
    public T pop() {
        T ret = peek(); // 큐의 첫 번째 항목을 가져옴
        linkedList.delete(0); // 그 항목을 삭제
        return ret; // 삭제된 항목 반환
    }

    @Override
    public T peek() {
        return linkedList.get(0); // 큐의 첫 번째 항목만 확인
    }

    @Override
    public int getSize() {
        return linkedList.getSize(); // 큐의 크기 반환
    }

    @Override
    public String toString() {
        return linkedList.toString(); // 큐의 내용을 문자열로 반환
    }
}
