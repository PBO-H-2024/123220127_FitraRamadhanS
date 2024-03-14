package BangunRuang;
import BangunDatar.Lingkaran;

public class Tabung extends Lingkaran implements BangunRuang{
    double tinggiTabung;
    public Tabung(double jari2, double tinggiTabung){
        super(jari2);
        this.tinggiTabung = tinggiTabung;
    }

    public double volume(){
        return luas() * tinggiTabung;
    }

    public double luasPermukaan(){
        return 2 * luas() + keliling() * tinggiTabung;
    }
}
