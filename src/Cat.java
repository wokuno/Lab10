import java.util.Random;
import java.util.StringJoiner;

public class Cat implements Comparable<Cat> {

    public String name;
    public int age;
    public double weight;

    public Cat(String name, int age, double weight) {
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
    public int compareTo(Cat other) {
        int sum = 0;
        if (other.getAge() == this.getAge()){
            sum += 0;
        }else if (other.getAge() > this.getAge()){
            sum -= 10;
        } else {
            sum += 10;
        }
        if (other.getWeight() == this.getWeight()){
            sum += 0;
        } else if (other.getWeight() > this.getWeight()){
            sum -= 1;
        } else {
            sum += 1;
        }
        return sum;
    }
}
