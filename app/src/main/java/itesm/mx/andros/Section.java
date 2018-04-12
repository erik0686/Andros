package itesm.mx.andros;

/**
 * Created by erik on 11/04/18.
 */

public class Section {
    private int idSection;
    private String title;
    private String description;
    private int idImagen;

    public Section(int idSection, String title, String description, int idImagen) {
        this.idSection = idSection;
        this.title = title;
        this.description = description;
        this.idImagen = idImagen;
    }

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }
}
