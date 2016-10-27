package collectionsdemo;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
//        showSomeArrayListMethods();
//        showSomeLinkedListMethods();
//        showSomeHashSetMethods();
//        showSomeTreeSetMethods();
//        showSomeHashMapMethods();
        showSomeTreeMapMethods();
    }

    private static void showSomeTreeMapMethods() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "one");
        treeMap.put(2, "two");
        treeMap.put(3, "three");
        treeMap.put(4, "four");

        System.out.println(treeMap);

        System.out.println("key-set: " + treeMap.keySet());
        System.out.println("descending key-set: " + treeMap.descendingKeySet());
        System.out.println("entry-set: " + treeMap.entrySet());
        System.out.println("descending entry-set: " + treeMap.descendingMap().entrySet());
        System.out.println("values: " + treeMap.values());
        System.out.println("values descending by key: " + treeMap.descendingMap().values());

        System.out.println("head-map of 2: " + treeMap.headMap(2));
        System.out.println("tail-map of 2: " + treeMap.tailMap(2));
        System.out.println("sub-map of 1-2: " + treeMap.subMap(1, 2));
        System.out.println("sub-map of 1 (included) - 2 (included): " + treeMap.subMap(1, true, 2, true));

        System.out.println("first key: " + treeMap.firstKey());
        System.out.println("first entry: " + treeMap.firstEntry());

        System.out.println("floor key of 3: " + treeMap.floorKey(3));
        System.out.println("floor entry of 3: " + treeMap.floorEntry(3));
        System.out.println("lower key of 3: " + treeMap.lowerKey(3));
        System.out.println("lower entry of 3: " + treeMap.lowerEntry(3));

        System.out.println("poll last: " + treeMap.pollLastEntry());
        System.out.println("poll first: " + treeMap.pollFirstEntry());
        System.out.println("after poll: " + treeMap);
    }

    private static void showSomeHashMapMethods() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        System.out.println("hashMap: " + hashMap);
        System.out.println("hashMap.get(1); " + hashMap.get(1));
        System.out.println("hashMap.get(99); " + hashMap.get(99));
        System.out.println("contains key 2? " + hashMap.containsKey(2));
        System.out.println("contains value two? " + hashMap.containsValue("two"));

        System.out.println("key-set: " + hashMap.keySet());
        System.out.println("entry-set: " + hashMap.entrySet());
        System.out.println("values: " + hashMap.values());

        hashMap.remove(1);
        System.out.println("hashMap after remove: " + hashMap);

        HashMap<String, Integer> hashMap2 = new HashMap<>();
        hashMap2.put("otto", 1);
        hashMap2.put("hugo", 2);
        hashMap2.put("ferdinand", 3);
        System.out.println("key-set: " + hashMap2.keySet());
        System.out.println("entry-set: " + hashMap2.entrySet());
        System.out.println("values: " + hashMap2.values());
    }

    private static void showSomeTreeSetMethods() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("otto");
        treeSet.add("hugo");
        treeSet.add("ferdinand");
        System.out.println("treeSet: " + treeSet);

        for(String str : treeSet.descendingSet())
            System.out.println(str);

        Iterator<String> descendingIterator = treeSet.descendingIterator();
        while(descendingIterator.hasNext())
            System.out.println("descending iterator: " + descendingIterator.next());

        System.out.println("ceiling gaga: " + treeSet.ceiling("gaga"));
        System.out.println("floor gaga: " + treeSet.floor("gaga"));
        System.out.println("ceiling hugo: " + treeSet.ceiling("hugo"));
        System.out.println("floor hugo: " + treeSet.floor("hugo"));
        System.out.println("higher ferdinand: " + treeSet.higher("ferdinand"));
        System.out.println("lower otto: " + treeSet.lower("otto"));
    }

    private static void showSomeHashSetMethods() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("otto");
        hashSet.add("hugo");
        hashSet.add("ferdinand");
        System.out.println("hashSet: " + hashSet);

        System.out.println("contains otto? " + hashSet.contains("otto"));
        hashSet.remove("hugo");
        System.out.println("hashSet: " + hashSet);

        for(String value : hashSet)
            System.out.println("value: " + value);
    }

    private static void showSomeLinkedListMethods() {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("size: " + list.size());
        for(int value = 0; value < 10; ++value)
            list.add(value);
        System.out.println("list after add: " + list);
        System.out.println("element at 3: " + list.get(3));
        list.set(3, 30);
        System.out.println("list after set: " + list);

        LinkedList<Integer> copiedList = new LinkedList<>(list);
        System.out.println("list after copy: " + copiedList);
        System.out.println("are lists equal? -> " + list.equals(copiedList));
        list.remove(4);
        list.remove(4);
        System.out.println("after remove: " + list);

        copiedList.offerFirst(-999);
        copiedList.offerLast(999);
        System.out.println("after offer: " + copiedList);
        System.out.println("getFirst: " + copiedList.getFirst());
        System.out.println("getLast: " + copiedList.getLast());

        System.out.println("pollFirst: " + copiedList.pollFirst());
        System.out.println("pollFirst: " + copiedList.pollFirst());
        System.out.println("pollLast: " + copiedList.pollLast());
        System.out.println("after polls: " + copiedList);
    }

    private static void showSomeArrayListMethods() {
        List<Integer> list = new ArrayList<>(10);
        System.out.println("size: " + list.size());
        for(int value = 0; value < 10; ++value)
            list.add(value);
        System.out.println("list after add: " + list);
        System.out.println("element at 3: " + list.get(3));
        list.set(3, 30);
        System.out.println("list after set: " + list);

        List<Integer> copiedList = new ArrayList<>(list);
        System.out.println("list after copy: " + copiedList);
        System.out.println("are lists equal? -> " + list.equals(copiedList));
        list.remove(4);
        list.remove(4);
        System.out.println("removing object 10: " + list.remove((Integer)10));
        System.out.println("removing object 8: " + list.remove((Integer)8));
        System.out.println("after remove: " + list);
        System.out.println("copied list: " + copiedList);
        System.out.println("are lists equal? -> " + list.equals(copiedList));

        for (int element : list)
            if (element % 2 != 0)
                System.out.println("odd element: " + element);

        Iterator<Integer> listIterator = list.iterator();
        while(listIterator.hasNext())
            System.out.println("iterating: " + listIterator.next());

        System.out.println("list contains 9? " + list.contains(9));
        System.out.println("index of 9: " + list.indexOf(9));
        copiedList.addAll(list);
        copiedList.addAll(list);
        System.out.println("copied list... index of 9: " + copiedList.indexOf(9));
        System.out.println("copied list... last index of 9: " + copiedList.lastIndexOf(9));

        Collections.sort(copiedList);
        System.out.println("after sort: " + copiedList);

        List<Integer> sublist = copiedList.subList(2, 4);
        System.out.println("sublist: " + sublist);
        sublist.set(1, 99);
        System.out.println("sublist: " + sublist);
        System.out.println("copiedList: " + copiedList);

        List<Integer> safeSublist = Collections.unmodifiableList(copiedList.subList(2, 4));
        try {
            safeSublist.set(1, 99);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        System.out.println("safe sublist: " + safeSublist);
    }
}
