package five;

import three.MyLinkedList;

// 스택(MyStack)을 연결 리스트(MyLinkedList)로 구현.
public class MyStack<T> implements StackInterface<T> {
    private final MyLinkedList<T> linkedList = new MyLinkedList<>(); // 내부적으로 MyLinkedList 사용

    @Override
    public void push(T item) {
        linkedList.add(item); // 스택의 맨 위에 항목 추가
    }

    @Override
    public T pop() {
        T ret = top(); // 스택의 맨 위 항목을 가져옴
        linkedList.delete(linkedList.getSize() - 1); // 그 항목을 삭제
        return ret; // 삭제된 항목 반환
    }

    @Override
    public T top() {
        return linkedList.get(linkedList.getSize() - 1); // 스택의 맨 위 항목만 확인
    }

    @Override
    public int getSize() {
        return linkedList.getSize(); // 스택의 크기 반환
    }

    @Override
    public String toString() {
        return linkedList.toString(); // 스택의 내용을 문자열로 반환
    }
}
