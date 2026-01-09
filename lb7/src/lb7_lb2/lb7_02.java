package lb7_lb2;

public class lb7_02 {
    public static void main(String[] args) {
        superClassTest myTest0 = new superClassTest();
        String superClassTest0 = myTest0.toString();
        System.out.println(superClassTest0);

        superClassTest myTest1 = new superClassTest("test this");
        String superClassTest1 = myTest1.toString();
        System.out.println(superClassTest1);

        superClassTest myTest2 = new subClassTest();
        String subClassTest0 = myTest2.toString();
        System.out.println(subClassTest0);

        superClassTest myTest3 = new subClassTest("test this too");
        String subClassTest1 = myTest3.toString();
        System.out.println(subClassTest1);

        superClassTest myTest4 = new subClassTest(256);
        String subClassTest2 = myTest4.toString();
        System.out.println(subClassTest2);

        superClassTest myTest5 = new subClassTest("test this and this", 256);
        String subClassTest3 = myTest5.toString();
        System.out.println(subClassTest3);
    }
}
