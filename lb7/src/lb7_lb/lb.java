package lb7_lb;

public class lb {
    public static void main(String[] args) {

        SuperClassTest superClassObject =
                new SuperClassTest("передал в конструктор суперкласса");
        String className = superClassObject.toString();
        System.out.println(className);

        SubClassTest subClassObject1 =
                new SubClassTest( "передал в конструктор подкласса");
        String subClassName = subClassObject1.toString();
        System.out.println(subClassName);

        SubClassTest subClassObject2 =
                new SubClassTest( "передал в конструктор подкласса", "где два параметра");
        String subClassName2 = subClassObject2.toString();
        System.out.println(subClassName2);
    }
}
