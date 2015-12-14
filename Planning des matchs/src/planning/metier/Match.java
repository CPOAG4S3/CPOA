package planning.metier;

import java.util.Date;

public class Match {
   private String typeMatch;
   private Date heure;
   private String niveau;
   private int numMatch;
   
   public Match(String p_typeMatch, Date p_plage_horaire) {
  	/*if (p_typeMatch.equals("Simple")||p_typeMatch.equals("Double")){
        //TODO: Qualifaction, 16ème/8ème/Quart/Demi finale et Big Match (Autant pour simple que pour double)    
        } */
        typeMatch = p_typeMatch;
        heure = p_plage_horaire;
        //TODO: A finir !!!
        
   }
  
   public String getTypeMatch() {
  	return typeMatch;
   }
   public String getNiveau() {
  	return niveau;
   }
   public int getNumMatch() {
  	return numMatch;
   }
   public Date getHeure() {
    	return heure;
   }
}

