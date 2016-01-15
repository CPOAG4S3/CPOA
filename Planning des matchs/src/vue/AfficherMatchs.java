package vue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import planning.dao.IJoueurDAO;
import planning.dao.oracle.OracleDataSourceDAO;
import planning.dao.IMatchDAO;
import planning.dao.oracle.OracleJoueurDAO;
import planning.dao.oracle.OracleMatchDAO;
import planning.metier.Match;


public class AfficherMatchs extends javax.swing.JFrame {
    private static OracleDataSourceDAO dataSourceDAO;
    private static OracleDataSourceDAO dataSourceDAO2;
    private static IMatchDAO matchDAO;
    private static IJoueurDAO joueurDAO;
    private static Connection connexionBD;
    
    private static String[] stringMatchsSimpleCent;
    private static String[] stringMatchsSimpleAnnexe = {""};
    private static String[] stringMatchsSimpleEnt = {""};
    
    public static String[] remplirListe(String typeMatch, String niveau, String nomCourt) { //Méthode pour afficher la liste des matchs prévus.
        try{
           dataSourceDAO = OracleDataSourceDAO.getOracleDataSourceDAO();
           matchDAO = new OracleMatchDAO();
           matchDAO.setDataSource(dataSourceDAO);
           connexionBD = dataSourceDAO.getConnection();
           matchDAO.setConnection(connexionBD);
        }
        catch(SQLException ex){
        }
        List<Match> listeMatchs = matchDAO.getLesMatchs(typeMatch, niveau, nomCourt);
        String stringMatchs[] = new String[listeMatchs.size()];
        int i = 0;
        for (Match m : listeMatchs){
            setConnexionJoueur();
            stringMatchs[i] = "" 
                    + joueurDAO.OracleJoueurDAO(m.getParticipant1()).getPrenom() + " "
                    + joueurDAO.OracleJoueurDAO(m.getParticipant1()).getNom() + " vs " 
                    + joueurDAO.OracleJoueurDAO(m.getParticipant2()).getPrenom() + " "
                    + joueurDAO.OracleJoueurDAO(m.getParticipant2()).getNom() + " Le "
                    + m.getHoraire();
            i++;
        }
        return stringMatchs;
    }
    
    public AfficherMatchs() {
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelActMatchs = new javax.swing.JPanel();
        jPanelActSimple = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNiveauTournoi = new javax.swing.JTextField();
        jTabbedPaneActSimple = new javax.swing.JTabbedPane();
        jPanelCourtCentSimple = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSimpleCentral = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemPtJoueurs = new javax.swing.JMenuItem();
        jMenuItemPtResponsable = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemActSimple = new javax.swing.JMenuItem();
        jMenuItemActDouble = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemModSimple = new javax.swing.JMenuItem();
        jMenuItemModDouble = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Liste des matchs de ");

        jTextFieldNiveauTournoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldNiveauTournoi.setText("16ème de finale");

        jListSimpleCentral.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = stringMatchsSimpleCent;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListSimpleCentral);

        javax.swing.GroupLayout jPanelCourtCentSimpleLayout = new javax.swing.GroupLayout(jPanelCourtCentSimple);
        jPanelCourtCentSimple.setLayout(jPanelCourtCentSimpleLayout);
        jPanelCourtCentSimpleLayout.setHorizontalGroup(
            jPanelCourtCentSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCourtCentSimpleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE))
        );
        jPanelCourtCentSimpleLayout.setVerticalGroup(
            jPanelCourtCentSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCourtCentSimpleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPaneActSimple.addTab("Court Central Philippe-Chartier", jPanelCourtCentSimple);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jTabbedPaneActSimple.addTab("Court annexe Suzanne-Lenglen", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jTabbedPaneActSimple.addTab("Court d'entrainement n°1", jPanel4);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("pour le tournoi Simple");

        javax.swing.GroupLayout jPanelActSimpleLayout = new javax.swing.GroupLayout(jPanelActSimple);
        jPanelActSimple.setLayout(jPanelActSimpleLayout);
        jPanelActSimpleLayout.setHorizontalGroup(
            jPanelActSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActSimpleLayout.createSequentialGroup()
                .addGroup(jPanelActSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelActSimpleLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1))
                    .addGroup(jPanelActSimpleLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNiveauTournoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jTabbedPaneActSimple, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelActSimpleLayout.setVerticalGroup(
            jPanelActSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActSimpleLayout.createSequentialGroup()
                .addGroup(jPanelActSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNiveauTournoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneActSimple, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(411, 411, 411))
        );

        javax.swing.GroupLayout jPanelActMatchsLayout = new javax.swing.GroupLayout(jPanelActMatchs);
        jPanelActMatchs.setLayout(jPanelActMatchsLayout);
        jPanelActMatchsLayout.setHorizontalGroup(
            jPanelActMatchsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
            .addGroup(jPanelActMatchsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelActMatchsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelActSimple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelActMatchsLayout.setVerticalGroup(
            jPanelActMatchsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
            .addGroup(jPanelActMatchsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelActMatchsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelActSimple, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jMenu1.setText("Mode");

        jMenuItemPtJoueurs.setText("Partie pour Joueur");
        jMenu1.add(jMenuItemPtJoueurs);

        jMenuItemPtResponsable.setText("Partie pour le Responsable des matchs");
        jMenu1.add(jMenuItemPtResponsable);

        jMenuBar.add(jMenu1);

        jMenu2.setText("Actualiser les matchs");

        jMenuItemActSimple.setText("Matchs Simple");
        jMenuItemActSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActSimpleActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemActSimple);

        jMenuItemActDouble.setText("Match Double");
        jMenuItemActDouble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActDoubleActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemActDouble);

        jMenuBar.add(jMenu2);

        jMenu3.setText("Modifier un match");

        jMenuItemModSimple.setText("Match Simple");
        jMenu3.add(jMenuItemModSimple);

        jMenuItemModDouble.setText("Match Double");
        jMenuItemModDouble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModDoubleActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemModDouble);

        jMenuBar.add(jMenu3);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelActMatchs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelActMatchs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 442, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemActDoubleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActDoubleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemActDoubleActionPerformed

    private void jMenuItemModDoubleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModDoubleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemModDoubleActionPerformed

    private void jMenuItemActSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActSimpleActionPerformed
        //.add(jPanelActSimple);
    }//GEN-LAST:event_jMenuItemActSimpleActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AfficherMatchs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AfficherMatchs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AfficherMatchs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfficherMatchs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        stringMatchsSimpleCent = remplirListe("simple", "16eme", "Philippe-Chatrier");
        //stringMatchsSimpleAnnexe = remplirListe("simple", "16eme", "Suzanne-Lenglen");
        //stringMatchsSimpleEnt = remplirListe("simple", "16eme", "n°");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AfficherMatchs().setVisible(true);
            }
        });
    }
    public static void setConnexionJoueur(){
      try{
          dataSourceDAO2 = OracleDataSourceDAO.getOracleDataSourceDAO();
          joueurDAO = new OracleJoueurDAO();
          joueurDAO.setDataSource(dataSourceDAO2);
          connexionBD = dataSourceDAO.getConnection();
          joueurDAO.setConnection(connexionBD);
       }
       catch(SQLException ex){
       }
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jListSimpleCentral;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemActDouble;
    private javax.swing.JMenuItem jMenuItemActSimple;
    private javax.swing.JMenuItem jMenuItemModDouble;
    private javax.swing.JMenuItem jMenuItemModSimple;
    private javax.swing.JMenuItem jMenuItemPtJoueurs;
    private javax.swing.JMenuItem jMenuItemPtResponsable;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelActMatchs;
    private javax.swing.JPanel jPanelActSimple;
    private javax.swing.JPanel jPanelCourtCentSimple;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneActSimple;
    private javax.swing.JTextField jTextFieldNiveauTournoi;
    // End of variables declaration//GEN-END:variables
}
