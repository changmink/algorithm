package crackInterview.chap2;

import java.util.*;

/**
 * Created by changmin on 2018. 6. 12..
 * 일단 기본 add, remove만 구현
 */
public class LinkedListImpl<T> implements List<T>{
    private Node head;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node node = new Node();
        node.data = t;

        if(node == null)
            return false;

        if(head == null){
            head = node;
            return true;
        } else {
            node.next = head;
            head = node;
            return true;
        }
    }
    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        if(index >= this.size())
            return null;

        if(head == null)
            return null;


        int count = 0;
        Node p = head;
        while(count < index && p.next != null){
            p = p.next;
            count += 1;
        }

        T output = null;
        output = (T) p.data;
        if(count == index) return output;
        else return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }



    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
