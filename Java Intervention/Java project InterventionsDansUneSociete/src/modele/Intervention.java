package modele;

public class Intervention {
private String idInterv,Nom,idTech,Description,Date_Intervention; 

public  Intervention (String idInterv, String Nom, String idTech, String  Description, String date_Intervention) {
        this.idInterv = idInterv;
        this.Nom = Nom;
        this.idTech = idTech;
        this.Description = Description;
        this.Date_Intervention = Date_Intervention;
     }
    public Intervention(){
        
    }
    public String getIdInterv() {
        return idInterv;
    }

    public void setIdInterv(String idInterv) {
        this.idInterv = idInterv;
    }
    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    public String getIdTech() {
        return idTech;
    }

    public void setIdTech(String idTech) {
        this.idTech = idTech;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    public String getDate_Intervention() {
        return Date_Intervention;
    }

    public void setDate_Intervention(String Date_Intervention) {
        this.Date_Intervention = Date_Intervention;
    }
 
}

