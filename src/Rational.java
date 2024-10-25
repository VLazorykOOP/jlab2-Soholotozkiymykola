public class Rational {
    private int numerator;   // Чисельник
    private int denominator; // Знаменник

    // Конструктор
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce(); // Скорочення дробу
    }

    // Метод для додавання
    public Rational add(Rational other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    // Метод для віднімання
    public Rational subtract(Rational other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    // Метод для множення
    public Rational multiply(Rational other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    // Метод для ділення
    public Rational divide(Rational other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Rational(newNumerator, newDenominator);
    }

    // Метод для порівняння на рівність
    public boolean equals(Rational other) {
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    // Метод для порівняння більше/менше
    public int compareTo(Rational other) {
        int lhs = this.numerator * other.denominator;
        int rhs = other.numerator * this.denominator;
        return Integer.compare(lhs, rhs);
    }

    // Метод для скорочення дробу (reduce)
    private void reduce() {
        int gcd = gcd(java.lang.Math.abs(numerator), java.lang.Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;

        // Якщо знаменник від'ємний, переносимо знак у чисельник
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // Метод для знаходження найбільшого спільного дільника (НСД)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Метод для виведення у вигляді рядка
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(3, 4);

        System.out.println("r1 + r2 = " + r1.add(r2));
        System.out.println("r1 - r2 = " + r1.subtract(r2));
        System.out.println("r1 * r2 = " + r1.multiply(r2));
        System.out.println("r1 / r2 = " + r1.divide(r2));

        System.out.println("r1 equals r2: " + r1.equals(r2));
        System.out.println("r1 compareTo r2: " + r1.compareTo(r2));
    }
}
