package planning.metier;

public class Arbitre {
    String numArbitre, competences, nom, prenom; //TODO: Ajouter catégorie arbitre, mettre une condition dans le constructeur ?
    int nbArbitrageSimple, nbArbitrageDouble;
    
    public Arbitre(String p_numArbitre, String p_nom, String p_prenom, String p_competences){
        numArbitre  = p_numArbitre;
        competences = p_competences;
        nom         = p_nom;
        prenom      = p_prenom;
        nbArbitrageSimple = 0;
        nbArbitrageDouble = 0;
    }
    public Arbitre(String numArbitre, String competences, String nom, String prenom, int nbArbitrageSimple, int nbArbitrageDouble) { //Pour créer un élément dans une liste.
        this.numArbitre = numArbitre;
        this.competences = competences;
        this.nom = nom;
        this.prenom = prenom;
        this.nbArbitrageSimple = nbArbitrageSimple;
        this.nbArbitrageDouble = nbArbitrageDouble;
    }
    

    public void ajouterNbArbitrageSimple(){
        nbArbitrageSimple++;
    }
    public void ajouterNbArbitrageDouble(){
        nbArbitrageDouble++;
    }
    //public boolean  Pour verifier le nb d'arbtrage simple et double
    
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

    @Override
    public String toString() {
        return "Arbitre " + "num:" + numArbitre + ", competences: " + competences + ", nom: " + nom + ", prenom: " + prenom + ", nbArbitrageSimple: " + nbArbitrageSimple + ", nbArbitrageDouble:" + nbArbitrageDouble;
    }

    
}
