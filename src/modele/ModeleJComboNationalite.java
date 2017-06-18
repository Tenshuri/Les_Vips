package modele;


import application.Appli;
import data.DAOVip;

import javax.swing.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class ModeleJComboNationalite extends DefaultComboBoxModel<String> {

    Map<Integer, String> listeItems;
    private DAOVip leDaoVip;

    public ModeleJComboNationalite() throws SQLException {
        // définition du conteneur des groupes
        this.listeItems = new HashMap<>();
        // récupération de la référence sur l'objet DAO utilisé
        this.leDaoVip = Appli.getDaoVip();
        // chargement des groupes depuis la table
        leDaoVip.getNationalites(listeItems);
    }

    @Override
    public int getSize() {
        return listeItems.size();
    }

    @Override
    public String getElementAt(int i) {
        return listeItems.get(i + 1);
    }
}

