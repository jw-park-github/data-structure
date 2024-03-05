package four;

// QueueInterface: 큐를 위한 기본 인터페이스 정의
public interface QueueInterface<T> {

    void push(T item); // 항목 추가

    T pop(); // 항목 제거 및 반환

    T peek(); // 첫 번째 항목 확인

    int getSize(); // 큐의 크기 반환
}
