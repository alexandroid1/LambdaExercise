package com.globallogic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SolutionJava8 {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)

        );

        //Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        //Collections.sort(people, Comparator.comparing(Person::getLastName));

        //Sort with Multiple Conditions – Composition
        Collections.sort(people, Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));

        System.out.println("Printing all persons");
        printConditionally(people, p -> true);

        System.out.println("");
        System.out.println("Printing all persons with the last name beginning with C");
        printConditionally(people, p -> p.getLastName().startsWith("C"));

        System.out.println("");
        System.out.println("Printing all persons with the first name beginning with C");
        printConditionally(people, p -> p.getFirstName().startsWith("C"));

    }

    private static void printConditionally(List<Person> people, Condition condition) {
        for (Person p : people) {
            if (condition.test(p)){
                System.out.println(p);
            }
        }
    }

    interface Condition {
        boolean test(Person p);
    }
}
