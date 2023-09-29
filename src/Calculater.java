public class Calculater {
    public static String calculate(ExpressionModel expression){
        switch (expression.getSign()){
            case '+':
                return ExpressionParser.toResult(expression.getArg1().concat(expression.getArg2()));
            case '-':
                return subtraction(expression.getArg1(), expression.getArg2());
            case '*':
                return multiply(expression.getArg1(), expression.getArg2());
            case '/':
                return division(expression.getArg1(), expression.getArg2());
            default:
                throw new IllegalArgumentException();
        }
    }
    private static String subtraction(String arg1,String arg2) {
        if (!arg1.contains(arg2))
            return arg1;

        int index = arg1.indexOf(arg2);
        String result = arg1.substring(0, index);
        result += arg1.substring(index +arg2.length());
        return ExpressionParser.toResult(result);
    }
    private static String multiply(String arg1,String arg2){
        String result = "";
        int loopCount = Integer.parseInt(arg2);
        for (int i = 0; i < loopCount; i++){
            result = result.concat(arg1);
        }

        return ExpressionParser.toResult(result);
    }
    private static String division(String arg1,String arg2){
        int num = Integer.parseInt(arg2);
        return arg1.substring(0, num);
    }
}
