import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    class Person {
        int age;
        String name;

    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++) {
            persons[i] = new Person();
            st = new StringTokenizer(br.readLine());
            persons[i].age = Integer.parseInt(st.nextToken());
            persons[i].name = st.nextToken();
        }
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].age + " " + persons[i].name);
        }

        br.close();
        // bw.flush();
        // bw.close();
    }


    public static void main (String[] args) throws Exception {
        new Main().solution();
    }
}

// 동일하다, new comparator를 잘 써야한다, 꼭 염두해야할 듯, 알고리즘 이전의 기초다. java를 사용해서 코테를 준비한다면!
