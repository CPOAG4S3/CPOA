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
    private static String niveauSimple = "16eme";
    private static String niveauDouble = "16eme";
    
    /*tableau de String pour chaque liste qui permet d'afficher les Matchs simple */
    private static String[] stringMatchsSimpleCent = {""};
    private static String[] stringMatchsSimpleAnnexe = {""};
    private static String[] stringMatchsSimpleEnt = {""};
    
    /*tableau de String pour chaque liste qui permet d'afficher les Matchs double */
    private static String[] stringMatchsDoubleCent = {""};
    private static String[] stringMatchsDoubleAnnexe = {""};
    private static String[] stringMatchsDoubleEnt = {""};
    
    private static String nomJoueur1 = "", nomJoueur2 = "";
    public AfficherMatchs() {
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameIndiquerGagnant = new javax.swing.JFrame();
        jLabel6 = new javax.swing.JLabel();
        jButtonJ1 = new javax.swing.JButton();
        jButtonJ2 = new javax.swing.JButton();
        jFrame2 = new javax.swing.JFrame();
        jTabbedPaneMatchsAct = new javax.swing.JTabbedPane();
        jPanelActSimple = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNiveauTournoi = new javax.swing.JTextField();
        jTabbedPaneActSimple = new javax.swing.JTabbedPane();
        jPanelCourtCentSimple = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSimpleCentral = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListSimpleAnnexe = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListSimpleEnt = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jPanelMatchsActDouble = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNiveauTournoi1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPaneDoubleAct = new javax.swing.JTabbedPane();
        jPanelDoubleCent = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuMode = new javax.swing.JMenu();
        jMenuItemPtJoueurs = new javax.swing.JMenuItem();
        jMenuItemPtResponsable = new javax.swing.JMenuItem();
        jMenuActMAtchs = new javax.swing.JMenu();
        jMenuModifierMatch = new javax.swing.JMenu();
        jMenuItemModSimple = new javax.swing.JMenuItem();
        jMenuItemModDouble = new javax.swing.JMenuItem();

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Séléctionnez le nom du gagnant du match");

        jButtonJ1.setText(nomJoueur1);

        jButtonJ2.setText(nomJoueur2);

        javax.swing.GroupLayout jFrameIndiquerGagnantLayout = new javax.swing.GroupLayout(jFrameIndiquerGagnant.getContentPane());
        jFrameIndiquerGagnant.getContentPane().setLayout(jFrameIndiquerGagnantLayout);
        jFrameIndiquerGagnantLayout.setHorizontalGroup(
            jFrameIndiquerGagnantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameIndiquerGagnantLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jFrameIndiquerGagnantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrameIndiquerGagnantLayout.createSequentialGroup()
                        .addComponent(jButtonJ1)
                        .addGap(92, 92, 92)
                        .addComponent(jButtonJ2))
                    .addComponent(jLabel6))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jFrameIndiquerGagnantLayout.setVerticalGroup(
            jFrameIndiquerGagnantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameIndiquerGagnantLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jFrameIndiquerGagnantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonJ1)
                    .addComponent(jButtonJ2))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

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
        jListSimpleCentral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSimpleCentralMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListSimpleCentral);

        javax.swing.GroupLayout jPanelCourtCentSimpleLayout = new javax.swing.GroupLayout(jPanelCourtCentSimple);
        jPanelCourtCentSimple.setLayout(jPanelCourtCentSimpleLayout);
        jPanelCourtCentSimpleLayout.setHorizontalGroup(
            jPanelCourtCentSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCourtCentSimpleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCourtCentSimpleLayout.setVerticalGroup(
            jPanelCourtCentSimpleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCourtCentSimpleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPaneActSimple.addTab("Court Central Philippe-Chatrier", jPanelCourtCentSimple);

        jListSimpleAnnexe.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = stringMatchsSimpleAnnexe;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListSimpleAnnexe);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneActSimple.addTab("Court annexe Suzanne-Lenglen", jPanel3);

        jListSimpleEnt.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = stringMatchsSimpleEnt;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i];}
        });
        jScrollPane3.setViewportView(jListSimpleEnt);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPaneActSimple)
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

        jTabbedPaneMatchsAct.addTab("Matchs Simple", jPanelActSimple);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Liste des matchs de ");

        jTextFieldNiveauTournoi1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldNiveauTournoi1.setText("16ème de finale");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("pour le tournoi Double");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = stringMatchsDoubleCent;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i];}
        });
        jScrollPane4.setViewportView(jList1);

        javax.swing.GroupLayout jPanelDoubleCentLayout = new javax.swing.GroupLayout(jPanelDoubleCent);
        jPanelDoubleCent.setLayout(jPanelDoubleCentLayout);
        jPanelDoubleCentLayout.setHorizontalGroup(
            jPanelDoubleCentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDoubleCentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE))
        );
        jPanelDoubleCentLayout.setVerticalGroup(
            jPanelDoubleCentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDoubleCentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneDoubleAct.addTab("Court Central Philippe-Chatrier", jPanelDoubleCent);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = stringMatchsDoubleAnnexe;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i];}
        });
        jScrollPane5.setViewportView(jList2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneDoubleAct.addTab("Court Annexe", jPanel2);

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = stringMatchsDoubleEnt;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i];}
        });
        jScrollPane6.setViewportView(jList3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPaneDoubleAct.addTab("Court Entrainement n°1", jPanel5);

        javax.swing.GroupLayout jPanelMatchsActDoubleLayout = new javax.swing.GroupLayout(jPanelMatchsActDouble);
        jPanelMatchsActDouble.setLayout(jPanelMatchsActDoubleLayout);
        jPanelMatchsActDoubleLayout.setHorizontalGroup(
            jPanelMatchsActDoubleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMatchsActDoubleLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNiveauTournoi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jTabbedPaneDoubleAct)
        );
        jPanelMatchsActDoubleLayout.setVerticalGroup(
            jPanelMatchsActDoubleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMatchsActDoubleLayout.createSequentialGroup()
                .addGroup(jPanelMatchsActDoubleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNiveauTournoi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneDoubleAct)
                .addContainerGap())
        );

        jTabbedPaneMatchsAct.addTab("Matchs Double", jPanelMatchsActDouble);

        jMenuMode.setText("Mode");

        jMenuItemPtJoueurs.setText("Partie pour Joueur");
        jMenuMode.add(jMenuItemPtJoueurs);

        jMenuItemPtResponsable.setText("Partie pour le Responsable des matchs");
        jMenuMode.add(jMenuItemPtResponsable);

        jMenuBar.add(jMenuMode);

        jMenuActMAtchs.setText("Actualiser les matchs");
        jMenuBar.add(jMenuActMAtchs);

        jMenuModifierMatch.setText("Modifier un match");

        jMenuItemModSimple.setText("Match Simple");
        jMenuModifierMatch.add(jMenuItemModSimple);

        jMenuItemModDouble.setText("Match Double");
        jMenuItemModDouble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModDoubleActionPerformed(evt);
            }
        });
        jMenuModifierMatch.add(jMenuItemModDouble);

        jMenuBar.add(jMenuModifierMatch);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneMatchsAct)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneMatchsAct, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 358, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemModDoubleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModDoubleActionPerformed

    }//GEN-LAST:event_jMenuItemModDoubleActionPerformed

    private void jListSimpleCentralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSimpleCentralMouseClicked
        int numMatch = jListSimpleCentral.getAnchorSelectionIndex();
        indiquerGagnantSimple(numMatch, "simple", niveauSimple, "Philippe-Chatrier");
    }//GEN-LAST:event_jListSimpleCentralMouseClicked

    public static void main(String args[]) {
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
         //Variable qui doit être modifiée en fonction du niveau actuel pour chaque tournoi.
        
        /* Remplissable des tableau de String a l'aide de la fonction crée */
        stringMatchsSimpleCent = remplirListe("simple", niveauSimple, "Philippe-Chatrier");
        stringMatchsSimpleAnnexe = remplirListe("simple", niveauSimple, "Suzanne-Lenglen");
        stringMatchsSimpleEnt = remplirListe("simple", niveauSimple, "n°1");
        
        stringMatchsDoubleCent = remplirListe("double", niveauDouble, "Philippe-Chatrier");
        stringMatchsSimpleAnnexe = remplirListe("double", niveauDouble, "Suzanne-Lenglen");
        stringMatchsSimpleEnt = remplirListe("double", niveauDouble, "n°1");
      
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
    private javax.swing.JButton jButtonJ1;
    private javax.swing.JButton jButtonJ2;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrameIndiquerGagnant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jListSimpleAnnexe;
    private javax.swing.JList<String> jListSimpleCentral;
    private javax.swing.JList<String> jListSimpleEnt;
    private javax.swing.JMenu jMenuActMAtchs;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemModDouble;
    private javax.swing.JMenuItem jMenuItemModSimple;
    private javax.swing.JMenuItem jMenuItemPtJoueurs;
    private javax.swing.JMenuItem jMenuItemPtResponsable;
    private javax.swing.JMenu jMenuMode;
    private javax.swing.JMenu jMenuModifierMatch;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelActSimple;
    private javax.swing.JPanel jPanelCourtCentSimple;
    private javax.swing.JPanel jPanelDoubleCent;
    private javax.swing.JPanel jPanelMatchsActDouble;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPaneActSimple;
    private javax.swing.JTabbedPane jTabbedPaneDoubleAct;
    private javax.swing.JTabbedPane jTabbedPaneMatchsAct;
    private javax.swing.JTextField jTextFieldNiveauTournoi;
    private javax.swing.JTextField jTextFieldNiveauTournoi1;
    // End of variables declaration//GEN-END:variables

    
    /* Méthode qui récupère chaque match encore non joué, 
       en fonction d'un niveau, d'un type de match et d'un court particulier*/
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
    
    /* Méthode qui permet de mettre à jour le match séléctionné dans la liste avec le nom du joueur gagnant */
    private void indiquerGagnantSimple(int numMatch, String typeMatch, String niveau, String nomCourt) {
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
        Match matchAModifier = listeMatchs.get(numMatch);
        nomJoueur1 = matchAModifier.getParticipant1();
        nomJoueur2 = matchAModifier.getParticipant2();
        jFrameIndiquerGagnant.setVisible(true);
        jFrameIndiquerGagnant.setSize(20, 10);
        
    }
}
