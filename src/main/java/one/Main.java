package one;

import common.LinkedListInterface;


public class Main {
    public static void main(String[] args) {
        LinkedListInterface<String> myLinkedList = new MyLinkedList<>();

        // 리스트에 데이터 추가
        myLinkedList.add("1st");
        myLinkedList.add("2nd");
        myLinkedList.add("3rd");
        myLinkedList.add("4th");
        myLinkedList.add("5th");
        myLinkedList.add("6th");
        System.out.println(myLinkedList); // 리스트 출력

        // 첫 번째 데이터 삭제 후 리스트 출력
        myLinkedList.delete(0);
        System.out.println(myLinkedList);

        // 리스트 크기 출력, 마지막 데이터 삭제 후 다시 리스트 출력
        System.out.println(myLinkedList.getSize());
        myLinkedList.delete(4);
        System.out.println(myLinkedList);
    }
}