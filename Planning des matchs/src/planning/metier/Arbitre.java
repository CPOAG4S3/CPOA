package planning.metier;

public class Arbitre {
    String numArbitre, competences, nom, prenom; //TODO: Ajouter catégorie arbitre, mettre une condition dans le constructeur ?
    int nbArbitrageSimple, nbArbitrageDouble;
    
    public Arbitre(String p_numArbitre, String p_competences, String p_nom, String p_prenom){
        numArbitre = p_numArbitre;
        competences = p_competences;
        nom = p_nom;
        prenom = p_prenom;
        nbArbitrageSimple = 0;
        nbArbitrageDouble = 0;
    }

    public void ajouterNbArbitrageSimple(){
        nbArbitrageSimple++;
    }
    public void ajouterNbArbitrageDouble(){
        nbArbitrageDouble++;
    }
    
    /* Getters */
    public String getNumArbitre() {
        return numArbitre;
    }
    public String getCompetences() {
        return competences;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public int getNbArbitrageSimple() {
        return nbArbitrageSimple;
    }
    public int getNbArbitrageDouble() {
        return nbArbitrageDouble;
    }    
}
