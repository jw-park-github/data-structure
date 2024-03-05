package three;

public interface LinkedListIterableInterface<T> extends Iterable<T> {
    // Iterable 인터페이스 상속을 통해 반복자 사용 가능
    void add(T data);

    T get(int index);

    void delete(int index);

    int getSize();
}
