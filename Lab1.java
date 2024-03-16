import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double S = 0;
        final int C = 1;
        float a, b ,n, m;

        System.out.println("Введіть a: ");
        while (!input.hasNextFloat()){
            System.out.println("Введіть числовий тип 'float'");
            input.next();
        }
        a = input.nextFloat();

        System.out.println("Введіть n: ");
        while (!input.hasNextFloat()){
            System.out.println("Введіть числовий тип 'float'");
            input.next();
        }
        n = input.nextFloat();

        System.out.println("Введіть b: ");
        while (!input.hasNextFloat()){
            System.out.println("Введіть числовий тип 'float'");
            input.next();
        }
        b = input.nextFloat();

        System.out.println("Введіть m: ");
        while (!input.hasNextFloat()){
            System.out.println("Введіть числовий тип 'float'");
            input.next();
        }
        m = input.nextFloat();

        if (a > n || b > m) {
            System.out.println("Верхня границя не може бути меншою за нижню!");
        } else if ((a <= -C && n >= -C) || (b <= -C && m >= -C)) {
            System.out.println("Недопустимі значення: присутнє ділення на нуль!");
        } else {
            for (float i = a; i <= n; i++) {
                for (float j = b; j <= m; j++) {
                    S += (i + j) / (i + C);
                }
            }
            String doubleS = String.format("S = %.3f", S);
            System.out.println(doubleS);
        }
    }
}
