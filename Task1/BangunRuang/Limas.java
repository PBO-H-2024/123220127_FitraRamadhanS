package BangunRuang;
import BangunDatar.Segitiga;

public class Limas extends Segitiga implements BangunRuang  {
    public double tinggiLimas;
    public Limas(double a, double b, double c, double tinggiLimas) {
        super(a, b, c);
        this.tinggiLimas = tinggiLimas;
    }

    public double volume(){
        return 1.0/3.0 * luas() * tinggiLimas;
    }

    public double luasPermukaan(){
        return luas() + tinggiLimas / 2.0 * (a + b + c); 
    }
    
}
