package lb_lb5;

public class lb_05 {
    public static void main(String[] args) {
        FirstSupClass SuperClassTest1 = new FirstSupClass("easy to test this");
        SuperClassTest1.PrintToString();

        FirstSubClass SubClassTest1 = new FirstSubClass("Test 4 subclass", 256);
        SubClassTest1.PrintToString();

        SecondSubClass SubClassTest2 = new SecondSubClass("Test 4 subclass again", 'A');
        SubClassTest2.PrintToString();

        FirstSupClass SuperClassTest2 = new FirstSupClass(SubClassTest1.getStr1());
        SuperClassTest2.PrintToString();

        FirstSupClass SuperClassTest3 = new FirstSupClass(SubClassTest2.str1);
        SuperClassTest3.PrintToString();
    }
}
