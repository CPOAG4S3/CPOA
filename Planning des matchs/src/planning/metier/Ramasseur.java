package planning.metier;

public class Ramasseur {
    String num, nom, prenom;

    public Ramasseur(String num, String nom, String prenom) {
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNum() {
        return num;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public String toString() {
        return "Ramasseur: " + "num = " + num + ", nom = " + nom + ", prénom=" + prenom + '}';
    }
    
}
