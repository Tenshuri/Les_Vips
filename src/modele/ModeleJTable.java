package modele;

import application.Appli;
import data.DAOVip;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import metier.Vip;

public class ModeleJTable extends AbstractTableModel {

    // le conteneur de données
    private final List<Vip> leConteneur;
    // le titre des champs du conteneur
    private final String[] titre;
    // l'objet DAO pour mettre à jour le conteneur
    private final DAOVip leDaoVip;

    public ModeleJTable() {
        // définition du conteneur d'étudiants
        this.leConteneur = new ArrayList<>();
        // définition des noms du champ
        this.titre = new String[]{"Numéro", "Nom", "Prénom", "Civilité", 
            "Date de naissance", "Lieu de naissance", "Role", "Statut",
            "Nationalité"};
        // récupération de l'objet DAO utilisé
        this.leDaoVip = Appli.getDaoVip();
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
        Vip vip = leConteneur.get(row);
        switch (column) {
            case 0:
                return vip.getNum();
            case 1:
                return vip.getNom();
            case 2:
                return vip.getPrenom();
            case 3:
                return  vip.getCivilite();
            case 4:                
                return vip.getDateNaissance().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            case 5:
                return vip.getLieuNaissance();
            case 6:
                return vip.getRole();
            case 7:
                return vip.getStatut();
            case 8:
                return vip.getNationalite();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    /*public void insererEmploye(Employe emp) throws SQLException {
        // on tente d'insérer l'employé dans la base
        leDaoEmp.insererEmploye(emp);
        // si c'est OK on l'ajoute au conteneur du modèle
        leConteneur.add(emp);
        // on rafraichit la vue par une notification de modification des données  
        this.fireTableDataChanged();
    }

    public void supprimerEmploye(int ligne) throws SQLException {
        // on récupère le numéro de l'employé de la ligne sélectionnée
        int numEmp = (int) getValueAt(ligne, 0);
        // on tente de supprimer l'employé dans la base
        leDaoEmp.supprimerEmploye(numEmp);
        // si c'est OK on l'enlève du conteneur du modèle
        leConteneur.remove(ligne);
        // on rafraichit la vue par une notification de modification des données
        this.fireTableDataChanged();
    }*/

    public void chargerLesVips() throws SQLException, Exception {
        try {
            // chargement de tous les vips dans la base dans le conteneur du modèle
            leDaoVip.lireLesVips(leConteneur);
            // si c'est OK on rafraichit la vue par une notification  
            this.fireTableDataChanged();
        }
        catch (Exception e) {
            System.out.println("jtable :" + e.getMessage());
        }
    }
}
