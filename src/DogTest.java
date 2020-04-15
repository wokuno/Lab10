public class DogTest {
    public static void main(String[] args) {


        Dog d1 = new Dog("fido", 10, 1.3);

        // since we didn't put this on the dog template, check for correct inheritance relationships
        System.out.println(d1 instanceof Comparable);
        Comparable<Dog> test = d1;

        Dog d2 = new Dog("fido", 10, 1.5);
        Dog d3 = new Dog("berns", 14, 11.32);
        Dog d4 = new Dog("rex", 4, 5.2);
        Dog d5 = new Dog("fido", 13, 2.1);
        Dog d6 = new Dog("fida", 13, 2.1);

        // Sorting order ignores weight, sorts first on name (alphabetical order), then if names are equal, sorts on age

        // Since d1 and d2 have the same name and age, they should be equal (in terms of sorting)
        // d1 == d2
        System.out.println(d1.compareTo(d2)); // 0
        System.out.println(d2.compareTo(d1)); // 0

        // We first sort based on name, so berns < fida < fido < rex
        // d3 < d6
        System.out.println(d3.compareTo(d6)); // negative number
        // d6 < d1
        System.out.println(d6.compareTo(d1)); // negative number
        // d1 < d4
        System.out.println(d1.compareTo(d4)); // negative number
        // d3 < d2
        System.out.println(d3.compareTo(d2)); // negative number
        // d5 > d6
        System.out.println(d5.compareTo(d6)); // positive number

        // then we sort on age
        // d1 < d5
        System.out.println(d1.compareTo(d5)); // negative number

    }
}
/*
My code has this output, but technically any negative and positive numbers will work.
0
0
-4
-14
-12
-4
14
-3
 */
