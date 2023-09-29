public class ExpressionParser {
    public ExpressionModel parseExpression(String input) throws Exception {
        ExpressionModel expression = new ExpressionModel();
        expression.setSign(getSign(input));
        String[] args = getArgs(input, expression.getSign());
        expression.setArg1(removeQuates(args[0].trim()));
        if (isArgumentIncorrect(args[1], expression.getSign()))
            throw new IllegalArgumentException();
        expression.setArg2(removeQuates(args[1].trim()));
        return expression;
    }
    public static String toResult(String text){
        return "\""+text+"\"";
    }
    private static char getSign(String input) throws Exception {
        if (input.contains("+")) {
            return '+';
        } else if (input.contains("-")) {
            return  '-';
        } else if (input.contains("*")) {
            return  '*';
        } else if (input.contains("/")) {
           return '/';
        }

        throw new Exception("Unexpected sign");
    }
    private static String[] getArgs(String input, char sign){
        var t1 =  "\\" + Character.toString(sign);
        var t2 = input.split(t1);
        return t2;
    }
    private static boolean isArgumentIncorrect(String arg, char sign){
        if ( sign == '*' || sign == '/'){
            return arg.contains("\"");
        }
        return !arg.contains("\"");
    }
    private static String removeQuates(String str){
        return str.replace("\"", "");
    }
}
