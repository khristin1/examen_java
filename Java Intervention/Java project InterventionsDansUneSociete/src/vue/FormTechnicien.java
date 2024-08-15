package vue;
import controleur.*;
import modele.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
import java.util.Enumeration;

public class FormTechnicien extends JFrame implements ActionListener{
    JLabel lidTech,lNom,lPrenom,lDisponibilite,lSpecialite,lAdresse,lSexe,lTel,lStatus;
    JTextField tidTech,tNom,tPrenom,tDisponibilite,tSpecialite,tAdresse,tSexe,tTel,tStatus,trech;  
    JRadioButton Sexe1,Sexe2;
    ButtonGroup listeSexe;
    JButton benreg,bvisua,binitia,brech,bupdate,bdel;
    ArrayList<Technicien > listeTechnicien  = new ArrayList();
    JTable tableTechnicien ;
    private final DefaultTableModel model;
    Technicien  tech = null;
    
    public FormTechnicien(){
    lidTech = new JLabel("idTech");
    lidTech.setBounds(10,30,100,30);
    this.getContentPane().add(lidTech);
        
    tidTech = new JTextField();
    tidTech.setBounds(120,30,100,30);
    this.getContentPane().add(tidTech);
    
    trech = new JTextField();
    trech.setBounds(230,30,100,30);
    this.getContentPane().add(trech);
    
    lNom = new JLabel("Nom");
    lNom.setBounds(10,70,100,30);
    this.getContentPane().add(lNom);
        
    tNom = new JTextField();
    tNom.setBounds(120,70,100,30);
    this.getContentPane().add(tNom);
    
    lPrenom = new JLabel("Prenom");
    lPrenom.setBounds(10,110,100,30);
    this.getContentPane().add(lPrenom);
    
    tPrenom = new JTextField();
    tPrenom.setBounds(120,110,100,30);
    this.getContentPane().add(tPrenom);

    lDisponibilite= new JLabel("Disponibilite");
    lDisponibilite.setBounds(10,160,100,30);
    this.getContentPane().add(lDisponibilite);
        
    tDisponibilite = new JTextField();
    tDisponibilite.setBounds(120,160,100,30);
    this.getContentPane().add(tDisponibilite);
    
    lSpecialite= new JLabel("Specialite");
    lSpecialite.setBounds(10,200,100,30);
    this.getContentPane().add(lSpecialite);
        
    tSpecialite = new JTextField();
    tSpecialite.setBounds(120,200,100,30);
    this.getContentPane().add(tSpecialite);
    
    lAdresse= new JLabel("Adresse");
    lAdresse.setBounds(10,240,100,30);
    this.getContentPane().add(lAdresse);
        
    tAdresse = new JTextField();
    tAdresse.setBounds(120,240,100,30);
    this.getContentPane().add(tAdresse);
    
    lSexe = new JLabel("Sexe");
    lSexe.setBounds(10,280,100,30);
    this.getContentPane().add(lSexe);
        
    Sexe1 = new JRadioButton ("Maculin");
    Sexe1.setBounds(120,280,70,30);
    Sexe2 = new JRadioButton("Feminin");
    Sexe2.setBounds(200,280,70,30);
    listeSexe = new ButtonGroup();
    listeSexe.add(Sexe1);
    listeSexe.add(Sexe2);
    this.getContentPane().add(Sexe1);
    this.getContentPane().add(Sexe2);

    lTel= new JLabel("Tel");
    lTel.setBounds(10,320,100,30);
    this.getContentPane().add(lTel);
        
    tTel= new JTextField();
    tTel.setBounds(120,320,100,30);
    this.getContentPane().add(tTel);

    lStatus= new JLabel("Status");
    lStatus.setBounds(10,350,100,30);
    this.getContentPane().add(lStatus);
        
    tStatus = new JTextField();
    tStatus.setBounds(120,350,100,30);
    this.getContentPane().add(tStatus);
           
    benreg = new JButton("Enregistrer");
    benreg.setBounds(10,430,100,30);
    benreg.addActionListener(this);
    this.getContentPane().add(benreg);
     
    bvisua = new JButton("Visualiser");
    bvisua.setBounds(120,430,100,30);
    bvisua.addActionListener(this);
    this.getContentPane().add(bvisua);
    
    binitia = new JButton("Initialiser");
    binitia.setBounds(230,430,100,30);
    binitia.addActionListener(this);
    this.getContentPane().add(binitia);
    
    brech = new JButton("Recherche");
    brech.setBounds(340,430,100,30);
    brech.addActionListener(this);
    this.getContentPane().add(brech);
    
    bupdate = new JButton("Modifier");
    bupdate.setBounds(450,430,100,30);
    bupdate.addActionListener(this);
    this.getContentPane().add(bupdate);
    
    bdel = new JButton("Supprimer");
    bdel.setBounds(560,430,100,30);
    bdel.addActionListener(this);
    this.getContentPane().add(bdel);
    
    model = new DefaultTableModel();
    model.addColumn("idTech");
    model.addColumn("Nom");
    model.addColumn("Prenom");
    model.addColumn("Disponibilite");
    model.addColumn("Specialite");
    model.addColumn("Adresse");
    model.addColumn("Sexe");
    model.addColumn("Tel");
    model.addColumn("Status");
  
        
    this.getContentPane().setLayout(null);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==benreg){
            String idTech = tidTech .getText();
            String Nom = tNom.getText();
            String Prenom = tPrenom.getText();
            String Disponibilite = tDisponibilite.getText();
            String Specialite = tSpecialite.getText();
            String Adresse = tAdresse.getText();
            String Sexe = "";
            if(Sexe1.isSelected()){
                Sexe = Sexe1.getText();
            }else if(Sexe2.isSelected()){
                Sexe = Sexe2.getText();
            }
            int Tel = Integer.valueOf(tTel.getText());
            String Status = tStatus.getText();
            
            tech = new Technicien(idTech,Nom,Prenom,Disponibilite,Specialite,Adresse,Sexe,Tel,Status);
            Factory.setTechnicien(tech);
        }
        else
            if(e.getSource()==bvisua){
                afficher();
            }
            else
                if(e.getSource()==binitia){
                    initialiser();
                }
               
                       else
//                    Bouton rechercher
                    if(e.getSource()==brech){
                        String rech = String.valueOf(trech.getText());
                        tech = Factory.getRechTech(rech);
                            if(tech != null){
                            tidTech.setText(String.valueOf(tech.getIdTech()));
                            tNom.setText(tech.getNom());
                            tPrenom.setText(tech.getPrenom());
                            tDisponibilite.setText(tech.getDisponibilite());
                            tSpecialite.setText(tech.getSpecialite());
                            tAdresse.setText(tech.getAdresse());
                            if(tech.getSexe().equalsIgnoreCase(Sexe1.getText())) 
                              Sexe1.setSelected(true);
                            else Sexe2.setSelected(true);
                            tTel.setText(String.valueOf(tech.getTel()));
                            tStatus.setText(tech.getStatus());
                            
                           
                        }
                    }
                    else 
                        if(e.getSource()==bupdate){
                    String idTech= tidTech.getText();
                    String Nom = tNom.getText();
                    String Prenom = tPrenom.getText();
                    String Disponibilite = tDisponibilite.getText();
                    String Specialite = tSpecialite.getText();
                    String Adresse = tAdresse.getText();
                    String Sexe = "";
                    int Tel = Integer.parseInt(tTel.getText());
                    String Status = tStatus.getText();
                   
                    
                    try {
                         Factory.ModifierTechnicien(idTech, Nom, Prenom, Disponibilite, Specialite, Adresse, Sexe, Tel, Status);
                         String message = "Technicien modifié avec succes";
                         JOptionPane.showConfirmDialog(this, message);
                    } catch (Exception ex){
                    ex.printStackTrace();
                    }
                    }
                    
                    else
                            if(e.getSource()==bdel){
                                if(tech != null){
                                  String msg = "Souhaitez-vous supprimer "+tech.getNom()+tech.getPrenom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.getDelTechnicien(tech);
                                        afficher();
                                        initialiser();
                                  }
                                }
                            }
                        }
   
   

     public void afficher(){
        model.setRowCount(0);
        listeTechnicien = Factory.getTechnicien();
        for(Technicien tech : listeTechnicien){
            model.addRow(new Object[]{
                tech.getIdTech(),tech.getNom(),tech.getPrenom(),tech.getDisponibilite(),tech.getSpecialite()
                    ,tech.getAdresse(),tech.getSexe(),tech.getTel(),tech.getStatus()});
        }
        tableTechnicien = new JTable(model);
        JScrollPane p = new JScrollPane(tableTechnicien);
        p.setBounds(40,550,600,100);
        this.getContentPane().add(p);
    }
    public void initialiser(){
        tidTech.setText("");
        tNom.setText("");
        tPrenom.setText("");
        tDisponibilite.setText("");
        tSpecialite.setText("");
        tAdresse.setText("");  
        tTel.setText("");   
        tStatus.setText("");   
           
    }
 }
