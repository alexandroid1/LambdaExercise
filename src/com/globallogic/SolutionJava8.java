package com.globallogic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
        performConditionally(people, p -> true, p-> System.out.println(p));

        System.out.println("");
        System.out.println("Printing all persons with the last name beginning with C");
        performConditionally(people, p -> p.getLastName().startsWith("C"), p-> System.out.println(p));

        System.out.println("");
        System.out.println("Printing all persons with the first name beginning with C");
        // prints only first name
        performConditionally(people, p -> p.getFirstName().startsWith("C"), p-> System.out.println(p.getFirstName()));

    }

    // using java.util.function - predicate
    private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p)){
                consumer.accept(p);
            }
        }
    }

}
