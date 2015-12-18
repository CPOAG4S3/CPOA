package planning.metier;

import java.util.Date;

public class Reservation {
    private String numReservation, typeMatch;
    private String equipeRamasseur1, equipeRamasseur2;
    private String nomCourt;
    private boolean reservation = false;
    private Date horaire;

    public Reservation(String numReservation, String typeMatch, String equipeRamasseur1, String equipeRamasseur2, String nomCourt, Date horaire) {
        this.numReservation = numReservation;
        this.typeMatch = typeMatch;
        this.equipeRamasseur1 = equipeRamasseur1;
        this.equipeRamasseur2 = equipeRamasseur2;
        this.nomCourt = nomCourt;
        this.horaire = horaire;
    }

    public String getNumReservation() {
        return numReservation;
    }
    public String getTypeMatch() {
        return typeMatch;
    }
    public String getEquipeRamasseur1() {
        return equipeRamasseur1;
    }
    public String getEquipeRamasseur2() {
        return equipeRamasseur2;
    }
    public String getNomCourt() {
        return nomCourt;
    }
    public boolean isReservation() {
        return reservation;
    }
    public Date getHoraire() {
        return horaire;
    }

    public void setReservation(boolean reservation) {
        this.reservation = reservation;
    }
}
