package BangunDatar;

public class Segitiga implements BangunDatar {
    public double a, b, c;

    public Segitiga(double a, double b, double c){
        this.a = a;
        this.b = b; 
        this.c = c;
    }

    public double luas(){
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s-a) * (s-b) * (s-c)); 
    }

    public double keliling(){
        return a + b + c;
    };
}
