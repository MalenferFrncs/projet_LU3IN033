import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;

import java.io.IOException;

public class Trame_champ {
    public ArrayList<Trame_info> trame_list = new ArrayList<Trame_info>();


    public Trame_champ(File f)throws IOException{
        FileReader r = null;
        try {
            r = new FileReader(f);
            for(int j = 0 ; j<4 ; j++){
                r.read();                   // retirer le 1er offset
            }

            while(true) {
                trame_list.add(new Trame_info(new Trame(r)));
            }

        }catch(EndOfFileException eof){
            //System.out.println("la fin du document est atteinte");
            r.close();
            return ;
        }catch(WrongFileTypeException wft){

            System.err.println("veuiller mettre un fichier avec les bonnes caractèristiques en paramètre");

        }catch (IOException e) {

           System.err.println(e.getMessage());


        }finally{ r.close(); }

    }

}
