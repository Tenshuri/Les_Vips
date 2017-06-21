package modele;


import application.Appli;
import data.DAOVip;

import javax.swing.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ModeleJComboNationalite extends DefaultComboBoxModel<String> {

    Map<Integer, String> listeItems;
    private DAOVip leDaoVip;

    public ModeleJComboNationalite() throws SQLException {
        // définition du conteneur des groupes
        this.listeItems = new ConcurrentHashMap<>();
        // récupération de la référence sur l'objet DAO utilisé
        this.leDaoVip = Appli.getDaoVip();
        // chargement des groupes depuis la table
        leDaoVip.getNationalites(listeItems);
        for(Map.Entry<Integer, String> entry : listeItems.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " - " + value);
        }
    }

    @Override
    public int getSize() {
        return listeItems.size();
    }

    @Override
    public String getElementAt(int i) {
        return listeItems.get(i);
    }
}

