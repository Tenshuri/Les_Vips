/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author p1512264
 */
public class Photo {
    
    private int idphoto;
    private String lieu;
    private int annee;
    private String chemin;

    public Photo(int idphoto, String lieu, int annee, String chemin) {
        this.idphoto = idphoto;
        this.lieu = lieu;
        this.annee = annee;
        this.chemin = chemin;
    }

    public Photo() {
    }

        public int getIdphoto() {
        return idphoto;
    }

    public String getLieu() {
        return lieu;
    }

    public int getAnnee() {
        return annee;
    }

    public void setIdphoto(int idphoto) {
        this.idphoto = idphoto;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }
    
    
    
}
