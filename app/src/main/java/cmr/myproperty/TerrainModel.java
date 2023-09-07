package cmr.myproperty;

public class TerrainModel {

    private String titre;
    private String localisation;

    public TerrainModel(String titre, String localisation) {
        this.titre = titre;
        this.localisation = localisation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }


}
