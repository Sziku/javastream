package org.example;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

            Printable textOne = new Text("One");
            Printable textTwo = new Text("Two");
            textOne.print(true);
            textTwo.print(false);
            textOne.doOtherThing();

            Printable textThree = isUpperCase -> {
                System.out.println(isUpperCase ? "JAVA IS GOOD" : "java is good");
            };

            textThree.print(true);
            textThree.print(false);

        System.out.println("------------------function-----------------------------");

        Function<Integer, Integer> addEleven = inputValue -> inputValue + 11;
        System.out.println(addEleven.apply(10));

        Function<Integer, String> conactText = inputValue -> "The result is " +inputValue;
        System.out.println(conactText.apply(10));


        Function<Integer, String> createSolutionText = addEleven.andThen(conactText);
        System.out.println(createSolutionText.apply(50));
        System.out.println("------------------consumer-----------------------------");
        //Consumer<String> print = text -> System.out.println(text);
        Consumer<String> print = System.out::println; // method refernce
        print.accept("test string");

        System.out.println("------------------supplier-----------------------------");
        Supplier<Integer> randomNUmberSupllier = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };

        System.out.println(randomNUmberSupllier.get());


        System.out.println("------------------predicate-----------------------------");
        Predicate<String> isAtLeastFiveCharacter = text -> text.length() >=5;
        System.out.println(isAtLeastFiveCharacter.test("long text"));
        System.out.println(isAtLeastFiveCharacter.test("A"));

        Predicate<String> containsA = text -> text.contains("A");
        System.out.println(containsA.test("long text"));
        System.out.println(containsA.test("A"));

        System.out.println("----------------------------------------------");
        System.out.println(isAtLeastFiveCharacter.and(containsA).test("long test"));
        System.out.println(isAtLeastFiveCharacter.and(containsA).test("A"));
        System.out.println(isAtLeastFiveCharacter.and(containsA).test("long test A"));

        System.out.println("------------------optionals-----------------------------");

        Optional<String> myOptional = Optional.of("this is my string");
        System.out.println(myOptional.isEmpty());
        System.out.println(myOptional.isPresent());
       // myOptional = Optional.of(null); java.lang.NullPointException

        myOptional = Optional.ofNullable(null);
        System.out.println(myOptional.isEmpty());
        System.out.println(myOptional.isPresent());
        myOptional = Optional.ofNullable("this is the string");
        System.out.println(myOptional.isEmpty());
        System.out.println(myOptional.isPresent());

        // empty optional
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isEmpty());
        System.out.println(empty.isPresent());

        System.out.println("----------------------------------------------");

        String value = myOptional.get();
        System.out.println(value);

        // value = empty.get(); java-util.NoSuchElementException

        value =  myOptional.orElse("other string");
        System.out.println(value);

        value =  empty.orElse("other string");
        System.out.println(value);

        Optional<Integer> bestNumber = Optional.ofNullable(42);
       //Optional<Integer> bestNumber = Optional.ofNullable(null);

        System.out.println(bestNumber.orElseGet(() -> {
            Random random =  new Random();
            return  random.nextInt(100);
        }));

        System.out.println(myOptional.orElseThrow(() -> new MyCustumeExcpetion()));
        System.out.println(myOptional.orElseThrow(MyCustumeExcpetion::new));
        //empty.orElseThrow(MyCustumeExcpetion::new);
        System.out.println(bestNumber.map(number -> number + " is the best number").orElse("no best number"));
        System.out.println(empty.map(number -> number + " is the best number").orElse("no best number"));

        System.out.println("----------------------------------------------");


        List<String> texts = new ArrayList<>(){{
            add("text1");
            add("text2");
            add("text3");
        }};

        Stream<String>  myStream = texts.stream();
       // myStream.forEach(text -> System.out.println(text));
       // myStream.forEach(System.out::println);
        myStream = Stream.of("text1","text2","text3");

        myStream = Stream.of("text1","text22222222222","text3333333333333333");
       // myStream.filter(f -> f.length()>5).forEach(text -> System.out.println(text));

        List<String> myTexts = myStream.filter(text -> text.length() > 5).collect(Collectors.toList());
        System.out.println(myTexts);
        for(String myText : myTexts){
            System.out.println(myText);
        }


        System.out.println("----------------------------------------------");
        List<Person> persons = new ArrayList<>(){{
            add(new Person("XYZAB","Harry","Potter",11));
            add(new Person("ABCDE","Bud","Spencer",60));
            add(new Person("ABBDE","Terence","Hill",40));
            add(new Person("XYZBB","Kinsey","Locke",15));
            add(new Person("YYZAB","Bode","Locke",10));
            add(new Person("YKZEB","Max","Mayfield",14));
            add(new Person("YKEEB","Nancy","Wheeler",20));
        }};

       // System.out.println("person name:");

       // persons.stream().map(person -> person.getFirstName() +" "+ person.getSecondName()).forEach(fullName -> System.out.println(fullName));


        persons.stream()
                .filter(person -> person.getAge()>=18)
                .forEach(person -> System.out.println(person.getId()));

        String result = persons.stream()
                .filter(person -> person.getId().equals("ABCDE"))
                .findFirst()
                .map(person -> person.getFirstName() + " " + person.getSecondName())
                .orElse("not found");

        System.out.println(result);

        boolean isAllNameLong = persons.stream()
                .map(person -> person.getFirstName() + " " + person.getSecondName())
                .allMatch(name -> name.length() >= 5);

        System.out.println(isAllNameLong);

        boolean any60OrOlder = isAllNameLong = persons.stream()
                .anyMatch(person -> person.getAge() >=60);

        System.out.println(any60OrOlder);
        System.out.println("------------------------------------students------------------------");

        List<Student> students = new ArrayList<>(){{
            add(new Student("XYZAB","Harry","Potter",11,1,5,3));
            add(new Student("ABCDE","Bud","Spencer",45,4,4,4));
            add(new Student("ABBDE","Terence","Hill",40,5,4,5));
            add(new Student("XYZBB","Kinsey","Locke",15,5,1,3));
            add(new Student("YYZAB","Bode","Locke",10,1,2,1));
            add(new Student("YKZEB","Max","Mayfield",14,4,4,5));
            add(new Student("YKEEB","Nancy","Wheeler",20,1,2,4));

        }};

        boolean failMathAndEnglish = students.stream()
                .anyMatch(student -> student.getMathGrade() == 1 && student.getEnglishGrade() == 1);
        System.out.println(failMathAndEnglish);
        System.out.println("------------------------------------4------------------------");
        students.stream()
                .filter(student -> (student.getEnglishGrade()+ student.getHistoryGrade()+ student.getMathGrade())/3 >= 4)
                .map(student ->student.getFirstName() + " " + student.getSecondName())
                .forEach(name -> System.out.println(name));


        System.out.println("------------------------------------sorted------------------------");
        persons.stream()
                .sorted(Comparator.comparing((Person::getAge)).reversed())
                .map(person -> person.getFirstName() + " " + person.getSecondName())
                .forEach(name -> System.out.println(name));

        persons.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(person -> System.out.println(person.getId()));

        System.out.println("------------------------------------5 students long name------------------------");
        students.stream()
                .filter(student -> student.getMathGrade() == 5)
                .max(Comparator.comparing(Student::getSecondName))
                .ifPresent(student -> System.out.println(student.getId()));

        double avargeAge = persons.stream()
                .mapToDouble(person -> person.getAge())
                .average()
                .orElse(0);

        System.out.println(avargeAge);
    }

    /*
    * házi feladat "jó tanulók" printeljük ki azoknak a diákoknak a nevét akik átlga legalább 4.
házi feladat 2: doktorokat kell összegyüjteni és nevüket (kereszt + vezetéknév) kiírni. doktor az lesz aki nem bukott meg semmiből. a doktorok neve elött ott van "Dr. "
Miklós Horváth [Java Jr. Mentor] — Today at 09:43
feladat: a matekból 5ös diákok közül kinek van a leghoszabb vezetékneve?
Miklós Horváth [Java Jr. Mentor] — Today at 09:59
házi feladat: a felnőt diákoknak mi a matek átlaga. ha nincsenek felnőt diákok akkor 0.*/
}