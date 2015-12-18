package planning.metier;

public class EquipeRamasseur {
    private String numEquipe, Ramasseur1, Ramasseur2, Ramasseur3, Ramasseur4, Ramasseur5, Ramasseur6;

    public EquipeRamasseur(String numEquipe, String Ramasseur1, String Ramasseur2, String Ramasseur3, String Ramasseur4, String Ramasseur5, String Ramasseur6) {
        this.numEquipe = numEquipe;
        this.Ramasseur1 = Ramasseur1;
        this.Ramasseur2 = Ramasseur2;
        this.Ramasseur3 = Ramasseur3;
        this.Ramasseur4 = Ramasseur4;
        this.Ramasseur5 = Ramasseur5;
        this.Ramasseur6 = Ramasseur6;
    }

    public String getNumEquipe() {
        return numEquipe;
    }
    public String getRamasseur1() {
        return Ramasseur1;
    }
    public String getRamasseur2() {
        return Ramasseur2;
    }
    public String getRamasseur3() {
        return Ramasseur3;
    }
    public String getRamasseur4() {
        return Ramasseur4;
    }
    public String getRamasseur5() {
        return Ramasseur5;
    }
    public String getRamasseur6() {
        return Ramasseur6;
    }
   
}
