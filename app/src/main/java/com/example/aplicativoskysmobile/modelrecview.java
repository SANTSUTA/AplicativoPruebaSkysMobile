package com.example.aplicativoskysmobile;

public class modelrecview {
    private String nameuser, tipouser, urluser, ultconexion;

    public modelrecview(){

    }
    public modelrecview(String nameuser, String tipouser, String urluser, String ultconexion){
        this.nameuser=nameuser;
        this.tipouser=tipouser;
        this.urluser=urluser;
        this.ultconexion=ultconexion;
    }

    public String getNameuser() {
        return nameuser;
    }

    public void setNameuser(String nameuser) {
        this.nameuser = nameuser;
    }

    public String getTipouser() {
        return tipouser;
    }

    public void setTipouser(String tipouser) {
        this.tipouser = tipouser;
    }

    public String getUrluser() {
        return urluser;
    }

    public void setUrluser(String urluser) {
        this.urluser = urluser;
    }

    public String getUltconexion() {
        return ultconexion;
    }

    public void setUltconexion(String ultconexion) {
        this.ultconexion = ultconexion;
    }
}
