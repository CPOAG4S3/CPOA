package planning.metier;

public class EquipeJoueurs {
    String numEquipe;
    Joueur joueur1, joueur2; //TODO: Utiliser l'objet ou l'identifiant ?
    
    public EquipeJoueurs(String p_numEquipe, Joueur p_joueur1, Joueur p_joueur2){
        //TODO: Gérer création du numéro de l'équipe ?
        numEquipe = p_numEquipe;
        joueur1 = p_joueur1;
        joueur2 = p_joueur2;
    }

    public String getNumEquipe() {
        return numEquipe;
    }
    public Joueur getJoueur1() {
        return joueur1;
    }
    public Joueur getJoueur2() {
        return joueur2;
    }
}
