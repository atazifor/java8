package method.defaultmethod;

public class IPhone8Plus implements IPhone{
    @Override
    public String getColor() {
        return "Gray";
    }

    @Override
    public void printBrand() {
        IPhone.super.printBrand();
        System.out.println("Apple-Google");
    }

    public static void main(String[] args) {
        IPhone iphone = new IPhone8Plus();
        System.out.println("iphone.getColor() = " + iphone.getColor());
        iphone.printBrand();
    }
}
