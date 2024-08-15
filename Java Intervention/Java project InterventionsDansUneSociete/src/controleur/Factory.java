package controleur;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import modele.*;

public class Factory {
    public static Connection conn = null;
    public static Statement stm;
    public static PreparedStatement pstmet = null;
    public static ResultSet rs = null;
    
    public static Connection getConnection(){
        String serveur = "localhost";
        int port = 3306;
        String database = "Intervention_dans_une_societe";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + serveur + ":" + port +"/"+ database;
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("connected");
            return conn;
        }
        
 catch (Exception e){
            e.printStackTrace();
            return null;
        } 
    }
    
 public static void setClient(Client cl){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into Intervention_dans_une_societe.Client(idClient,Nom,Prenom,Adresse,Sexe,Tel,Email) values (?,?,?,?,?,?,?)");
            pstmet.setString(1, cl.getIdClient());
            pstmet.setString(2, cl.getNom());
            pstmet.setString(3, cl.getPrenom());
            pstmet.setString(4, cl.getAdresse());
            pstmet.setString(5, cl.getSexe());
            pstmet.setInt(6, cl.getTel());
            pstmet.setString(7, cl.getEmail());
            pstmet.executeUpdate();
            conn.close();
        }
    catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
          public static ArrayList<Client> getClient(){
        ArrayList<Client> lic = new ArrayList();
        Client cl = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from Intervention_dans_une_societe.Client");
            while(rs.next()){
                cl = new Client();
                cl.setIdClient(rs.getString("idClient"));
                cl.setNom(rs.getString("Nom"));
                cl.setPrenom(rs.getString("Prenom"));
                cl.setAdresse(rs.getString("Adresse"));
                cl.setSexe(rs.getString("Sexe"));
                cl.setTel(rs.getInt("Tel"));
                cl.setEmail(rs.getString("Email"));
                lic.add(cl);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
        }
        return lic;
    }

 public static Client getRechidClient(String Nom){
        Client cli = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from Intervention_dans_une_societe.Client where Nom='"+Nom+"'");
            if(rs.next()){
                cli = new Client();
                cli.setIdClient(rs.getString("idClient"));
                cli.setNom(rs.getString("Nom"));
                cli.setPrenom(rs.getString("Prenom"));
                cli.setAdresse(rs.getString("Adresse"));
                cli.setSexe(rs.getString("Sexe"));
                cli.setTel(rs.getInt("Tel"));
                cli.setEmail(rs.getString("Email"));
            }
            conn.close();
            stm.close();
            return cli;
        }
        catch(Exception e){
        return null;
        }
        }
         public static void ModifierClient(String Nom,String Prenom,String Adresse,String Sexe,int Tel,String Email,String idClient) throws SQLException{
        Connection connection = Factory.getConnection();
        String sql = "Update Client set Nom = ?, Prenom = ?, Adresse = ?, Sexe = ?, Tel = ?, Email = ? where idClient = ? ";
        try(PreparedStatement Statement = connection.prepareStatement (sql)) {
            
            Statement.setString(1, Nom);
            Statement.setString(2, Prenom);
            Statement.setString(3, Adresse);
            Statement.setString(4, Sexe);
            Statement.setInt(5, Tel);
            Statement.setString(6, Email);
            Statement.setString(7, idClient);

            Statement.executeUpdate();
        
          }  finally{
            connection.close();
        }
        } 
         
        public static void getDelclient(Client cl){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from Intervention_dans_une_societe.Client where idClient='"+cl.getIdClient()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
        }
     }

        public static void setTechnicien(Technicien Tec){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into Intervention_dans_une_societe.Technicien(idTech,Nom,Prenom,Disponibilite,Specialite,Adresse,Sexe,Tel,Status,Heure) values (?,?,?,?,?,?,?,?,?)");
            pstmet.setString(1, Tec.getIdTech());
            pstmet.setString(2, Tec.getNom());
            pstmet.setString(3, Tec.getPrenom());
            pstmet.setString(4, Tec.getDisponibilite());
            pstmet.setString(5, Tec.getSpecialite());
            pstmet.setString(6, Tec.getAdresse());
            pstmet.setString(7, Tec.getSexe());
            pstmet.setInt(8, Tec.getTel());
            pstmet.setString(9, Tec.getStatus());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
        
        public static ArrayList<Technicien> getTechnicien(){
        ArrayList<Technicien> lic = new ArrayList();
        Technicien Tec = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from Intervention_dans_une_societe.Technicien");
            while(rs.next()){
               Tec = new Technicien( rs.getString("idTech"),rs.getString("Nom"),rs.getString("Prenom")
                    ,rs.getString("Disponibilite"),rs.getString("Specialite"),rs.getString("Adresse")
                       ,rs.getString("Sexe"),rs.getInt("Tel"),rs.getString("Status"));
                       
                lic.add(Tec);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){ 
        }
        return lic;
        }

        public static Technicien getRechTech(String Nom){
        Technicien Tech= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from Intervention_dans_une_societe.Technicien where Nom='"+Nom+"'");
            if(rs.next()){
                Tech = new Technicien();
                Tech.setIdTech(rs.getString("idTech"));
                Tech.setNom(rs.getString("Nom"));
                Tech.setPrenom(rs.getString("Prenom"));
                Tech.setDisponibilite(rs.getString("Disponibilite"));
                Tech.setSpecialite(rs.getString("Specialite"));
                Tech.setAdresse(rs.getString("Adresse"));
                Tech.setSexe(rs.getString("Sexe"));
                Tech.setTel(rs.getInt("Tel"));
                Tech.setStatus(rs.getString("Status"));
               
            }
            conn.close();
            stm.close();
            return Tech;
        }
        catch(Exception e){
        return null;
        }
        }
         
        public static void ModifierTechnicien(String idTech,String Nom,String Prenom,String Disponibilite,String Specialite,String Adresse,String Sexe,int Tel,String Status) throws SQLException{
        Connection connection = Factory.getConnection();
        String sql = "Update Technicien set Nom = ?, Prenom = ?, Disponibilite = ?, Specialite = ?, Adresse = ?, Sexe = ?, Tel = ?, Status = ? where idTech = ?";
        try(PreparedStatement Statement = connection.prepareStatement (sql)) {
                        
            Statement.setString(1, Nom);
            Statement.setString(2, Prenom);
            Statement.setString(3, Disponibilite);
            Statement.setString(4, Specialite);
            Statement.setString(5, Adresse);
            Statement.setString(6, Sexe);
            Statement.setInt(7, Tel);
            Statement.setString(8, Status);
            Statement.setString(9, idTech);
            Statement.executeUpdate();
            
        
          }  finally{
            connection.close();
        }
        }
        
        public static void getDelTechnicien(Technicien idTech){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from Intervention_dans_une_societe.Technicien where idTech='"+idTech.getIdTech()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       
}      public static void setEquipement(Equipement equi){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into Intervention_dans_une_societe.Equipement(idEquipement,Nom,Type_Appareil,marque) values (?,?,?,?)");
            pstmet.setString(1, equi.getIdEquipement());
            pstmet.setString(2, equi.getNom());
            pstmet.setString(4, equi.getType_Appareil());
            pstmet.setString(3, equi.getMarque());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    } 

        public static ArrayList<Equipement> getEquipement(){
        ArrayList<Equipement> lic = new ArrayList();
        Equipement equip = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from Intervention_dans_une_societe.Equipement");
            while(rs.next()){
                equip = new Equipement();
                equip.setIdEquipement(rs.getString("idEquipement"));
                equip.setNom(rs.getString("Nom"));
                equip.setMarque(rs.getString("Marque"));
                equip.setType_Appareil(rs.getString("Type_Appareil"));
                lic.add(equip);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
        }
        return lic;
        }
        
        public static Equipement getRechEqui(String idEquipement){
        Equipement equi= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from Intervention_dans_une_societe.Equipement where idEquipement='"+idEquipement+"'");
            if(rs.next()){
                equi = new Equipement();
                equi.setIdEquipement(rs.getString("idEquipement"));
                equi.setNom(rs.getString("Nom"));
                equi.setMarque(rs.getString("Marque"));
                equi.setType_Appareil(rs.getString("Type_Appareil"));
              
            }
            conn.close();
            stm.close();
            return equi;
        }
        catch(Exception e){
        return null;
        }
        }
        
         public static void ModifierEquipement(String idEquipement,String Nom,String Type_Appareil,String Marque) throws SQLException{
        Connection connection = Factory.getConnection();
        String sql = "Update Equipement set Nom = ?, Type_Appareil = ?, Marque = ? where idEquipement = ? ";
        try(PreparedStatement Statement = connection.prepareStatement (sql)) {
            
            Statement.setString(1, Nom);
            Statement.setString(2, Type_Appareil);
            Statement.setString(3, Marque);
            Statement.setString(4, idEquipement);
            Statement.executeUpdate();
        
          }  finally{
            connection.close();
        }
        }
        
            public static void getDelEquipement(Equipement idEquipement){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from Intervention_dans_une_societe.Equipement where idEquipement='"+idEquipement.getIdEquipement()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }            
         
              public static void setPiece(Piece_de_Rechange piece){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into Intervention_dans_une_societe.Piece_de_Rechange(idPiece,Nom,Numero_Referance,Quantite_Disponible) values (?,?,?,?)");
            pstmet.setString(1, piece.getIdPiece());
            pstmet.setString(2, piece.getNom());
            pstmet.setInt(3, piece.getNumero_Referance());
            pstmet.setInt(4, piece.getQuantite_Disponible());
            
            pstmet.executeUpdate();
            conn.close();
        }
    catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }  
       
           public static ArrayList<Piece_de_Rechange> getPiece(){
        ArrayList<Piece_de_Rechange> lic = new ArrayList();
        Piece_de_Rechange piece = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from Intervention_dans_une_societe.Piece_de_Rechange");
            while(rs.next()){
                piece = new Piece_de_Rechange();
                piece.setIdPiece(rs.getString("idPiece"));
                piece.setNom(rs.getString("Nom"));
                piece.setNumero_Referance(rs.getInt("Numero_Referance"));
                piece.setQuantite_Disponible(rs.getInt("Quantite_Disponible"));
                lic.add(piece);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
        }
        return lic;
    }
      
              
        public static Piece_de_Rechange getRechPiece(String Nom){
        Piece_de_Rechange piece= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from Intervention_dans_une_societe.Piece_de_Rechange where Nom='"+Nom+"'");
            if(rs.next()){
                piece = new Piece_de_Rechange();
                piece.setIdPiece(rs.getString("idPiece"));
                piece.setNom(rs.getString("Nom"));
                piece.setNumero_Referance(rs.getInt("Numero_Referance"));
                piece.setQuantite_Disponible(rs.getInt("Quantite_Disponible"));
                
            }
            conn.close();
            stm.close();
            return piece;
        }
        catch(Exception e){
        return null;
        }
        }
        
        public static void ModifierPiece(String idPiece,String Nom,int Numero_Referance,int Quantite_Disponible) throws SQLException{
        Connection connection = Factory.getConnection();
        String sql = "Update Piece_de_Rechange set  Nom = ?, Numero_Referance = ?, Quantite_Disponible = ? where idPiece = ?";
        try(PreparedStatement Statement = connection.prepareStatement (sql)) {
            
            Statement.setString(1, Nom);
            Statement.setInt(2, Numero_Referance);
            Statement.setInt(3, Quantite_Disponible);
            Statement.setString(4, idPiece);
            Statement.executeUpdate();
        
          }  finally{
            connection.close();
        }
        }
        
        public static void getDelPiece(Piece_de_Rechange idPiece){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from Intervention_dans_une_societe.Piece_de_Rechange where idPiece='"+idPiece.getIdPiece()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        } 
      public static void setIntervention(Intervention Interv){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into Intervention_dans_une_societe.Intervention(idInterv,Nom,idTech,Description,Date_Intervention) values (?,?,?,?,?)");
            pstmet.setString(1, Interv.getIdInterv());
            pstmet.setString(2, Interv.getNom());
            pstmet.setString(3, Interv.getIdTech());
            pstmet.setString(4, Interv.getDescription());
            pstmet.setString(5, Interv.getDate_Intervention());
            
            pstmet.executeUpdate();
            conn.close();
        }
    catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }  
       
           public static ArrayList<Intervention> getInterv(){
        ArrayList<Intervention> lic = new ArrayList();
        Intervention Interv = null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from Intervention_dans_une_societe.Intervention");
            while(rs.next()){
                Interv = new Intervention();
                Interv.setIdInterv(rs.getString("idInterv"));
                Interv.setNom(rs.getString("Nom"));
                Interv.setIdTech(rs.getString("idTech"));
                Interv.setDescription(rs.getString("Description"));
                Interv.setDate_Intervention(rs.getString("Date_Intervention"));
                lic.add(Interv);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
        }
        return lic;
    }
      
              
        public static Intervention getRechIntervention(String Nom){
        Intervention Interv= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from Intervention_dans_une_societe.Intervention where Nom='"+Nom+"'");
            if(rs.next()){
                Interv = new Intervention();
                Interv.setIdInterv(rs.getString("idInterv"));
                Interv.setNom(rs.getString("Nom"));
                Interv.setNom(rs.getString("idTech"));
                Interv.setDescription(rs.getString("Description"));
                Interv.setDate_Intervention(rs.getString("Date_Intervention"));
                
            }
            conn.close();
            stm.close();
            return Interv;
        }
        catch(Exception e){
        return null;
        }
        }
        
        public static void ModifierIntervention(String idInterv,String Nom,String idTech,String Description,String Date_Intervention) throws SQLException{
        Connection connection = Factory.getConnection();
        String sql = "Update Intervention set Nom = ?, idTech = ?, Numero_Referance = ?, Quantite_Disponible = ?, where idInterv = ?";
        try(PreparedStatement Statement = connection.prepareStatement (sql)) {
            
            Statement.setString(1, idInterv);
            Statement.setString(2, Nom);
            Statement.setString(3, idTech);
            Statement.setString(4, Description);
            Statement.setString(5, Date_Intervention);
            Statement.executeUpdate();
        
          }  finally{
            connection.close();
        }
        }
        
        
        public static void getDelIntervention(Intervention idInterv){
        try{
            conn = getConnection();
            stm = conn.createStatement();
            String requete = "delete from Intervention_dans_une_societe.Intervention where idInterv='"+idInterv.getIdInterv()+"'";
            stm.executeUpdate(requete);
            conn.close();
        }
        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        } 
}

