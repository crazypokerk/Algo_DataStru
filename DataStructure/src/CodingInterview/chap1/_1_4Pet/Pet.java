package CodingInterview.chap1._1_4Pet;

/**
 * @Date 2019/3/7 9:50
 */
public class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Dog extends Pet {

    public Dog() {
        super("Dog");
    }
}

class Cat extends Pet {

    public Cat() {
        super("Cat");
    }
}
