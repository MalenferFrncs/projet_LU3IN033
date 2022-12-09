//import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
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
    boolean ip=false,ip_srcb=false,ip_dstb=false, tcp=false,tcp_dstb = false, tcp_srcb=false,http=false,condition=false;
    int tcp_dst =0,tcp_src=0;
    String ip_dst = "",ip_src="";



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

      affichage += ("\nDiscussion entre "+srcIP+" et "+dstIP+"\n");
      while(!(tc.trame_list.isEmpty())){
            Trame_info ti = tc.trame_list.remove(0);
            if(condition(ti)){
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
                    affichage += ("\nNouvelle discussion entre \n");
                    affichage += ti.envoiData();
            }
            }
            }

        }

    }

    public void printGraph(){
        System.out.println(affichage);
    }

    public void printGrapheIn(String fileName){
        try{
        FileWriter fw = new FileWriter(fileName);
        fw.write(affichage);
        fw.close();
        }catch(IOException io){System.err.println("problème dans l'ecriture du fichier");}
    }

    public void makeCondition(String s){
        String s2 = s.replaceAll(" ","");
        //System.out.println("s2:"+s2);
        String[] tab_condition = s2.split(",");
        //System.out.println("tab0:"+tab_condition[0]);
        //System.out.println("tab1:"+tab_condition[1]);
        if(tab_condition[0].equals("none")){ip_srcb = false;}else{ip_srcb = true;ip_src=tab_condition[0];condition = true; }
        if(tab_condition[1].equals("none")){ip_dstb = false;}else{ip_dstb = true;ip_dst=tab_condition[1];condition = true; }

        if(tab_condition[2].equals("none")){tcp_srcb = false;}else{tcp_srcb = true;tcp_src=Integer.parseInt(tab_condition[2]);condition = true; }
        if(tab_condition[3].equals("none")){tcp_dstb = false;}else{tcp_dstb = true;tcp_dst=Integer.parseInt(tab_condition[3]);condition = true; }

    }

    private boolean condition(Trame_info ti){
        if(!condition){return true;}
        else{
            if(ip_srcb){if (ti.ip.getIpSource().equals(ip_src)){return true;}}
            if(ip_dstb){if (ti.ip.getIpDestionation().equals(ip_dst)){return true;}}
            if(tcp_dstb){if(ti.tcp.get_dest_port() == tcp_dst){return true;}}
            if(tcp_srcb){if(ti.tcp.get_src_port() == tcp_src){return true;}}
            return false;
        }
    }
}
