package BangunRuang;
import BangunDatar.Segitiga;

public class Tabung extends Segitiga implements BangunRuang{
    double tinggiTabung;
    public Tabung(double jari2, double tinggiTabung){
        super(jari2, 22.0/7.0);
        this.tinggiTabung = tinggiTabung;
    }

    public double volume(){
        return luas() * tinggiTabung;
    }

    public double luasPermukaan(){
        return 2 * luas() + keliling() * tinggiTabung;
    }
}
