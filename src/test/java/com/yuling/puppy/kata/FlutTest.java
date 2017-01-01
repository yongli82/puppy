package com.yuling.puppy.kata;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;


/**
 * Created by yangyongli on 19/12/2016.
 */
@RunWith(JUnit4.class)
public class FlutTest {

    public static class Person {
        String firstName;
        String lastName;
        String gender;
        int age;

        public Person(String firstName, String lastName, int age, String gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    Person person1;
    Person person2;
    Person person3;
    Person person4;
    List<Person> personList;

    @Before
    public void setUp() {
        person1 = new Person("Wilma", "FlintStone", 30, "F");
        person2 = new Person("Fred", "FlintStone", 32, "M");
        person3 = new Person("Betty", "Rubble", 31, "F");
        person4 = new Person("Barney", "Rubble", 33, "M");
        personList = Lists.newArrayList(person1, person2, person3, person4);


    }

    @Test
    public void testFilter() throws Exception {
        ImmutableList<String> names = FluentIterable.from(personList)
            .filter(new Predicate<Person>() {
                @Override
                public boolean apply(Person input) {
                    return input.getAge() > 31;
                }
            })
            .transform(new Function<Person,
                String>() {
                @Override
                public String apply(Person input) {
                    return Joiner.on('#').join(input.getLastName(),
                        input.getFirstName(), input.getAge());
                }
            }).toList();
    }
}
