import java.util.StringJoiner;

public class Dog implements Comparable<Dog>{

    public String name;
    public int age;
    public double weight;

    public Dog(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void celebrateBirthday() {
        age = age + 1;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Dog other) {
        int sum = 0;
        String temp = other.getName();
        String temp2 = this.getName();
        if (other.getName().compareToIgnoreCase(this.getName()) > 0) {
            sum -= 10;
        }else if (other.getName().compareToIgnoreCase(this.getName()) < 0) {
            sum += 10;
        }

        if (other.getAge() > this.age) {
            sum --;
        } else if (other.getAge() < this.age) {
            sum ++;
        }
        return sum;
    }
}
