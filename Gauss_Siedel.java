import java.text.DecimalFormat;
import java.util.Scanner;


class Gauss_Siedel {

    private double x1, x2, x3;//değişkenlerin sonraki değerleri
    private double tolarenceValue; //tolerans değeri
    private double x1FirstValue, x2FirstValue, x3FirstValue;// Değişkenlerin ilk değeri
    private Scanner scan = new Scanner(System.in);//input değerleri
    private DecimalFormat frm = new DecimalFormat("#.####"); //Format 

    public Gauss_Siedel(double tolarenceValue, double x1FirstValue, double x2FirstValue, double x3FirstValue) {
        //Yapıcı Fonksiyonu
        this.tolarenceValue = tolarenceValue;
        this.x1FirstValue = x1FirstValue;
        this.x2FirstValue = x2FirstValue;
        this.x3FirstValue = x3FirstValue;
    }

    private double calculateX1(double x1, double x2, double x3) // x1'in hesaplanıdğı fonksiyon 
    {
        return (1 / 5.0) * (2 + x2 - 2 * x3);
        
        
    }

    private double calculateX2(double x1, double x2, double x3)//x2 'nin hesaplandığı fonksiyon
    {
        return (1 / 5.0) * (-2 + x1 + 2 * x3);
    }

    private double calculateX3(double x1, double x2, double x3) //x3 'nin hesaplandığı fonksiyon
    {
        return (1 / 4.0) * (4 + 2 * x1 - x2);
    }
    
    private int calculateTolarence() // Tolerans değeriğini hesaplayan method
    {
          x1 = calculateX1(x1FirstValue, x2FirstValue, x3FirstValue);
            if ((Math.abs(x1 - x1FirstValue)) <= tolarenceValue) {
                count++;
            }
            x1FirstValue = x1;
            x2 = calculateX2(x1FirstValue, x2FirstValue, x3FirstValue);
            if ((Math.abs(x2 - x2FirstValue)) <= tolarenceValue) {
                count++;
            }
            x2FirstValue = x2;
            x3 = calculateX3(x1FirstValue, x2FirstValue, x3FirstValue);
            if ((Math.abs(x3 - x3FirstValue)) <= tolarenceValue) {
                count++;
            }
            x3FirstValue = x3;
            return count;
    }

     public void calculateGaussSiedel() //Gauss Siedel methodunu iterasyonu
     {
        int iterationCounter = 1, tolarenceCounter = 0;
        while (true) {
          tolarenceCounter= calculateTolarence();
            if (tolarenceCounter == 3) {
                break;
            } else {
                tolarenceCounter = 0;
                System.out.println(iterationCounter + ".iteration:\n" + "x1: " + frm.format(x1) + "\t\t" + "x2: " + frm.format(x2) + "\t\t" + " x3: " + frm.format(x3));
                iterationCounter++;
            }

        }
    }

}
