package planning.metier;

public class Joueur {
    String numLicence, nom, prenom;
    
    public Joueur(String p_numLicence, String p_nom, String p_prenom){
        numLicence = p_numLicence;
        nom = p_nom;
        prenom = p_prenom;
    }
       
    public String getNumLicence() {
        return numLicence;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }   

    @Override
    public String toString() {
        return "Joueur num: " + numLicence + ", Nom: " + nom + ", Prenom: " + prenom;
    }
    
}
