package modele;

import application.Appli;
import data.DAOVip;
import metier.Vip;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
                return vip.getCivilite();
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

    public void chargerLesVips() throws SQLException, Exception {
        if (leConteneur.isEmpty() == false) {
            leConteneur.clear();
        }
        try {
            // chargement de tous les vips dans la base dans le conteneur du modèle
            leDaoVip.lireLesVips(leConteneur);
            // si c'est OK on rafraichit la vue par une notification  
            this.fireTableDataChanged();
        } catch (Exception e) {
            System.out.println("jtable :" + e.getMessage());
        }
    }

    public int getNumeroVip(int numLigne) {
        return Integer.parseInt(this.getValueAt(numLigne, 0).toString());
    }

    public void supprimerVip(int numVip) {
        leDaoVip.supprimerVip(numVip);
        try {
            this.chargerLesVips();
        } catch (Exception e) {
            //
        }
    }
}
