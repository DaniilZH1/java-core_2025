package lb7_lb4;
import com.sun.source.util.SourcePositions;
public class lb7_04 {
    public static void main(String[] args) {

        FirstSupClass superClassTest = new FirstSupClass('A');
        String className1 = superClassTest.toString();
        System.out.println(className1);

        FirstSupClass superClassTestCopy = new FirstSupClass(superClassTest);
        String className1copy = superClassTestCopy.toString();
        System.out.println(className1copy);

        SecondSubClass FirstSubClassTest = new SecondSubClass('A',"AAA");
        String className2 = FirstSubClassTest.toString();
        System.out.println(className2);

        SecondSubClass FirstSubClassTestCopy = new SecondSubClass(FirstSubClassTest);
        String className2Copy = FirstSubClassTestCopy.toString();
        System.out.println(className2Copy);

        ThirdSubClass SecondSubClassTest = new ThirdSubClass('A',"AAA",512);
        String className3 = SecondSubClassTest.toString();
        System.out.println(className3);

        ThirdSubClass SecondSubClassTestCopy = new ThirdSubClass(SecondSubClassTest);
        String className3Copy = SecondSubClassTestCopy.toString();
        System.out.println(className3Copy);
    }
}
