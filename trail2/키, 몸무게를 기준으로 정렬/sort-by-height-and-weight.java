import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Person p = new Person(st.nextToken(), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
            people[i] = p;
        }

        Arrays.sort(people);

        for (Person p : people) {
            System.out.println(p.toString());
        }
    }

}

class Person implements Comparable<Person> {
    String name;
    int height;
    int weight;

    public Person(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override // 키 작은 , 몸무게 큰
    public int compareTo(Person person) {
        if (this.height > person.height) {
            return 1;
        } else if (this.height == person.height) {
            if (this.weight < person.weight) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public String toString() {
        return this.name + " " + this.height + " " + this.weight;
    }
}