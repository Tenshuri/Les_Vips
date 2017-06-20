package ihm;

import metier.Apparaitre;
import modele.ModeleJTable;
import modele.ModeleJTablePhotos;

import javax.swing.*;
import java.sql.SQLException;

public class FenetreSaisieVipPhoto extends javax.swing.JDialog {

    private boolean etatSortie;
    //private ModeleJComboBox leModele;
    private ModeleJTable leModeleTable;
    private ModeleJTablePhotos leModeleTPhoto;
    private Apparaitre app;
    public static int laPhoto;

    public FenetreSaisieVipPhoto(java.awt.Frame parent, Apparaitre app) throws Exception {
        super(parent, true);  // mode modal 
        this.setLocation(parent.getLocation());
        this.app = app;
        etatSortie = false;
        this.leModeleTable = new ModeleJTable();
        this.leModeleTPhoto = new ModeleJTablePhotos();
        initComponents();
        try {
            leModeleTPhoto.chargerLesPhotos();
            leModeleTable.chargerLesVips();
        } catch (SQLException ex) {
            System.out.println(" Erreur au chargement : " + ex.getMessage());
        }
    }

    public boolean doModal() {
        setVisible(true);
        return etatSortie;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btValid = new javax.swing.JButton();
        lbPhoto = new javax.swing.JLabel();
        lbVip = new javax.swing.JLabel();
        btAjout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        laTable = new javax.swing.JTable();
        lbSelectionPhoto = new javax.swing.JLabel();
        lbPhotoSelect = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        laTablePhoto = new javax.swing.JTable();
        lbSelection = new javax.swing.JLabel();
        lbVips = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter VIP");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        btValid.setText("Valider");
        btValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValidActionPerformed(evt);
            }
        });

        lbPhoto.setText("Photo :");

        lbVip.setText("VIP :");

        btAjout.setText("Ajouter");
        btAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjoutActionPerformed(evt);
            }
        });

        laTable.setModel(leModeleTable);
        jScrollPane1.setViewportView(laTable);

        lbSelectionPhoto.setText("Photo selectionné:");

        laTablePhoto.setModel(leModeleTPhoto);
        jScrollPane2.setViewportView(laTablePhoto);

        lbSelection.setText("VIP selectionné :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addComponent(lbPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(lbVip, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(19, 19, 19)
                                                                .addComponent(btAjout))
                                                        .addComponent(lbSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(86, 86, 86)
                                                                .addComponent(lbVips, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(lbSelectionPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(lbPhotoSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(255, 255, 255)
                                                .addComponent(btValid)))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lbSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbVips, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)
                                                .addComponent(btValid)
                                                .addGap(40, 40, 40))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btAjout)
                                                                .addGap(150, 150, 150))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbSelectionPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbPhotoSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbVip, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(129, 129, 129))))))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAjoutActionPerformed
        // TODO add your handling code here:
        int numeroLigne = laTable.getSelectedRow();
        if (numeroLigne != -1) {
            int numVip = leModeleTable.getNumeroVip(numeroLigne);
//            List<Integer> leConteneur = new ArrayList<>();
//            leConteneur.add(numVip);
//            lbNumVip.setText(String.valueOf(leConteneur));
            lbVips.setText(String.valueOf(numVip));
        }
    }//GEN-LAST:event_btAjoutActionPerformed

    private void btValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValidActionPerformed
        // TODO add your handling code here:
        try {

            //  validation sélection Photo
            int index = laTablePhoto.getSelectedRow();
            if (index < 0) {
                throw new Exception("choisir une photo à modifier");
            }

            //  validation sélection VIP
            int indexItem = laTable.getSelectedRow();
            if (indexItem < 0) {
                throw new Exception("choisir au moins un vip existant");
            }
            int leVip = leModeleTable.getNumeroVip(indexItem);
            laPhoto = leModeleTPhoto.getNumPhoto(index);
            app.setIdVip(leVip);
            app.setIdPhoto(laPhoto);

            etatSortie = true;
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btValidActionPerformed

    public static int getLePhoto() {
        return laPhoto;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAjout;
    private javax.swing.JButton btValid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable laTable;
    private javax.swing.JTable laTablePhoto;
    private javax.swing.JLabel lbPhoto;
    private javax.swing.JLabel lbPhotoSelect;
    private javax.swing.JLabel lbSelection;
    private javax.swing.JLabel lbSelectionPhoto;
    private javax.swing.JLabel lbVip;
    private javax.swing.JLabel lbVips;
    // End of variables declaration//GEN-END:variables
}
