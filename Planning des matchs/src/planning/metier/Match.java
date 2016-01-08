package planning.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {
   private int numMatch;
   private Date horaire;
   private String niveau, typeMatch, nomCourtMatch;
   private String participant1 = "", participant2 = "", equipe1 = "", equipe2 = "";
   private String joueurGagnant, equipeGagnante;
   private String equipeRamasseur1, equipeRamasseur2;
   private String arbitreLigne1, arbitreLigne2, arbitreLigne3, arbitreLigne4, arbitreLigne5, arbitreLigne6;
   private String arbitreFilet, arbitreChaise;

   //Constructeur pour ajouter un match simple
    public Match(int numMatch, Date horaire, String niveau, String typeMatch, String nomCourtMatch, String membre1, String membre2, String equipeRamasseur1, String equipeRamasseur2, String arbitreLigne1, String arbitreLigne2, String arbitreLigne3, String arbitreLigne4, String arbitreLigne5, String arbitreLigne6, String arbitreFilet, String arbitreChaise) {
        this.numMatch = numMatch;
        this.horaire = horaire;
        this.niveau = niveau;
        this.typeMatch = typeMatch;
        this.nomCourtMatch = nomCourtMatch;
        this.equipeRamasseur1 = equipeRamasseur1;
        this.equipeRamasseur2 = equipeRamasseur2;
        this.arbitreLigne1 = arbitreLigne1;
        this.arbitreLigne2 = arbitreLigne2;
        this.arbitreLigne3 = arbitreLigne3;
        this.arbitreLigne4 = arbitreLigne4;
        this.arbitreLigne5 = arbitreLigne5;
        this.arbitreLigne6 = arbitreLigne6;
        this.arbitreFilet = arbitreFilet;
        this.arbitreChaise = arbitreChaise; //Vérifier et ajouter le nombre de matchs qu'il a arbitré (max 2 simple et 2 double
        if (typeMatch.equals("simple")){
            this.participant1 = membre1;
            this.participant2 = membre2;
        }
        else if (typeMatch.equals("double")){
            this.equipe1 = membre1;
            this.equipe2 = membre2;
        }
    }

    public int getNumMatch() {
        return numMatch;
    }
    public Date getHoraire() {
        return horaire;
    }
    public String getNiveau() {
        return niveau;
    }
    public String getTypeMatch() {
        return typeMatch;
    }
    public String getNomCourtMatch() {
        return nomCourtMatch;
    }
    public String getParticipant1() {
        return participant1;
    }
    public String getParticipant2() {
        return participant2;
    }
    public String getEquipe1() {
        return equipe1;
    }
    public String getEquipe2() {
        return equipe2;
    }
    public String getJoueurGagnant() {
        return joueurGagnant;
    }
    public String getEquipeGagnante() {
        return equipeGagnante;
    }
    public String getEquipeRamasseur1() {
        return equipeRamasseur1;
    }
    public String getEquipeRamasseur2() {
        return equipeRamasseur2;
    }
    public String getArbitreLigne1() {
        return arbitreLigne1;
    }
    public String getArbitreLigne2() {
        return arbitreLigne2;
    }
    public String getArbitreLigne3() {
        return arbitreLigne3;
    }
    public String getArbitreLigne4() {
        return arbitreLigne4;
    }
    public String getArbitreLigne5() {
        return arbitreLigne5;
    }
    public String getArbitreLigne6() {
        return arbitreLigne6;
    }
    public String getArbitreFilet() {
        return arbitreFilet;
    }
    public String getArbitreChaise() {
        return arbitreChaise;
    }
    public List<String> getLesArbitresDeLigne(){
        List<String> listeArbitresLigne = new ArrayList<>();
        listeArbitresLigne.add(arbitreLigne1);
        listeArbitresLigne.add(arbitreLigne2);
        listeArbitresLigne.add(arbitreLigne3);
        listeArbitresLigne.add(arbitreLigne4);
        listeArbitresLigne.add(arbitreLigne5);
        listeArbitresLigne.add(arbitreLigne6);
        return listeArbitresLigne;
    }
}
