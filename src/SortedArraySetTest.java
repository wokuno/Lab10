public class SortedArraySetTest {
    public static void main(String[] args) {

        SortedArraySet<String> set = new SortedArraySet<String>(4);
        System.out.println(set); // [null, null, null, null]: 0
        System.out.println(set.contains("apple")); // false
        System.out.println(set.contains("dennis")); // false
        System.out.println(set.getSize()); // 0
        System.out.println(set.isEmpty()); // true
        System.out.println(set.getBiggest()); // null
        System.out.println(set.getSmallest()); // null

        set.add("dennis");
        System.out.println(set); // [dennis, null, null, null]: 1
        System.out.println(set.contains("apple")); // false
        System.out.println(set.contains("dennis")); // true
        System.out.println(set.getSize()); // 1
        System.out.println(set.isEmpty()); // false
        System.out.println(set.getBiggest()); // dennis
        System.out.println(set.getSmallest()); // dennis

        set.add("ruff");
        set.add("apple");
        set.add("anderson");
        System.out.println(set); // [anderson, apple, dennis, ruff]: 4
        System.out.println(set.contains("apple")); // true
        System.out.println(set.contains("dennis")); // true
        System.out.println(set.getSize()); // 4
        System.out.println(set.isEmpty()); // false
        System.out.println(set.getBiggest()); // ruff
        System.out.println(set.getSmallest()); // anderson

        set.add("ruff");
        set.add("apple");
        System.out.println(set); // [anderson, apple, dennis, ruff]: 4

        set.add("hartman");
        System.out.println(set); // [anderson, apple, dennis, hartman, ruff, null, null, null]: 5
        System.out.println(set.contains("hartman")); // true
        System.out.println(set.contains("ruff")); // true
        System.out.println(set.getSize()); // 5
        System.out.println(set.isEmpty()); // false
        System.out.println(set.getBiggest()); // ruff
        System.out.println(set.getSmallest()); // anderson

        set.remove("apple");
        System.out.println(set); // [anderson, dennis, hartman, ruff, null, null, null, null]: 4
        System.out.println(set.contains("hartman")); // true
        System.out.println(set.contains("apple")); // false
        System.out.println(set.getSize()); // 4
        System.out.println(set.isEmpty()); // false
        System.out.println(set.getBiggest()); // ruff
        System.out.println(set.getSmallest()); // anderson

        set.remove("anderson");
        set.remove("hartman");
        set.remove("dennis");
        set.remove("ruff");
        System.out.println(set); // [null, null, null, null, null, null, null, null]: 0
        System.out.println(set.contains("hartman")); // false
        System.out.println(set.contains("apple")); // false
        System.out.println(set.getSize()); // 0
        System.out.println(set.isEmpty()); // true
        System.out.println(set.getBiggest()); // null
        System.out.println(set.getSmallest()); // null

    }
}
/*
[null, null, null, null]: 0
false
false
0
true
null
null
[dennis, null, null, null]: 1
false
true
1
false
dennis
dennis
[anderson, apple, dennis, ruff]: 4
true
true
4
false
ruff
anderson
[anderson, apple, dennis, ruff]: 4
[anderson, apple, dennis, hartman, ruff, null, null, null]: 5
true
true
5
false
ruff
anderson
[anderson, dennis, hartman, ruff, null, null, null, null]: 4
true
false
4
false
ruff
anderson
[null, null, null, null, null, null, null, null]: 0
false
false
0
true
null
null
*/