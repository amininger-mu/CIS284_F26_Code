public class Person {
    private final String name;
    private final int age;

    public Person(String pName, int pAge) {
        name = pName;
        age = pAge;
    }

    public String name() {
        return name;
    }
    public int age() {
        return age;
    }

    public String toString() {
        return name + " (" + age + " years old)";
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Person)) return false;
        Person p2 = (Person)obj;
        return name.equals(p2.name) && age == p2.age;

    }
    
}
