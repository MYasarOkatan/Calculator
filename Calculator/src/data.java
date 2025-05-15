import java.sql.SQLException;

public class data {
    public static void main(String[] args) throws SQLException {

    }
    private double number;
    private String sign;
    private final int order;

    public int getOrder() {
        return this.order;
    }
    public data(double number, String sign, int order) {
        this.number = number;
        this.sign = sign;
        this.order=order;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number, double number1) {
        this.number = number1;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
