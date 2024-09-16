package method.defaultmethod;

public interface IPhone {
    public String getColor();

    default public void printBrand() {
        System.out.println("Apple");
    }
}
