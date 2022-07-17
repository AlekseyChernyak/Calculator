
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //3
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                return;
            } else {
                String[] x = input.split(" ");
                if (x.length < 3)
                    throw new RuntimeException("строка не является математической операцией");
                if (x.length > 3)
                    throw new RuntimeException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                String result = calc(x[0], x[1], x[2]);
                System.out.println(result);
            }
        }
    }

    public static int parseRomeInt(String a) {
        if (a.equals("I")) return 1;
        if (a.equals("II")) return 2;
        if (a.equals("III")) return 3;
        if (a.equals("IV")) return 4;
        if (a.equals("V")) return 5;
        if (a.equals("VI")) return 6;
        if (a.equals("VII")) return 7;
        if (a.equals("VIII")) return 8;
        if (a.equals("IX")) return 9;
        if (a.equals("X")) return 10;

        throw new RuntimeException("Достигнуто макс. значение");
    }

    public static String convertToRoma(int num) {
        if (num <= 0)
            throw new RuntimeException(" римской системе нет отрицательных чисел");
        String ans = "";
        String[] symbol = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = {100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                num = num - value[i];
                ans += symbol[i];
            }
        }
        return ans;
    }

    public static String calc(String a, String operation, String b) {
        boolean isRoma = false;

        Integer numA = null;
        Integer numB = null;

        try {

            numA = Integer.parseInt(a);
            numB = Integer.parseInt(b);

        } catch (NumberFormatException e) {
            isRoma = true;
            if(numA!=null)
                throw new RuntimeException("используются одновременно разные системы счисления");
            numA = parseRomeInt(a);
            numB = parseRomeInt(b);
        }
        if (numA < 1 || numA > 10 || numB < 1 || numB > 10)
            throw new RuntimeException("Числа меньше 0 или больше 10");
        switch (operation) {
            case "+": {
                int result = numA + numB;
                if (isRoma) {
                    return convertToRoma(result);
                } else {
                    return String.valueOf(result);
                }
            }
            case "-": {
                int result = numA - numB;
                if (isRoma) {
                    return convertToRoma(result);
                } else {
                    return String.valueOf(result);
                }
            }
            case "*": {
                int result = numA * numB;
                if (isRoma) {
                    return convertToRoma(result);
                } else {
                    return String.valueOf(result);
                }
            }
            case "/": {
                int result = numA / numB;
                if (isRoma) {
                    return convertToRoma(result);
                } else {
                    return String.valueOf(result);
                }
            }
            default:
                throw new RuntimeException("т.к. строка не является математической операцией");
        }

    }

}