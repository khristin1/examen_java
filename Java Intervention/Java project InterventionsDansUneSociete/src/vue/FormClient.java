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

public class FormClient extends JFrame implements ActionListener{
    JLabel lidClient,lNom,lPrenom,lAdresse,lSexe,lTel,lEmail;
    JRadioButton Sexe1,Sexe2;
    ButtonGroup listeSexe;
    JTextField tidClient,tNom,tPrenom,tAdresse,tEmail,tSexe,tTel,trech;
    JButton benreg,bvisua,binitia,brech,bupdate,bdel;
    ArrayList<Client > listeClient  = new ArrayList();
    JTable tableclient ;
    private final DefaultTableModel model;
    Client  cl = null;
    
    public FormClient(){
    lidClient = new JLabel("idClient");
    lidClient.setBounds(10,30,100,30);
    this.getContentPane().add(lidClient);
        
    tidClient = new JTextField();
    tidClient.setBounds(120,30,100,30);
    this.getContentPane().add(tidClient);
    
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
    
    lAdresse = new JLabel("Adresse");
    lAdresse.setBounds(10,150,100,30);
    this.getContentPane().add(lAdresse);
        
    tAdresse = new JTextField();
    tAdresse.setBounds(120,160,100,30);
    this.getContentPane().add(tAdresse);

    lSexe = new JLabel("Sexe");
    lSexe.setBounds(10,200,100,30);
    this.getContentPane().add(lSexe);
        
    Sexe1 = new JRadioButton ("Maculin");
    Sexe1.setBounds(120,200,70,30);
    Sexe2 = new JRadioButton("Feminin");
    Sexe2.setBounds(200,200,70,30);
    listeSexe = new ButtonGroup();
    listeSexe.add(Sexe1);
    listeSexe.add(Sexe2);
    this.getContentPane().add(Sexe1);
    this.getContentPane().add(Sexe2);
    
     lTel= new JLabel("Tel");
    lTel.setBounds(10,250,100,30);
    this.getContentPane().add(lTel);
        
    tTel = new JTextField();
    tTel.setBounds(120,250,100,30);
    this.getContentPane().add(tTel);

    lEmail= new JLabel("Email");
    lEmail.setBounds(10,300,100,30);
    this.getContentPane().add(lEmail);
        
    tEmail= new JTextField();
    tEmail.setBounds(120,300,100,30);
    this.getContentPane().add(tEmail);  
    
           
    benreg = new JButton("Enregistrer");
    benreg.setBounds(10,350,100,30);
    benreg.addActionListener(this);
    this.getContentPane().add(benreg);
     
    bvisua = new JButton("Visualiser");
    bvisua.setBounds(120,350,100,30);
    bvisua.addActionListener(this);
    this.getContentPane().add(bvisua);
    
    binitia = new JButton("Initialiser");
    binitia.setBounds(230,350,100,30);
    binitia.addActionListener(this);
    this.getContentPane().add(binitia);
    
    brech = new JButton("Recherche");
    brech.setBounds(340,350,100,30);
    brech.addActionListener(this);
    this.getContentPane().add(brech);
    
    bupdate = new JButton("Modifier");
    bupdate.setBounds(450,350,100,30);
    bupdate.addActionListener(this);
    this.getContentPane().add(bupdate);
    
    bdel = new JButton("Supprimer");
    bdel.setBounds(560,350,100,30);
    bdel.addActionListener(this);
    this.getContentPane().add(bdel);
    
    model = new DefaultTableModel();
    model.addColumn("idClient");
    model.addColumn("Nom");
    model.addColumn("Prenom");
    model.addColumn("Adresse");
    model.addColumn("Sexe");
    model.addColumn("Tel");
    model.addColumn("Email");
        
    this.getContentPane().setLayout(null);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==benreg){
            String idClient = tidClient.getText();
            String Nom = tNom.getText();
            String Prenom = tPrenom.getText();
            String Adresse = tAdresse.getText();
            String Sexe = "";
            int Tel = Integer.valueOf(tTel.getText());
            String Email = tEmail.getText();
            
            if(Sexe1.isSelected()){
                Sexe = Sexe1.getText();
            }else if(Sexe2.isSelected()){
                Sexe = Sexe2.getText();
            }
            
            cl = new Client(idClient,Nom,Prenom,Adresse,Sexe,Tel,Email);
            Factory.setClient(cl);
        }
         else if(e.getSource()==bvisua){
                afficher();
        }
         else if (e.getSource()==binitia){
                    initialiser();
                }
               
                       else
//                    Bouton rechercher
                    if(e.getSource()==brech){
                        String rech = String.valueOf(trech.getText());
                        cl = Factory.getRechidClient(rech);
                            if(cl != null){
                            tidClient.setText(String.valueOf(cl.getIdClient()));
                            tNom.setText(cl.getNom());
                            tPrenom.setText(cl.getPrenom());
                            tAdresse.setText(cl.getAdresse());
                            if(cl.getSexe().equalsIgnoreCase(Sexe1.getText())) 
                              Sexe1.setSelected(true);
                            else Sexe2.setSelected(true);
                            tTel.setText(String.valueOf(cl.getTel()));
                            tEmail.setText(String.valueOf(cl.getEmail()));
                            
                        }
                    }
                    else 
                        if(e.getSource()==bupdate){
                    String idClient = tidClient.getText();
                    String Nom = tNom.getText();
                    String Prenom = tPrenom.getText();
                    String Adresse = tAdresse.getText();
                    String Sexe = "";
                    int Tel = Integer.parseInt(tTel.getText());
                    String Email = tEmail.getText();
                    
                    
                    try {
                         Factory.ModifierClient(Nom, Prenom, Adresse, Sexe, Tel, Email,idClient);
                         String message = "Client modifié avec succes";
                         JOptionPane.showConfirmDialog(this, message);
                    } catch (Exception ex){
                    ex.printStackTrace();
                    }
             
                    }
                    else
                            if(e.getSource()==bdel){
                                if(cl != null){
                                  String msg = "Souhaitez-vous supprimer "+cl.getNom()+cl.getPrenom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.getDelclient(cl);
                                        afficher();
                                        initialiser();
                                  }
                                }
                            }
                    }
    
         public void afficher(){
        model.setRowCount(0);
        listeClient = Factory.getClient();
        for(Client c : listeClient){
            model.addRow(new Object[]{
                c.getIdClient(),c.getNom(),c.getPrenom(),c.getAdresse(),c.getSexe(),c.getTel(),c.getEmail(),});
        }
        tableclient = new JTable(model);
        JScrollPane p = new JScrollPane(tableclient);
        p.setBounds(40,400,600,100);
        this.getContentPane().add(p);
    }
    public void initialiser(){
        tidClient.setText("");
        tNom.setText("");
        tPrenom.setText("");
        tAdresse.setText("");
        tTel.setText("");
        tEmail.setText("");  

    }

}

