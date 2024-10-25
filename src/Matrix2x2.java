public class Matrix2x2 {
    private double[][] matrix;

    // Конструктор для ініціалізації матриці
    public Matrix2x2(double a, double b, double c, double d) {
        matrix = new double[2][2];
        matrix[0][0] = a;
        matrix[0][1] = b;
        matrix[1][0] = c;
        matrix[1][1] = d;
    }

    // Метод для знаходження детермінанту
    public double determinant() {
        return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    }

    // Метод для знаходження оберненої матриці
    public Matrix2x2 inverse() {
        double det = determinant();
        if (det == 0) {
            throw new ArithmeticException("Matrix has no inverse (determinant is zero)");
        }

        // Обчислення оберненої матриці
        return new Matrix2x2(matrix[1][1] / det, -matrix[0][1] / det,
                             -matrix[1][0] / det, matrix[0][0] / det);
    }

    // Метод для множення на іншу матрицю
    public Matrix2x2 multiply(Matrix2x2 other) {
        double a = this.matrix[0][0] * other.matrix[0][0] + this.matrix[0][1] * other.matrix[1][0];
        double b = this.matrix[0][0] * other.matrix[0][1] + this.matrix[0][1] * other.matrix[1][1];
        double c = this.matrix[1][0] * other.matrix[0][0] + this.matrix[1][1] * other.matrix[1][0];
        double d = this.matrix[1][0] * other.matrix[0][1] + this.matrix[1][1] * other.matrix[1][1];
        return new Matrix2x2(a, b, c, d);
    }

    // Метод для додавання іншої матриці
    public Matrix2x2 add(Matrix2x2 other) {
        double a = this.matrix[0][0] + other.matrix[0][0];
        double b = this.matrix[0][1] + other.matrix[0][1];
        double c = this.matrix[1][0] + other.matrix[1][0];
        double d = this.matrix[1][1] + other.matrix[1][1];
        return new Matrix2x2(a, b, c, d);
    }

    // Метод для множення матриці на число
    public Matrix2x2 multiplyByScalar(double scalar) {
        return new Matrix2x2(matrix[0][0] * scalar, matrix[0][1] * scalar,
                             matrix[1][0] * scalar, matrix[1][1] * scalar);
    }

    // Метод для виведення матриці у вигляді рядка
    @Override
    public String toString() {
        return "[" + matrix[0][0] + " " + matrix[0][1] + "]\n" + 
               "[" + matrix[1][0] + " " + matrix[1][1] + "]";
    }

    public static void main(String[] args) {
        // Приклад використання класу Matrix2x2
        Matrix2x2 m1 = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 m2 = new Matrix2x2(5, 6, 7, 8);

        System.out.println("Matrix m1:");
        System.out.println(m1);

        System.out.println("Matrix m2:");
        System.out.println(m2);

        System.out.println("Determinant of m1: " + m1.determinant());
        System.out.println("Inverse of m1: ");
        System.out.println(m1.inverse());

        System.out.println("m1 + m2:");
        System.out.println(m1.add(m2));

        System.out.println("m1 * m2:");
        System.out.println(m1.multiply(m2));

        System.out.println("m1 * 2 (scalar multiplication):");
        System.out.println(m1.multiplyByScalar(2));
    }
}
