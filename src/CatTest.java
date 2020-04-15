public class CatTest {
    public static void main(String[] args) {

        Cat c1 = new Cat("Fog", 1, 1.1);
        Cat c2 = new Cat("Pepsi", 1, 1.1);
        Cat c3 = new Cat("Pepper", 1, 1.2);
        Cat c4 = new Cat("Sprite", 2, 1.1);
        Cat c5 = new Cat("Izzie", 2, 1.3);

        // Sorting order ignores name, sorts first on age, then if age ties, sorts on weight

        // so c1 == c2 (in terms of sorting)
        System.out.println(c1.compareTo(c2)); // 0
        System.out.println(c2.compareTo(c1)); // 0

        // sorting is done first on age so
        // c1 < c4
        System.out.println(c1.compareTo(c4)); // negative number
        // c4 > c2
        System.out.println(c4.compareTo(c2)); // positive number
        // c3 < c4
        System.out.println(c3.compareTo(c4)); // negative number

        // c1 < c5
        System.out.println(c1.compareTo(c5)); // negative number
        // c5 > c2
        System.out.println(c5.compareTo(c2)); // positive number
        // c3 < c5
        System.out.println(c3.compareTo(c5)); // negative number

        // if age matches, sort on weight:
        // c1 < c3
        System.out.println(c1.compareTo(c3)); // negative number
        // c3 > c2
        System.out.println(c3.compareTo(c2)); // positive number
        // c4 < c5
        System.out.println(c4.compareTo(c5)); // negative number

    }
}
/*
My code has this output, but technically any negative and positive numbers will work.
0
0
-1
1
-1
-1
1
-1
-1
1
-1
 */
