package ihm;

import metier.Apparaitre;
import metier.Photo;
import modele.ModeleJTable;
import modele.ModeleJTablePhotos;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

import javax.swing.*;
import java.io.File;
import java.net.URLConnection;
import java.sql.SQLException;

public class FenetreSaisiePhoto extends javax.swing.JDialog {

    private final Photo photo;
    private boolean etatSortie;
    //private ModeleJComboBox leModele;
    private ModeleJTable leModeleTable;
    private ModeleJTablePhotos leModeleTPhoto;
    private String cheminLong = null;
    private Apparaitre app;

    public FenetreSaisiePhoto(java.awt.Frame parent, Photo photo, Apparaitre app) throws Exception {
        super(parent, true);  // mode modal 
        this.setLocation(parent.getLocation());
        this.photo = photo;
        this.app = app;
        etatSortie = false;
        this.leModeleTable = new ModeleJTable();
        initComponents();
        try {
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

        txtLieu = new javax.swing.JTextField();
        txtImages = new javax.swing.JTextField();
        lbLieu = new javax.swing.JLabel();
        btValid = new javax.swing.JButton();
        lbImages = new javax.swing.JLabel();
        lbAnnee = new javax.swing.JLabel();
        txtAnnee = new javax.swing.JTextField();
        btParcourir = new javax.swing.JButton();
        lbVip = new javax.swing.JLabel();
        btAjout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        laTable = new javax.swing.JTable();
        lbNumVip = new javax.swing.JLabel();
        lbSelection = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter le photo");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        lbLieu.setText("Lieu :");

        btValid.setText("Valider");
        btValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValidActionPerformed(evt);
            }
        });

        lbImages.setText(" Image :");

        lbAnnee.setText("Année :");

        btParcourir.setText("Parcourir");
        btParcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btParcourirActionPerformed(evt);
            }
        });

        lbVip.setText("VIP :");

        btAjout.setText("Ajouter");
        btAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjoutActionPerformed(evt);
            }
        });

        laTable.setModel(leModeleTable);
        jScrollPane1.setViewportView(laTable);

        lbSelection.setText("VIP selectionné :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbImages, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtImages, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(btParcourir))
                                    .addComponent(txtLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(lbVip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lbAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbNumVip, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btAjout))
                                    .addComponent(txtAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(btValid)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbImages)
                    .addComponent(txtImages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btParcourir))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLieu))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAnnee))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbVip)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btAjout))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNumVip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSelection, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btValid)
                .addGap(36, 36, 36))
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

        // Envoyer une image sur le serveur web, avec une requête HTTP POST
        // (Sur un formulaire PHP d'upload dédié
    private static void postImage(String cheminImage) {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
            HttpPost httppost = new HttpPost("http://iutdoua-web.univ-lyon1.fr/~p1205854/vips/index.php?page=upload");
            File file = new File(cheminImage);
            MultipartEntity mpEntity = new MultipartEntity();
            ContentBody cbFile = new FileBody(file, URLConnection.guessContentTypeFromName(file.getName()));
            mpEntity.addPart("fileToUpload", cbFile);
            httppost.setEntity(mpEntity);

            // Exécuter la requête et fermer la connexion
            HttpResponse response = httpclient.execute(httppost);
            httpclient.getConnectionManager().shutdown();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

    private void btValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValidActionPerformed
        try {
            // validation saisie du l'image          
            String image = txtImages.getText();
            if (image.isEmpty()) {
                throw new Exception("champ image vide");
            }
            photo.setChemin(image);
            
            // validation saisie du lieu de photo
            String leLieu = txtLieu.getText();
            if (leLieu.isEmpty()) {
                throw new Exception("champ lieu vide");
            }
            photo.setLieu(leLieu);
            
            // validation saisie de l'année de photo
            String annee = txtAnnee.getText();
            if (annee.isEmpty()) {
                throw new Exception("champ année vide");
            }
            photo.setAnnee(Integer.parseInt(annee));
            
            // validation sélection de VIP 
            int indexItem = laTable.getSelectedRow();
            if (indexItem < 0) {
                throw new Exception("choisir au moins un vip existant");
            }
            int leVip = leModeleTable.getNumeroVip(indexItem);
            //int lePhoto = leModeleTPhoto.getNumPhoto(indexItem);
            app.setIdVip(leVip);
            
            // upload photo
            postImage(cheminLong);

            etatSortie = true;
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btValidActionPerformed

    private void btParcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btParcourirActionPerformed

        //création dun nouveau filechosser
        String chemin;
        JFileChooser chooser = new JFileChooser();
        //intitulé du bouton
        //chooser.setApproveButtonText("Choix du fichier");
        //affiche la boite de dialogue
        //chooser.showOpenDialog(null);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            //txtImages.setText(chooser.getSelectedFile().getAbsolutePath());
            //txtImages.setText(chooser.getSelectedFile().getName());
            cheminLong = chooser.getSelectedFile().getAbsolutePath();
            txtImages.setText(chooser.getSelectedFile().getName());
        }   
    }//GEN-LAST:event_btParcourirActionPerformed

    private void btAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAjoutActionPerformed
        // TODO add your handling code here:
        int numeroLigne = laTable.getSelectedRow();
        if(numeroLigne != -1) {
            int numVip = leModeleTable.getNumeroVip(numeroLigne);
//            List<Integer> leConteneur = new ArrayList<>();
//            leConteneur.add(numVip);
//            lbNumVip.setText(String.valueOf(leConteneur));
            lbNumVip.setText(String.valueOf(numVip));
        }
    }//GEN-LAST:event_btAjoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAjout;
    private javax.swing.JButton btParcourir;
    private javax.swing.JButton btValid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable laTable;
    private javax.swing.JLabel lbAnnee;
    private javax.swing.JLabel lbImages;
    private javax.swing.JLabel lbLieu;
    private javax.swing.JLabel lbNumVip;
    private javax.swing.JLabel lbSelection;
    private javax.swing.JLabel lbVip;
    private javax.swing.JTextField txtAnnee;
    private javax.swing.JTextField txtImages;
    private javax.swing.JTextField txtLieu;
    // End of variables declaration//GEN-END:variables
}
