package modele;

import application.Appli;
import data.DAOVip;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import metier.Vip;

/**
 *
 * @author Administrateur
 */
public class ModeleJComboBox extends DefaultComboBoxModel<String> {

    private final List<Vip> listeItems;
    private final DAOVip leDaoVip;

    public ModeleJComboBox() throws SQLException, Exception {
        // définition du conteneur des groupes
        this.listeItems = new ArrayList<>();
        // récupération de la référence sur l'objet DAO utilisé
        this.leDaoVip = Appli.getDaoVip();
        // chargement des photos depuis la table
        leDaoVip.lireLesVips(listeItems);
    }

    @Override
    public int getSize() {
        return listeItems.size();
    }

    @Override
    public String getElementAt(int i) {
        return listeItems.get(i).getNom();
    }

    public int getNumVip(int i) {
        return listeItems.get(i).getNum();
    }
} // Fin classe ModeleJComboBox

