//import java.util.ArrayList;
import java.io.File;
//import java.io.FileReader;
import java.io.IOException;

public class Affichage{
    //private File f;
    private Trame_champ tc;
    private String srcIP;
    private String dstIP;
    //private int nbLignes;
    //private int nbTrames;
    private String affichage = "";


    public Affichage(File f) throws IOException{
        //this.f=f;
        this.tc=new Trame_champ(f);
        srcIP=tc.trame_list.get(0).ip.getIpSource();
        dstIP=tc.trame_list.get(0).ip.getIpDestionation();
        
    }

    /*public void infoSrc(){
        System.out.print("");

    }

    public void infoDst(){
        System.out.println();
    } */

    public void makeAffichage(){
    
      affichage += ("discussion entre "+srcIP+" et "+dstIP+"\n");
      while(!(tc.trame_list.isEmpty())){
            Trame_info ti = tc.trame_list.remove(0);
            /*System.out.println(""+ti.ip.getIpDestionation() );
            System.out.println(""+ dstIP);
            System.out.println(""+(ti.ip.getIpDestionation().equals(dstIP))); */
            if(ti.ip.getIpDestionation().equals(dstIP)){
                affichage += ti.envoiData();    
            }else{
                if(ti.ip.getIpDestionation().equals(srcIP)){
                    affichage += ti.recoitData();
                }else{
                    affichage += ("\nfin discussion entre "+srcIP+" et "+dstIP+"\n");
                    dstIP = ti.ip.getIpDestionation();
                    affichage += ("nouvelle discussion entre \n");
                    affichage += ti.envoiData();
            }
            } 
            
        }
       
    }

    public void printGraph(){
        System.out.println(affichage);
    }

    public void printGrapheIn(File dest){

    }
}