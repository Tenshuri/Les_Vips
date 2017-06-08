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
public class ModeleJComboBoxMariage extends DefaultComboBoxModel<String> {

        private final List<Vip> listeVip;
        private final DAOVip leDaoVip;
        
    public ModeleJComboBoxMariage(int numero) {
        this.listeVip = new ArrayList<>();
        this.leDaoVip = Appli.getDaoVip();
        try {
            leDaoVip.lireLesVips(listeVip);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        for (int i = 0 ; i< listeVip.size();i++) {
            if(listeVip.get(i).getNum()== numero){
                
                listeVip.remove(i);
                
            }
            System.out.println(listeVip.get(i).getNom());
        }

    }
    
    @Override
    public int getSize() {
        return listeVip.size();
    }

    @Override
    public String getElementAt(int i) {
        return listeVip.get(i).getNom() + " " +
                listeVip.get(i).getPrenom();
    }
    
    public Vip getVipAt(int i) {
        return listeVip.get(i);
    }
    
} // Fin classe ModeleJComboBoxMariage

