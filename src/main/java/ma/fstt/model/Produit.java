package ma.fstt.model;

public class Produit {

    private String nompro ;

    private Float prix ;

    private String description ;

    public Produit() {
    }

    public Produit(String nompro, Float prix, String description) {
        this.nompro = nompro;
        this.prix = prix;
        this.description = description;
    }



    public String getNompro() {
        return nompro;
    }

    public void setNom(String nompro) {
        this.nompro = nompro;
    }
    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Produit{" +
                ", nompro=" + nompro + '\'' +
                "prix=" + prix + '\'' +
                ", description=" + description + '\'' +
                '}';
    }
}


