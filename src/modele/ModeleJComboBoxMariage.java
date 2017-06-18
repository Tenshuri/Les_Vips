package modele;


import application.Appli;
import data.DAOVip;
import metier.Vip;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class ModeleJComboBoxMariage extends DefaultComboBoxModel<String> {

    private final List<Vip> listeVip;
    private final DAOVip leDaoVip;

    public ModeleJComboBoxMariage(int numero) {
        this.listeVip = new ArrayList<>();
        this.leDaoVip = Appli.getDaoVip();
        try {
            leDaoVip.lireLesVipsLibres(listeVip);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < listeVip.size(); i++) {
            if (listeVip.get(i).getNum() == numero) {

                listeVip.remove(i);

            }
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

