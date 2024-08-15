package vue;
import modele.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;

public class FormPrincipal extends JFrame implements ActionListener {
    JMenuBar Intervention; 
    JMenu mdonne,mtrait,mfich; 
    JMenuItem icl,itec,ipiece,iequip,iInter,iquit;
    
    public FormPrincipal(){
        Intervention = new JMenuBar();
        mdonne = new JMenu("Donnees de base"); 
        mtrait = new JMenu("Traitement");
        mfich = new JMenu("Fichier"); 
        icl = new JMenuItem("Client"); 
        icl.addActionListener(this);
        itec = new JMenuItem("Technicien"); 
        itec.addActionListener(this);
        iequip = new JMenuItem("Equipement");
        iequip.addActionListener(this);
        ipiece = new JMenuItem("Piece_de_Rechange");
        ipiece.addActionListener(this);
        iInter = new JMenuItem("Intervention");
        iInter.addActionListener(this);
        iquit = new JMenuItem("Quitter");
        mfich.add(iquit); 
        mdonne.add(iInter); 
        mdonne.add(icl);
        mdonne.add(itec);
        mdonne.add(iequip);
        mdonne.add(ipiece);
        Intervention.add(mdonne); 
        Intervention.add(mtrait); 
        Intervention.add(mfich);
        Intervention.setBounds(10,10,500,30);
        this.getContentPane().add(Intervention);
        
        this.setLayout(null);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==iInter){
        FormIntervention  interv = new FormIntervention();
        interv.setSize(800,800);
        interv.setTitle("Gestion des Interventions");
        interv.setVisible(true);  
        }
        else{
            if(e.getSource()==icl){
                FormClient  c = new FormClient();
                c.setSize(800,800);
                c.setTitle("Gestion des Clients");
                c.setVisible(true);
            }
         else {
            if(e.getSource()==itec){
                FormTechnicien tec = new FormTechnicien();
                tec.setSize(800,800);
                tec.setTitle("Gestion des Techniciens");
                tec.setVisible(true);
            }
     
         else {
            if(e.getSource()==ipiece){
                FormPiece pi = new FormPiece();
                pi.setSize(800,800);
                pi.setTitle("Gestion des Pieces de Rechange");
                pi.setVisible(true);
            }
            else {
            if(e.getSource()==iequip){
                FormEquipement equi = new FormEquipement();
                equi.setSize(800,800);
                equi.setTitle("Gestion des Equipemennts");
                equi.setVisible(true);
            }
          }
       }
    }     
  }
}
}
