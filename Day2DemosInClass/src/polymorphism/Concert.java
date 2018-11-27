package polymorphism;

public class Concert {

    public static void main(String arg[]) {
        AnimalChoir choir = new AnimalChoir();
        Animal bass1 = new Cow();
        Animal bass2 = new Cow();
        Animal suprano1 = new Cat();
        Animal suprano2 = new Dog();

        choir.addMember(bass1);
        choir.addMember(suprano1);
        choir.addMember(suprano2);
        choir.addMember(bass2);
        choir.addMember(suprano2);
        

        choir.sing();
        
    }
}
