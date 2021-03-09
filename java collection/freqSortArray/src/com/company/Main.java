package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 5, 6, 8,2,8,6,7,5};

        freqArraySort(arr);
        System.out.println();
    }
    public static void freqArraySort(int[] arr) {
        //sort according to key
        TreeMap<Integer, TestItem> map = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).count += 1;
            } else {
                map.put(arr[i], new TestItem(1, arr[i]));
            }
        }

        Collection<TestItem> values = map.values();
        TestItem[] array = new TestItem[values.size()];
        Iterator<TestItem> iterator = values.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            TestItem next = iterator.next();
            next.index = count;
            array[count++] = next;
        }

        Arrays.sort(array, (o1, o2) -> {
            if (o1.count > o2.count) {
                return -1;
            } else if (o1.count < o2.count) {
                return 1;
            }

            if (o1.index < o2.index) {
                return -1;
            } else if (o1.index > o2.index) {
                return 1;
            }

            return 0;
        });

        printItem(array);
    }
    public static void printItem(TestItem[] array) {
        for (int i = 0; i < array.length; i++) {
            TestItem item = array[i];
            item.print(i == array.length - 1);
        }

    }
    public static class TestItem {
        int count;
        int index;
        int item;

        public TestItem(int count, int item) {
            this.count = count;
            this.item = item;
        }
        public void print(boolean isLast) {
            for (int i = 0; i < count; i++) {
                if (isLast && i == count - 1) {
                    System.out.print(item);
                } else
                {
                    System.out.print(item + " ");
                }
            }
        }
    }
}
