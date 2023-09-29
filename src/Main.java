import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner src = new Scanner(System.in);
        System.out.println("Input:");
        String str = src.nextLine();
        ExpressionParser parser = new ExpressionParser();
        ExpressionModel model = parser.parseExpression(str);
        String result = Calculater.calculate(model);
        System.out.println("Output:");
        System.out.println(result);
    }
}
