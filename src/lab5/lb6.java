package lab5;

public class lb6 {
    public static void main(String[] args) {
        //конструктор с 2-я аргументами
        Example_6 myexample = new Example_6(2,5);
        myexample.PrintInt();
        //конструктор с 1-м аргументом
        myexample = new Example_6(1);
        myexample.PrintInt();
        //метод с 2-я аргументами
        myexample.SetInt(3,15);
        myexample.PrintInt();
        //метод с 1-м аргументом
        myexample.SetInt(-9);
        myexample.PrintInt();
    }
}
class Example_6{
    //два закрытых целочисленных поля (max и min).
    private int min;
    private int max;
    //Значения полям присваиваются с помощью открытого метода.
    public void SetInt(int num1, int num2){
        //сравниваются текущие значения полей и значения аргументов, переданных методу.
        //  Самое большое из значений присваивается полю max, а самое маленькое из значений присваивается полю min.
        System.out.println("Метод Setint() c 2-я аргументами");
        min = Math.min(num1, num2);
        max = Math.max(num1, num2);
    }

    public void SetInt(int num){
        //сравниваются текущие значения полей и значения аргументов, переданных методу.
        //  Самое большое из значений присваивается полю max, а самое маленькое из значений присваивается полю min.
        System.out.println("Метод Setint() c 1-м аргументом");
        min = Math.min(min, num);
        max = Math.max(max, num);
    }
    //метод, отображающий в консольном окне значения полей объекта.
    void PrintInt() {
        System.out.println("min = "+min);
        System.out.println("max = "+max);
    }
    //конструктор, который работает по тому же принципу, что и метод для присваивания значений полям
    Example_6(int num1, int num2){
        System.out.println("Конструктор Example_6() c 2-я аргументами");
        min = Math.min(num1, num2);
        max = Math.max(num1, num2);
    }
    //конструктор, который работает по тому же принципу, что и метод для присваивания значений полям
    Example_6(int num){
        System.out.println("Конструктор Example_6() c 1-м аргументом");
        min = Math.min(min, num);
        max = Math.max(max, num);
    }
}
