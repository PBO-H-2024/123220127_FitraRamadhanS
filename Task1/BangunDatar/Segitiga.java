package BangunDatar;

public class Segitiga implements BangunDatar {
    double tinggiAlas, alas;

    public Segitiga(double tinggiAlas, double alas){
        this.tinggiAlas = tinggiAlas;
        this.alas = alas;
    }

    public double luas(){
        return alas * tinggiAlas / 2.0;
    }

    public double keliling(){
        double sisimiring = Math.sqrt((1.0/2.0*(alas) * 1.0/2.0*(alas)) +  (tinggiAlas * tinggiAlas));
        return (2 * sisimiring) + alas; //asumsi segitiga sama kaki
    };
}
