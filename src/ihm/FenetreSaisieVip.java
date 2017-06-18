package ihm;

import application.Appli;
import data.DAOVip;
import metier.Role;
import metier.Statut;
import metier.Vip;
import modele.ModeleJComboCivilite;
import modele.ModeleJComboNationalite;

import java.sql.SQLException;
import java.time.ZoneId;


public class FenetreSaisieVip extends javax.swing.JDialog {

    private final Vip vip;
    private boolean etatSortie;
    private ModeleJComboNationalite modeleNationalite;
    private ModeleJComboCivilite modeleCivilite;
    private DAOVip leDaoVip;

    public FenetreSaisieVip(java.awt.Frame parent, Vip vip) {
        super(parent, true);  // mode modal 
        leDaoVip = Appli.getDaoVip();
        this.setLocation(parent.getLocation());
        this.vip = vip;
        etatSortie = false;

        try {
            modeleNationalite = new ModeleJComboNationalite();
            modeleCivilite = new ModeleJComboCivilite();
        } catch (SQLException se) {

        }

        initComponents();
        Appli.centreWindow(this);
    }

    public boolean doModal() {
        setVisible(true);
        return etatSortie;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        txtPrenom = new javax.swing.JTextField();
        txtLieuNaissance = new javax.swing.JTextField();
        btAjouter = new javax.swing.JButton();
        btAnnuler = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();
        cbCivilite = new javax.swing.JComboBox<>();
        cbRole = new javax.swing.JComboBox<>();
        dpNaissance = new org.jdesktop.swingx.JXDatePicker();
        cbNationalite = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Saisie d'un VIP");
        setResizable(false);
        setSize(new java.awt.Dimension(500, 400));

        jLabel1.setText("Insertion d'un VIP");

        jLabel2.setText("Nom");

        jLabel3.setText("Prénom");

        jLabel4.setText("Civilité");

        jLabel5.setText("Date de naissance");

        jLabel6.setText("Lieu de naissance");

        jLabel7.setText("Rôle");

        jLabel8.setText("Nationalité");

        btAjouter.setText("Ajouter le VIP");
        btAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjouterActionPerformed(evt);
            }
        });

        btAnnuler.setText("Annuler");
        btAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnnulerActionPerformed(evt);
            }
        });

        lblWarning.setForeground(new java.awt.Color(255, 0, 0));

        cbCivilite.setModel(modeleCivilite);
        cbCivilite.setSelectedIndex(0);

        cbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Acteur", "Réalisateur", "Acteur et réalisateur", "Autre"}));
        cbRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRoleActionPerformed(evt);
            }
        });

        cbNationalite.setModel(modeleNationalite);
        cbNationalite.setSelectedIndex(0);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8))
                                                .addGap(80, 80, 80)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblWarning)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(btAjouter)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                                                        .addComponent(btAnnuler))
                                                                .addComponent(txtNom)
                                                                .addComponent(txtPrenom)
                                                                .addComponent(txtLieuNaissance))
                                                        .addComponent(cbCivilite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dpNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbNationalite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(cbCivilite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(dpNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(txtLieuNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(cbNationalite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btAjouter)
                                        .addComponent(btAnnuler))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(lblWarning)
                                .addContainerGap())
        );

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
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRoleActionPerformed

    private void btAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAjouterActionPerformed
        // Vérification des données
        String nom = txtNom.getText();
        String prenom = txtPrenom.getText();
        String civilite = modeleCivilite.getElementAt(cbCivilite.getSelectedIndex());
        java.util.Date dateNaissance = dpNaissance.getDate();
        String lieuNaissance = txtLieuNaissance.getText();
        Role role;
        try {
            role = Vip.getRole(cbRole.getSelectedIndex() + 1);
        } catch (Exception e) {
            role = null;
        }
        String nationalite = modeleNationalite.getElementAt(cbNationalite.getSelectedIndex());

        String err = "";
        if (nom.equals("")) {
            err = "Nom invalide";
        } else if (prenom.equals("")) {
            err = "Prenom invalide";
        } else if (dateNaissance == null) {
            err = "Date de naissance invalide";
        } else if (lieuNaissance.equals("")) {
            err = "Lieu de naissance invalide";
        } else if (role == null) {
            err = "Role invalide";
        } else {
            // SAISIE OK
            vip.setNom(nom);
            vip.setStatut(Statut.LIBRE);
            vip.setPrenom(prenom);
            vip.setCivilite(civilite);
            vip.setDateNaissance(dateNaissance.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            vip.setLieuNaissance(lieuNaissance);
            vip.setRole(role);
            vip.setNationalite(nationalite);
            if (leDaoVip.insererVip(vip) == true) {
                etatSortie = true;
                this.dispose();
            } else {
                err = "Insertion dans la base impossible";
            }

        }

        lblWarning.setText(err);
    }//GEN-LAST:event_btAjouterActionPerformed

    private void btAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btAnnulerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAjouter;
    private javax.swing.JButton btAnnuler;
    private javax.swing.JComboBox<String> cbCivilite;
    private javax.swing.JComboBox<String> cbNationalite;
    private javax.swing.JComboBox<String> cbRole;
    private org.jdesktop.swingx.JXDatePicker dpNaissance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JTextField txtLieuNaissance;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPrenom;
    // End of variables declaration//GEN-END:variables
}
