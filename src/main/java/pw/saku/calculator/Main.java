package pw.saku.calculator;

import pw.saku.calculator.gui.GuiCalculator;

public class Main {

    public  static void main(String[] args) {
        System.out.println("Calculator loading...");
        new GuiCalculator("Calculator", "+");
        System.out.println("Calculator started!");
    }

}
