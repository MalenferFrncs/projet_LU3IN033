import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Affichage{
    private File f;
    private Trame_champ tc;
    private Champ src;
    private Champ dst;
    private int nbLignes;
    private int nbTrames;


    public Affichage(File f){
        this.f=f;
        this.tc=new Trame_champ(f);
        src=tc.trame_list.get(0).source;
        dst=tc.trame_list.get(0).destination;
    }

    public void envoiData(){
        System.out.print();

    }

    public void recoitData(){
        System.out.println();
    }

    public void graph(){
      System.out.println(src+"\t"+dst);
      for(Trame s : t.trame_list){
          
      }
    }
}
