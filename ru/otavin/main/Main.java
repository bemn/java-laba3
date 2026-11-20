package ru.otavin.main;

import ru.otavin.inputcheck.*;
import ru.otavin.taskclasses.*;

import java.util.Scanner;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

class Main {
    Scanner sc = new Scanner(System.in, "Cp866");

    public static double power(String x, String y) {
        return pow(parseInt(x), parseInt(y));
    }
    
    public static void main(String[] args){
        InputCheck obj = new InputCheck();

        System.out.print("==Power Task==\n");
        if(args.length == 2){
            try {
                System.out.println(args[0] + "^" + args[1] + " = " + power(args[0], args[1]));
            } catch (Exception e) {
                System.out.println("Data error.");
            }
        }



        
        System.out.print("\n==Imya Task==\n");

        Imya name1 = new Imya("Клеопатра");
        Imya name2 = new Imya("Александр","Пушкин", "Сергеевич");
        Imya name3 = new Imya("Владимир","Маяковский");
        Imya name4 = new Imya("Христофор","Бонифатьевич");
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);

        System.out.print("\nEnter first name: ");
        String firstName = obj.read_String();
        System.out.print("Enter surname: ");
        String surname = obj.read_String();
        String middleName = null;
        if (!surname.isEmpty()) {
            System.out.print("Enter middle name: ");
            middleName = obj.read_String();
        }
        Imya fullname = Imya.create(firstName, surname, middleName);
        System.out.println("Received name: " + fullname);




        System.out.print("==Drob Task==\n");
        Drob f1 = new Drob(-1, 3);
        Drob f2 = new Drob(2, 3);

        System.out.println("output of methods from Number class:");
        System.out.println(f2);              
        System.out.println(f2.intValue());   
        System.out.println(f2.longValue());  
        System.out.println(f2.floatValue()); 
        System.out.println(f2.doubleValue());

        Drob result = f1.sum(f2);

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f1 + f2 = " + result);

        System.out.println("Sum of numbers (2 + 3/5 + 2.3) = " + Drob.sum("2 + 3/5 + 2.3"));
        System.out.println("Sum of numbers (3.6 + 49/12 + 3 + 3/2) = " + Drob.sum("3.6 + 49/12 + 3 + 3/2"));
        System.out.println("Sum of numbers (1/3 + 1) = " + Drob.sum("1/3 + 1"));

        System.out.println("Enter sum expression:");
        String line = obj.read_wordString();
        System.out.println("The sum is: " + Drob.sum(line));

        Drob f3 = new Drob(1, -3);
        Drob f4 = new Drob(2, 3);
        Drob f5 = new Drob(3, -4);

        System.out.println("\nf3 = " + f3);
        System.out.println("f4 = " + f4);
        System.out.println("f5 = " + f5);

        System.out.println("f3 + f4 = " + f3.sum(f4));
        System.out.println("f3 * f4 = " + f3.multiply(f4));
        System.out.println("f3 + f4 / f5 - 5 = " + f3.sum(f4).div(f5).minus(5));

        System.out.println("Equality check:");
        System.out.println("f2.equals(f4): " + f2.equals(f4));
        System.out.println("f1.equals(f3): " + f1.equals(f3));
        System.out.println("f1.equals(f2): " + f1.equals(f2));

        System.out.print("\n1) Enter numerator and denominator: ");
        String[] input1 = obj.read_wordString().split(" ");
        Drob f6 = new Drob(
            Integer.parseInt(input1[0]),
            Integer.parseInt(input1[1])
        );

        System.out.print("2) Enter numerator and denominator: ");
        String[] input2 = obj.read_wordString().split(" ");
        Drob f7 = new Drob(
            Integer.parseInt(input2[0]),
            Integer.parseInt(input2[1])
        );

        System.out.print("3) Enter numerator and denominator: ");
        String[] input3 = obj.read_wordString().split(" ");
        Drob f8 = new Drob(
            Integer.parseInt(input3[0]),
            Integer.parseInt(input3[1])
        );

        System.out.println("\n--- Results ---");

        System.out.println(f6 + " + " + f7 + " = " + f6.sum(f7));
        System.out.println(f6 + " + 2 = " + f6.sum(2));

        System.out.println(f6 + " - " + f7 + " = " + f6.minus(f7));
        System.out.println(f6 + " - 2 = " + f6.minus(2));

        System.out.println(f6 + " * " + f7 + " = " + f6.multiply(f7));
        System.out.println(f6 + " * 2 = " + f6.multiply(2));

        System.out.println(f6 + " / " + f7 + " = " + f6.div(f7));
        System.out.println(f6 + " / 2 = " + f6.div(2));

        Drob result2 = f6.sum(f7).div(f8).minus(5);

        System.out.println("\n--- Chain of Operations ---");
        System.out.println(f6 + " + " + f7 + " / " + f8 + " - 5 = " + result2);

        Drob rescopy = result2.clone();
        System.out.println("Clone: " + rescopy);
        System.out.println("Is it the same object? " + (result2 == rescopy));
        System.out.println("Do they have the same values? " + result2.equals(rescopy));




        System.out.print("\n==Secret Task==\n");

        Secret s1 = new Secret("Алексей", "Джава очень интересный язык");
        Secret s2 = new Secret(s1, "Борис");
        Secret s3 = new Secret(s2, "Виктор");

        System.out.println("--- Проверка ---");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println("\nПорядок " + s2.getKeeperName(0) + ": " + s2.getOrder());
        System.out.println("После " + s1.getKeeperName(0) + " узнали: " + s1.getNextCount());

        System.out.println("Следующий после " + s1.getKeeperName(0) + ": " + s1.getKeeperName(1));
        System.out.println("Предыдущий у " + s3.getKeeperName(0) + ": " + s3.getKeeperName(-1));

        System.out.println("Разница длины текста " + s1.getKeeperName(0) + " и " + s3.getKeeperName(0) + ": "
                + s1.getTextLengthDifference(2));

        try {
            Secret s4 = new Secret(s1, "Дмитрий");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("\nВведите имя первого хранителя: ");
        String name = obj.read_wordString();

        System.out.print("Введите секрет: ");
        String text = obj.read_wordString();

        Secret secret = new Secret(name, text);

        System.out.print("Сколько раз будет передоваться секрет: ");
        int n = obj.read_Int();

        Secret current = secret;

        for (int i = 0; i < n; i++) {
            System.out.print("Введите имя следующего хранителя: ");
            String nextName = obj.read_wordString();

            current = new Secret(current, nextName);
        }

        System.out.println("\n--- Проверка ---");

        System.out.println("Текущий хранитель: " + current);
        System.out.println("Номер хранителя: " + current.getOrder());
        System.out.println("Сколько следующих узнали: " + current.getNextCount());

        System.out.print("Введите номер хранителя относительно текущего: ");
        int number = obj.read_Int();

        String keeper = current.getKeeperName(number);

        if (keeper != null) {
            System.out.println("Хранитель: " + keeper);
            System.out.println("Разница длины секретов: "
                    + current.getTextLengthDifference(number));
        } else {
            System.out.println("Такого хранителя в цепочке нет!");
        }

        System.out.print("\n==The end==");
        
    }
}