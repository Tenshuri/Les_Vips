package modele;


import application.Appli;
import data.DAOVip;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author Administrateur
 */
public class ModeleJComboCivilite extends DefaultComboBoxModel<String> {
    
    List<String> listeItems;
    private DAOVip leDaoVip;
    
    public ModeleJComboCivilite() throws SQLException {
        // définition du conteneur des groupes
        this.listeItems = new ArrayList<>();
        // récupération de la référence sur l'objet DAO utilisé
        this.leDaoVip = Appli.getDaoVip();
        // chargement des groupes depuis la table
        leDaoVip.getCivilites(listeItems);
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

