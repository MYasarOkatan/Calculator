import java.sql.SQLException;//1+2

public class Breakthenumber {
    static dataOperate dataislem=new dataOperate();
    public void breakTheNumber(String Expression) throws SQLException {
        dataislem.alldelete();
        int i = 0;
        String newexpression;
        String sing;
        while (i < Expression.length()) {
            if (Expression.charAt(i) == '*' || Expression.charAt(i) == '/' || Expression.charAt(i) == '+' || Expression.charAt(i) == '-') {
                newexpression = Expression.substring(0, i);
                sing= String.valueOf(Expression.charAt(i));
                Expression = Expression.substring(i + 1);
                separation(newexpression,sing);

                i = 0;
            }
            i++;
        }
        separation(Expression,"");


    }

    public void separation(String Expression,String sing) throws SQLException {
        boolean flag = true;
        double decimalpart = 0;
        double number = 0;
        int i = 0;
        int j ;
        int k = 0;
        int decimalexponent = -1;
        while (i < Expression.length()) {
            if (Expression.charAt(i) == '.') {
                flag = false;
                while (k < i) {
                    number = number * 10 + Double.parseDouble(String.valueOf(Expression.charAt(k)));
                    k++;
                }
                j = i + 1;
                while (j < Expression.length()) {
                    decimalpart = Double.parseDouble(String.valueOf(Expression.charAt(j))) * Math.pow(10, decimalexponent) + decimalpart;
                    decimalexponent--;
                    j++;
                }

            }
            i++;
        }
        if (flag) {
            while (k < Expression.length()) {
                number = number * 10 + Double.parseDouble(String.valueOf(Expression.charAt(k)));
                k++;

            }
        }
        number = number + decimalpart;
        dataislem.datainsert(number,sing);

    }
}

