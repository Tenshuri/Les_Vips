package ihm;

import application.Appli;
import metier.Statut;
import metier.Vip;
import modele.ModeleJComboBoxMariage;

import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FenetreMariageVIP extends javax.swing.JDialog {

    private Vip vip;
    private LocalDate dateMariage;
    private int numero;
    private boolean etatSortie;
    private ModeleJComboBoxMariage leModele;

    public FenetreMariageVIP(java.awt.Frame parent, int numero) {

        super(parent, true);  // mode modal 
        this.setLocation(parent.getLocation());
        this.numero = numero;
        etatSortie = false;

        try {
            leModele = new ModeleJComboBoxMariage(numero);
        } catch (Exception ex) {
            Logger.getLogger(FenetreMariageVIP.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        try {
            boxVip.setSelectedIndex(0);
            vip = Appli.getDaoVip().lireUnVipMariage(numero);
            dateMariage = Appli.getDaoMariages().getDateMariageEnCours(numero);
            txtNom.setText(vip.getNom());
            System.out.println(dateMariage);
            txtPrenom.setText(vip.getPrenom());

            Statut statut = vip.getStatut();
            txtStatut.setText(Vip.statutToString(statut));

            if (vip.getStatut() == Statut.LIBRE) {
                btnMariage.setEnabled(true);
                datePickerM.setEnabled(true);
                txtLieuMariage.setEnabled(true);
                boxVip.setEnabled(true);

            } else if (vip.getStatut() == Statut.MARIE) {
                btnDivorce.setEnabled(true);
                datePickerD.setEnabled(true);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean doModal() {
        setVisible(true);
        return etatSortie;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtStatut = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtPrenom = new javax.swing.JTextField();
        lblPrenom = new javax.swing.JLabel();
        lblStatut = new javax.swing.JLabel();
        btnMariage = new javax.swing.JButton();
        lblNom = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnDivorce = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblVip2 = new javax.swing.JLabel();
        boxVip = new javax.swing.JComboBox<>();
        lblDateMariage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLieuMariage = new javax.swing.JTextField();
        datePickerM = new org.jdesktop.swingx.JXDatePicker();
        jPanel2 = new javax.swing.JPanel();
        lblDateDivorce = new javax.swing.JLabel();
        datePickerD = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Saise d'un changement Marital");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        txtStatut.setEditable(false);

        txtNom.setEditable(false);

        txtPrenom.setEditable(false);

        lblPrenom.setText("Prenom VIP");

        lblStatut.setText("Statut Vip");

        btnMariage.setText("Ajout Mariage");
        btnMariage.setEnabled(false);
        btnMariage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMariageActionPerformed(evt);
            }
        });

        lblNom.setText("Nom VIP");

        btnDivorce.setText("Ajout Divorce");
        btnDivorce.setEnabled(false);
        btnDivorce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivorceActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setEnabled(false);

        lblVip2.setText("Partenaire :");

        boxVip.setModel(leModele);
        boxVip.setEnabled(false);

        lblDateMariage.setText("Date Mariage :");

        jLabel1.setText("Lieu Mariage :");

        txtLieuMariage.setEnabled(false);

        datePickerM.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(datePickerM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(lblVip2)
                                                                        .addGap(26, 26, 26)
                                                                        .addComponent(boxVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(lblDateMariage)
                                                                .addComponent(txtLieuMariage, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(72, 72, 72))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblVip2)
                                        .addComponent(boxVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDateMariage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datePickerM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLieuMariage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblDateDivorce.setText("Date Divorce :");

        datePickerD.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lblDateDivorce))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(datePickerD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(lblDateDivorce)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datePickerD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(btnMariage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDivorce)
                                .addGap(39, 39, 39))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(58, 58, 58)
                                                                .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblNom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(40, 40, 40)
                                                                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblStatut, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(58, 58, 58)
                                                                .addComponent(txtStatut, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNom)
                                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPrenom)
                                        .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtStatut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblStatut))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnDivorce)
                                        .addComponent(btnMariage))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMariageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMariageActionPerformed
        int lePartenaire = -1;
        // Partnaire sélectionné(e) ?
        int itemIndex = boxVip.getSelectedIndex();
        if (itemIndex >= 0) {
            lePartenaire = leModele.getVipAt(itemIndex).getNum();
        } else {
            return;
        }

        LocalDate dateDivorceVip1;
        LocalDate dateDivorceVip2;
        LocalDate dateNaissanceVip1 = Appli.getDaoVip().lireUnVipMariage(numero).getDateNaissance();
        LocalDate dateNaissancePartenaire = Appli.getDaoVip().lireUnVipMariage(lePartenaire).getDateNaissance();
        LocalDate dateMariageDemandee = datePickerM.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dateMariageVip1 = Appli.getDaoMariages().getDateMariageEnCours(numero);
        LocalDate dateMariagePartenaire = Appli.getDaoMariages().getDateMariageEnCours(lePartenaire);

        if (datePickerM.getDate() != null) {

            dateDivorceVip1 = Appli.getDaoMariages().dernierDivorce(numero);
            dateDivorceVip2 = Appli.getDaoMariages().dernierDivorce(lePartenaire);

            if (dateMariageDemandee.isAfter(dateDivorceVip1)) {
                verifierMariagePartenaire(dateMariageDemandee, dateDivorceVip2, dateNaissanceVip1, dateNaissancePartenaire, dateMariagePartenaire, lePartenaire);
            } else {
                JOptionPane.showMessageDialog(this, "La date du Mariage est incorrecte", "Attention", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "La date du Mariage n'a pas été sélectionnée", "Attention", JOptionPane.WARNING_MESSAGE);
        }
        etatSortie = true;
        this.dispose();
    }//GEN-LAST:event_btnMariageActionPerformed

    private void verifierMariagePartenaire(LocalDate dateMariageDemandee, LocalDate dateDivorceVip2,
                                           LocalDate dateNaissanceVip1, LocalDate dateNaissancePartenaire, LocalDate dateMariagePartenaire,
                                           int lePartenaire) {
        // Vérifie si la date demandée est apres la date de Divorce Vip2 Ou regarde si VIP2 a été marié
        if (dateMariageDemandee.isAfter(dateDivorceVip2)) {
            verifierMajorite(dateMariageDemandee, dateNaissanceVip1, dateNaissancePartenaire, lePartenaire);
        } else if (dateMariagePartenaire == null) {
            verifierMajorite(dateMariageDemandee, dateNaissanceVip1, dateNaissancePartenaire, lePartenaire);
        } else {
            JOptionPane.showMessageDialog(this, "La date du Mariage est incorrecte", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void verifierMajorite(LocalDate dateMariageDemandee, LocalDate dateNaissanceVip1, LocalDate dateNaissancePartenaire, int lePartenaire) {
        if (dateMariageDemandee.isAfter(dateNaissanceVip1.plusYears(18))
                && dateMariageDemandee.isAfter(dateNaissancePartenaire.plusYears(18))) {
            // Date Valide
            Appli.getDaoMariages().fraichementMarie(numero, lePartenaire, java.sql.Date.valueOf(dateMariageDemandee), txtLieuMariage.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Personne Mineure ", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Ajout d'un divorce
    private void btnDivorceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivorceActionPerformed
        LocalDate dateDivorceDemandee = datePickerD.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        dateMariage = Appli.getDaoMariages().getDateMariageEnCours(numero);
        if (datePickerD.getDate() != null) {
            if (dateMariage == null) {
                System.out.println(numero);
            }
            if (dateDivorceDemandee.isAfter(dateMariage)) {
                JOptionPane.showMessageDialog(this, "La date de Divorce est inférieure à la date de Mariage", "Attention", JOptionPane.WARNING_MESSAGE);
            } else {
                // Date Valide
                Appli.getDaoMariages().prepareDivorce(numero, java.sql.Date.valueOf(dateMariage), java.sql.Date.valueOf(dateDivorceDemandee));
                // Ici on est bon
                etatSortie = true;
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner une Date", "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDivorceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxVip;
    private javax.swing.JButton btnDivorce;
    private javax.swing.JButton btnMariage;
    private org.jdesktop.swingx.JXDatePicker datePickerD;
    private org.jdesktop.swingx.JXDatePicker datePickerM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDateDivorce;
    private javax.swing.JLabel lblDateMariage;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPrenom;
    private javax.swing.JLabel lblStatut;
    private javax.swing.JLabel lblVip2;
    private javax.swing.JTextField txtLieuMariage;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPrenom;
    private javax.swing.JTextField txtStatut;
    // End of variables declaration//GEN-END:variables
}
