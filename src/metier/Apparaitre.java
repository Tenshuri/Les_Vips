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
public class Apparaitre {
    
    private int idVip;
    private int idPhoto;
    
    public Apparaitre() {
    }
    
    public Apparaitre(int idVip, int idPhoto) {
        this.idVip = idVip;
        this.idPhoto = idPhoto;
    }

    public void setIdVip(int idVip) {
        this.idVip = idVip;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public int getIdVip() {
        return idVip;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void getIdPhoto(int lePhoto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
