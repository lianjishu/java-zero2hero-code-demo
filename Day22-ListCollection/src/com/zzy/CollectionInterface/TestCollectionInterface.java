package com.zzy.CollectionInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestCollectionInterface {
    // 是单列集合的顶层接口,它表示一组对象,这些对象也称为Collection的元素
    // JDK 不提供此接口的任何直接实现.它提供更具体的子接口(如Set和List)实现
    ArrayList<Integer> arrayList = new ArrayList<>();
    Collection<Integer> collection = new Collection<Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Integer integer) {
            return false;
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
        public boolean addAll(Collection<? extends Integer> c) {
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
        public void clear(){
        }
    };
}
