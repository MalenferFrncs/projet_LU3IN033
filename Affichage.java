import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Affichage{
    private File f;
    private Trame_champ tc;
    private String envoi;
    private String reception;
    private int nbLignes;
    private int nbTrames;


    public Affichage(File f){
        this.f=f;
        this.tc=new Trame_champ(f);
    }

    public void envoiData(){
        System.out.print();

    }

    public void recoitData(){
        System.out.println();
    }

    public void graph(){
      for(Trame s : t.trame_list){
          System.out.println();
      }
    }
}
