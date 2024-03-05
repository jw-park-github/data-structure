package five;


public interface StackInterface<T> {
    void push(T item); // 항목 추가

    T top(); // 맨 위 항목 확인

    T pop(); // 항목 제거 및 반환

    int getSize(); // 스택의 크기 반환
}
