import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Orderofoperations {
    static dataOperate dataislem=new dataOperate();
    public void Orderofoperations() throws SQLException {
        ArrayList<data>datas=dataislem.dataarray();
        int i=0;
        while (i<datas.size()){
            if(Objects.equals(datas.get(i).getSign(), "/")){
                if(datas.get(i+1).getNumber()==0){
                    dataislem.alldelete();
                    dataislem.datainsert(0,"Division by zero is not allowed.");
                    break;
                }
                double result=Division(datas.get(i).getNumber(),datas.get(i+1).getNumber());
                dataislem.datadelete(datas.get(i).getOrder());
                dataislem.dataupdate(result,datas.get(i+1).getOrder());
                datas=dataislem.dataarray();
                i=-1;
            }
            i++;
        }
        i=0;
        while (i<datas.size()){
            if(Objects.equals(datas.get(i).getSign(), "*")){
             double result=Multiplication (datas.get(i).getNumber(),datas.get(i+1).getNumber());
             dataislem.datadelete(datas.get(i).getOrder());
             dataislem.dataupdate(result,datas.get(i+1).getOrder());
             datas=dataislem.dataarray();
             i=-1;
            }
            i++;
        }
        i=0;
        while (i<datas.size()){
            System.out.println(datas.get(i).getNumber());
            if(Objects.equals(datas.get(i).getSign(), "+")){
                double result=Addition(datas.get(i).getNumber(),datas.get(i+1).getNumber());
                dataislem.datadelete(datas.get(i).getOrder());
                dataislem.dataupdate(result,datas.get(i+1).getOrder());
                datas=dataislem.dataarray();
                i=-1;
            }
            i++;
        }
        i=0;
        while (i<datas.size()){
            if(Objects.equals(datas.get(i).getSign(), "-")){
                double result=Subtraction(datas.get(i).getNumber(),datas.get(i+1).getNumber());
                dataislem.datadelete(datas.get(i).getOrder());
                dataislem.dataupdate(result,datas.get(i+1).getOrder());
                datas=dataislem.dataarray();
                i=-1;
            }
            i++;
        }

    }
    public static double Addition(double a, double b) {
        return a+b;
    }

    public static double Multiplication(double a, double b) {
        return a*b;
    }

    public static double Division(double a, double b) {
        return a/b;
    }

    public static double Subtraction(double a, double b) {
        return a-b;
    }


}
