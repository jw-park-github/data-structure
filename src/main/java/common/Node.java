package common;

public class Node<T> {
    final private T data; // 노드가 저장할 데이터
    private Node<T> next; // 다음 노드를 가리키는 포인터

    public Node(T data) {
        this.data = data; // 노드 생성자, 데이터 초기화
        this.next = null; // 다음 노드 초기화
    }

    // Getter와 Setter 메소드
    public T getData() { return data; }
    public Node<T> getNext() { return next; }
    public void setNext(Node<T> next) { this.next = next; }
}