package BangunRuang;
import BangunDatar.Segitiga;

public class Limas extends Segitiga implements BangunRuang  {
    double tinggiLimas;
    public Limas(double tinggiAlas, double alas, double tinggiLimas) {
        super(tinggiAlas, alas);
        this.tinggiLimas = tinggiLimas;
    }

    public double volume(){
        return 1.0/3.0 * luas() * tinggiLimas;
    }

    public double luasPermukaan(){
        return 4 * luas() ; //asumsi segitiga sama sisi
    }
    
}
