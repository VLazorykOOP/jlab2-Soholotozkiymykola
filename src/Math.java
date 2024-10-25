public class Math {
    
    // Метод для знаходження найбільшого спільного дільника (НСД) за алгоритмом Евкліда
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Метод для знаходження найменшого спільного кратного (НСК)
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);  // НСК = (a * b) / НСД
    }

    public static void main(String[] args) {
        // Перевіряємо чи передані 2 аргументи
        if (args.length != 2) {
            System.out.println("Please provide exactly 2 integers as arguments.");
            return;
        }

        try {
            // Зчитуємо аргументи як цілі числа
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            if (num1 <= 0 || num2 <= 0) {
                System.out.println("Please provide positive integers.");
                return;
            }

            // Обчислюємо НСД та НСК
            int gcdResult = gcd(num1, num2);
            int lcmResult = lcm(num1, num2);

            // Виводимо результат
            System.out.println("Greatest Common Divisor (GCD) of " + num1 + " and " + num2 + " is: " + gcdResult);
            System.out.println("Least Common Multiple (LCM) of " + num1 + " and " + num2 + " is: " + lcmResult);

        } catch (NumberFormatException e) {
            System.out.println("Please provide valid integers.");
        }
    }
}
