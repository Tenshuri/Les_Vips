package ihm;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import metier.Apparaitre;
import metier.Photo;
import modele.ModeleJTablePhotos;

public class FenetrePhoto extends javax.swing.JFrame {

    //private final Photo photo;
    private boolean etatSortie;
    private ModeleJTablePhotos leModele;
    public int numPhoto;

    public FenetrePhoto(Frame parent) throws Exception {

        this.leModele = new ModeleJTablePhotos();
        this.setLocation(parent.getLocation());
        // initialisation des composants
        initComponents();
        // affichage
        try {
            leModele.chargerLesPhotos();
        } catch (SQLException ex) {
            System.out.println(" Erreur au chargement : " + ex.getMessage());
        }
    }
 
    public void doModal() {
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        laTablePhoto = new javax.swing.JTable();
        btAjoutVIP = new javax.swing.JButton();
        btAjoutPhoto = new javax.swing.JButton();
        btAffPhoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Liste les photos");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        laTablePhoto.setModel(leModele);
        jScrollPane1.setViewportView(laTablePhoto);

        btAjoutVIP.setText("Ajouter VIP");
        btAjoutVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjoutVIPActionPerformed(evt);
            }
        });

        btAjoutPhoto.setText("Ajouter Photo");
        btAjoutPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjoutPhotoActionPerformed(evt);
            }
        });

        btAffPhoto.setText("Voir la photo");
        btAffPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAffPhotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btAjoutVIP, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(btAjoutPhoto)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btAffPhoto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btAffPhoto)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAjoutPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAjoutVIP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAjoutVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAjoutVIPActionPerformed

        try {
            Apparaitre app = new Apparaitre();
            FenetreSaisieVipPhoto ajoutVip = new FenetreSaisieVipPhoto(this, app);
            if (ajoutVip.doModal() == true) {
                leModele.ajoutVip(app, FenetreSaisieVipPhoto.getLePhoto());
            }
        } catch (SQLException e) {
            System.out.println("Erreur à ajouter : " + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(FenetrePhoto.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_btAjoutVIPActionPerformed

    public int getNumPhoto() {
        return numPhoto;
    }

    private void btAjoutPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAjoutPhotoActionPerformed
        // TODO add your handling code here:
        try {
            Photo photo = new Photo();
            Apparaitre app = new Apparaitre();
            FenetreSaisiePhoto laSaisiePhoto = new FenetreSaisiePhoto(this, photo, app);
            if (laSaisiePhoto.doModal() == true) {
//                leModele.ajouterPhoto(photo,app);
                leModele.ajouterPhoto(photo);
                leModele.ajouterApp(app);
            }
        } catch (SQLException e) {
            System.out.println("Erreur à ajouter : " + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(FenetrePhoto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAjoutPhotoActionPerformed

    private void btAffPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAffPhotoActionPerformed

        int ligne = laTablePhoto.getSelectedRow();
        if (ligne != -1) {
           
            try {
                    String cheminPhoto = leModele.getCheminPhoto(ligne);
                    AffichagePhoto aff = new AffichagePhoto(this, false);
                    String photoSelectionnee = cheminPhoto;
                    System.out.println(cheminPhoto);
//                Apparaitre app = new Apparaitre();
//                FenetreSaisieVip ajoutVip = new FenetreSaisieVip(this, app);
//                if (ajoutVip.doModal() == true) {
//                    leModele.ajoutVip(app, FenetreSaisieVip.getLePhoto());
//                }
                    aff.doModal(photoSelectionnee);
            } catch (Exception ex) {
                Logger.getLogger(FenetrePhoto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Sélectioner une photo", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btAffPhotoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAffPhoto;
    private javax.swing.JButton btAjoutPhoto;
    private javax.swing.JButton btAjoutVIP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable laTablePhoto;
    // End of variables declaration//GEN-END:variables
}
