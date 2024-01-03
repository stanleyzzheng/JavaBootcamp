public class LibraryInterfaceDemo {
    public static void main(String[] args){
        KidUser k1 = new KidUser();
        k1.setAge(10);
        k1.registerAccount();
        k1.setAge(18);
        k1.registerAccount();

        k1.setBookType("Kids");

        k1.requestBook();


    }
}
