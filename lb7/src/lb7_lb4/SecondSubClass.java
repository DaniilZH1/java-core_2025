package lb7_lb4;

public class SecondSubClass extends FirstSupClass {
    SecondSubClass(char char1) {
        super(char1);
    }

    public String str1;

    public void setChar1Str1(char char1, String str1) {
        super.char1 = char1;
        this.str1 = str1;
    }

    SecondSubClass(char char1, String str1) {
        super(char1);
        this.setChar1Str1(char1, str1);
    }

    SecondSubClass(SecondSubClass copy) {
        super(copy.char1);
        this.setChar1Str1(copy.char1, copy.str1);
    }

    @Override
    public String toString() {
        String SecondFieldValue =
                "\n str 1 = " + this.getStr1();
        return super.toString()+SecondFieldValue;
    }
    public String getStr1() {
        return str1;
    }
}
