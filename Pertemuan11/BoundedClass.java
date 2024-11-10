class Bound<T extends A> {
    private T objRef;

    public Bound(T obj) {
        this.objRef = obj;
    }

    public void doRunTest() {
        this.objRef.displayClass();
    }
}

class A {
    public void displayClass() {
        System.out.println("Inside super class A");
    }
}

class B extends A {
    public void displayClass() {
        System.out.println("Inside sub class B");
    }
}

class C extends A {
    public void displayClass() {
        System.out.println("Inside sub class C");
    }
}

public class BoundedClass {
    public static void main(String a[]) {
        // Membuat objek dari subclass C dan
        // memberikan ke Bound sebagai parameter tipe
        Bound<C> bec = new Bound<>(new C());
        bec.doRunTest();

        // Membuat objek dari subclass B dan
        // memberikan ke Bound sebagai parameter tipe
        Bound<B> beb = new Bound<>(new B());
        beb.doRunTest();

        // Memberikan superclass A ke Bound
        Bound<A> bea = new Bound<>(new A());
        bea.doRunTest();
    }
}
