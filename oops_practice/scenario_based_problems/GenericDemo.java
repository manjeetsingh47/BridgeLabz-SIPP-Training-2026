package oops_practice.scenario_based_problems;

import java.util.*;

class Pair<T, U> {
    private T first;
    private U second;

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class Stack<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }
}

class Repository<T> {
    private ArrayList<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
    }

    public void display() {
        for (T item : data) {
            System.out.println(item);
        }
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student: " + name;
    }
}

public class GenericDemo {

    public static <T extends Comparable<T>> T findMax(T[] arr) {
        T max = arr[0];

        for (T item : arr) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {

        Pair<String, Integer> p = new Pair<>("Manjeet", 22);
        System.out.println("Pair: " + p);

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.peek());
        System.out.println("Pop: " + stack.pop());

        Integer[] numbers = {10, 50, 30, 80, 40};
        System.out.println("Maximum: " + findMax(numbers));

        Repository<Student> studentRepo = new Repository<>();
        studentRepo.add(new Student("Aman"));
        studentRepo.add(new Student("Riya"));

        System.out.println("\nRepository Data:");
        studentRepo.display();

        List<String> names = Arrays.asList("Java", "Python", "C++");

        System.out.println("\nWildcard List:");
        printList(names);
    }
}