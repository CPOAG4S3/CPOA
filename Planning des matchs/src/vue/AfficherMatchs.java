package vue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import planning.dao.oracle.OracleDataSourceDAO;
import planning.dao.IMatchDAO;
import planning.dao.oracle.OracleJoueurDAO;
import planning.dao.oracle.OracleMatchDAO;
import planning.metier.Joueur;
import planning.metier.Match;


public class AfficherMatchs extends javax.swing.JFrame {
    private static OracleDataSourceDAO dataSourceDAO;
    private static IMatchDAO matchDAO;
    private static Connection connexionBD;
    
    public void remplirListeSimple(String nomCourt, String niveau, String typeMatch) {
        try{
           dataSourceDAO = OracleDataSourceDAO.getOracleDataSourceDAO();
           matchDAO = new OracleMatchDAO();
           matchDAO.setDataSource(dataSourceDAO);
           connexionBD = dataSourceDAO.getConnection();
           matchDAO.setConnection(connexionBD);
        }
        catch(SQLException ex){
        }
        List<Match> listeMatchs = matchDAO.getLesMatchs();
        stringJoueurs = new String[listeMatchs.size()];
        int i = 0;
        for (Match m : listeMatchs){
            stringJoueurs[i] = m.getParticipant1()+ " vs " + m.getParticipant2()+ " Le " + m.getHoraire();
            i++;
        }
    }
    
    private static String[] stringJoueurs;
    public AfficherMatchs() {
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNiveauTournoi = new javax.swing.JTextField();
        jTabbedPaneActSimple = new javax.swing.JTabbedPane();
        jPanelCourtCentSimple = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
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
        jLabel2.setText("Tournoi actuellement en ");

        jTextFieldNiveauTournoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldNiveauTournoi.setText("16ème de finale");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanelCourtCentSimpleLayout = new javax.swing.GroupLayout(jPanelCourtCentSimple);
        jPanelCourtCentSimple.setLayout(jPanelCourtCentSimpleLayout);
        jPanelCourtCentSimpleLayout.setHorizontalGroup(
            jPanelCourtCentSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCourtCentSimpleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(396, Short.MAX_VALUE))
        );
        jPanelCourtCentSimpleLayout.setVerticalGroup(
            jPanelCourtCentSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCourtCentSimpleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNiveauTournoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPaneActSimple, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNiveauTournoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneActSimple, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(411, 411, 411))
        );

        jMenu1.setText("Mode");

        jMenuItemPtJoueurs.setText("Partie pour Joueur");
        jMenu1.add(jMenuItemPtJoueurs);

        jMenuItemPtResponsable.setText("Partie pour le Responsable des matchs");
        jMenu1.add(jMenuItemPtResponsable);

        jMenuBar.add(jMenu1);

        jMenu2.setText("Actualiser les matchs");

        jMenuItemActSimple.setText("Matchs Simple");
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(453, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemActDoubleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActDoubleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemActDoubleActionPerformed

    private void jMenuItemModDoubleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModDoubleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemModDoubleActionPerformed

    /**
     * @param args the command line arguments
     */
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AfficherMatchs().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelCourtCentSimple;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneActSimple;
    private javax.swing.JTextField jTextFieldNiveauTournoi;
    // End of variables declaration//GEN-END:variables
}
