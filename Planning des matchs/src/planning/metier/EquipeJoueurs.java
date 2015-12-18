package planning.metier;

public class EquipeJoueurs {
    String numEquipe, joueur1, joueur2;

    public EquipeJoueurs(String numEquipe, String joueur1, String joueur2) {
        this.numEquipe = numEquipe;
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    public String getNumEquipe() {
        return numEquipe;
    }
    public String getJoueur1() {
        return joueur1;
    }
    public String getJoueur2() {
        return joueur2;
    }
}
