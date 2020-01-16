package edu.training.expressions;

public abstract class Statements {
    public static void main(String[] args) {
        Integer ten = 10;
        Integer x,y,z = 0;

        if (isBiggerThan(ten)) {
            x = 10;
        } else {
            x = 20;
        }

        if (isSmallerThan(ten)) {
            y = 20;
        } else {
            y = 10;
        }

        z = (x + y) + (x + y);

        System.out.println(z);
    }

    private static boolean isSmallerThan(Integer ten) {
        return true;
    }

    private static boolean isBiggerThan(Integer ten) {
        return false;
    }

}
