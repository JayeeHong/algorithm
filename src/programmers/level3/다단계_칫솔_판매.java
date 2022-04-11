package programmers.level3;

import java.util.Arrays;
import java.util.HashMap;

public class 다단계_칫솔_판매 {
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Person> people = new HashMap<>();

        people.put("-", new Person("-"));
        for (int i = 0; i < enroll.length; i++) {
            people.put(enroll[i], new Person(enroll[i]));
        }

        for (int i = 0; i < referral.length; i++) {
            people.get(enroll[i]).parent = people.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            addProfit(people.get(seller[i]), amount[i] * 100);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = people.get(enroll[i]).profit;
        }

        return answer;
    }

    public static void addProfit(Person person, int profit) {
        int profit_for_parent = profit / 10;
        if (profit_for_parent != 0 && person.parent != null) {
            person.profit += profit - profit_for_parent;
            addProfit(person.parent, profit_for_parent);
        } else {
            person.profit += profit;
        }
    }

    static class Person {
        String name;
        Person parent;
        int profit;
        public Person(String name) {
            this.name = name;
            this.parent = null;
            this.profit = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}))); //[360, 958, 108, 0, 450, 18, 180, 1080]
        System.out.println(Arrays.toString(solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"sam", "emily", "jaimie", "edward"},
                new int[]{2, 3, 5, 4}))); //[0, 110, 378, 180, 270, 450, 0, 0]
    }
}
