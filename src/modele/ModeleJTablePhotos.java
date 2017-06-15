package modele;

import application.Appli;
import data.DAOApparaitre;
import data.DAOPhoto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Apparaitre;
import metier.Photo;
import metier.Vip;


public class ModeleJTablePhotos extends AbstractTableModel {

    // le conteneur de données
    private final List<Photo> leConteneur;
    // le titre des champs du conteneur
    private final String[] titre;
    // l'objet DAO pour mettre à jour le conteneur
    private final DAOPhoto leDaoPhoto;
    private DAOApparaitre leDaoApp;
    private String chemin;

    public ModeleJTablePhotos() {
        // définition du conteneur d'étudiants
        this.leConteneur = new ArrayList<>();
        // définition des noms du champ
        this.titre = new String[]{"ID Photo", "lieu", "année", "chemin"};
        // récupération de l'objet DAO utilisé
        this.leDaoPhoto = Appli.getDaoPhoto();
        // instanciation DAOApparaitre
        leDaoApp = Appli.getDaoApparaitre();
    }

    @Override
    public int getRowCount() {
        return leConteneur.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Photo photo = leConteneur.get(row);
        switch (column) {
            case 0:
                return photo.getIdphoto();
            case 1:
                return photo.getLieu();
            case 2:
                return photo.getAnnee();
            case 3:
                return photo.getChemin();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void chargerLesPhotos() throws SQLException, Exception {
        try {
            // chargement de tous les photos dans la base dans le conteneur du modèle
            leDaoPhoto.lireLesPhotos(leConteneur);
            // si c'est OK on rafraichit la vue par une notification  
            this.fireTableDataChanged();
        }
        catch (Exception e) {
            System.out.println("Jtable :" + e.getMessage());
        }
    }
    
//    public void ajouterPhoto(Photo photo, Apparaitre app) throws SQLException {
//
//        leDaoPhoto.ajouterPhoto(photo);
//        leDaoApp.ajouterApparaitre(app);
//        // si c'est OK on l'ajoute au conteneur du modèle
//        leConteneur.add(photo);
//        // on rafraichit la vue par une notification de modification des données  
//        this.fireTableDataChanged();
//    }

    public void ajouterPhoto(Photo photo) throws SQLException {

        leDaoPhoto.ajouterPhoto(photo);
        // si c'est OK on l'ajoute au conteneur du modèle
        leConteneur.add(photo);
        // on rafraichit la vue par une notification de modification des données  
        this.fireTableDataChanged();
    }
        
    public void ajouterApp(Apparaitre app) throws SQLException {

        leDaoApp.ajouterApparaitre(app);
        // si c'est OK on l'ajoute au conteneur du modèle
        // on rafraichit la vue par une notification de modification des données  
        this.fireTableDataChanged();
    }
        
    public void ajoutVip(Apparaitre app, int numPhoto) throws SQLException {
        leDaoApp.ajouterVip(app, numPhoto);
        this.fireTableDataChanged();
    }
    
    public int getNumPhoto(int i) {
        return leConteneur.get(i).getIdphoto();
    }
    
    public String getCheminPhoto(int i) throws Exception {
        int id = leConteneur.get(i).getIdphoto();
        return leDaoPhoto.recupererChemin(chemin, id);
    }

}
