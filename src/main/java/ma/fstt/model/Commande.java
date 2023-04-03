package ma.fstt.model;

public class Commande {
    private String datedebut ;

    private String datefin ;

    private Float km ;
    private String etat ;


    public Commande() {
    }

    public Commande(String datedebut,String datefin, Float km, String etat) {
        this.datedebut = datedebut;
        this.datefin = datefin;

        this.km = km;
        this.etat =etat;
    }



    public String Datedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String Datefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }
    public Float getKm() {
        return km;
    }

    public void setKm(Float km) {
        this.km = km;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Commande{" +
                ", datedebut=" + datedebut + '\'' +
                ", datefin=" + datefin + '\'' +

                "km=" + km + '\'' +
                ", etat=" + etat + '\'' +
                '}';
    }

}
