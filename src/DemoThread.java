import javax.crypto.spec.PSource;
import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoThread {

    public static void main(String[] args)  {

 /*Задание 1
    При старте приложения запускаются три потока. Пер-
    вый поток заполняет массив случайными числами. Два
    других потока ожидают заполнения. Когда массив запол-
    нен оба потока запускаются. Первый поток находит сумму
    элементов массива, второй поток среднеарифметическое
    значение в массиве. Полученный массив, сумма и средне-
    арифметическое возвращаются в метод main, где должны
    быть отображены.
*/

        Mass mass = new Mass(6);
        Thread thread1 = new Thread(mass);

        thread1.setName("GENERATE");
        thread1.start();

        try {
            thread1.join();

            Mass mass2 = new Mass(mass.getMass());
            Thread thread2 = new Thread(mass2);
            thread2.setName("SUM");
            thread2.start();

            Mass mass3 = new Mass(mass.getMass());
            Thread thread3 = new Thread(mass3);
            thread3.setName("AVG");
            thread3.start();

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        System.out.println("Созданный массив: " + Arrays.toString(mass.getMass()));
        System.out.println("Сумма элементов массива " + mass.sumMass(mass.getMass()));
        System.out.println("Среднеарифметическое значение элементов массива " + mass.AVG(mass.getMass()));


/*
Задание 2
    При старте приложения попросите пользователя ввести 2 дроби. Затем используя интерфейс Runnable запустить 4 потока, которые используя лямбда-выражения выполнят действия:
•	Сумма двух дробей;
•	Разница двух дробей;
•	Произведение двух дробей;
•	Деление двух дробей.
Результ операций нужно вывести в консоль.
*/


        Scanner sc = new Scanner(System.in);
        System.out.println("Введите два дробных числа");
        try {
            double num1 = sc.nextDouble();
            double num2 = sc.nextDouble();
            new Thread(() -> System.out.println(num1 + " + " + num2 + " = " + (num1 + num2)))
                    .start();

            new Thread(() -> System.out.println(num1 + " - " + num2 + " = " + (num1 - num2)))
                    .start();

            new Thread(() -> System.out.println(num1 + " * " + num2 + " = " + (num1 * num2)))
                    .start();


            new Thread(() -> System.out.println(num1 + " / " + num2 + " = " + (num1 / num2)))
                    .start();
        } catch (InputMismatchException exception) {
            System.err.println("Вы ввели неверное значение!");


        }
    }
}

