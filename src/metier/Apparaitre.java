package metier;

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

}
