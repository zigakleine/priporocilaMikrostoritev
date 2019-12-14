package si.fri.prpo.entitete;

import java.util.List;

public class Priporocilo {
    int id;
    int idUporabnika;
    List<String> seznamPriporocenihArtiklov;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUporabnika() {
        return idUporabnika;
    }

    public void setIdUporabnika(int idUporabnika) {
        this.idUporabnika = idUporabnika;
    }

    public List<String> getSeznamPriporocenihArtiklov() {
        return seznamPriporocenihArtiklov;
    }

    public void setSeznamPriporocenihArtiklov(List<String> seznamPriporocenihArtiklov) {
        this.seznamPriporocenihArtiklov = seznamPriporocenihArtiklov;
    }
}
