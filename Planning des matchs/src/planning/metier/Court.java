package planning.metier;

public class Court {
    String typeCourt, nomCourt;
    
    public Court(String p_typeCourt, String p_nomCourt){ //Quel type existe ?
        typeCourt = p_typeCourt;
        nomCourt = p_nomCourt;
    }

    public String getTypeCourt() {
        return typeCourt;
    }
    public String getNomCourt() {
        return nomCourt;
    }

    @Override
    public String toString() {
        return "Court " + typeCourt + " " + nomCourt;
    }
}
