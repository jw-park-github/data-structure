package common;

public interface LinkedListInterface<T> {
    void add(T data); // 데이터를 추가

    T get(int index); // 특정 인덱스의 데이터를 가져옴

    void delete(int index); // 특정 인덱스의 데이터를 삭제

    int getSize(); // 리스트의 크기를 반환
}
