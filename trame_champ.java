import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;

import java.io.IOException;

public class trame_champ {
    public ArrayList<Trame_info> trame_list = new ArrayList<Trame_info>();


    public trame_champ(File f)throws IOException{
        FileReader r = null;
        try {
            r = new FileReader(f);
            
            while(true) {
                trame_list.add(new Trame_info(new Trame(r)));   
            }


        }catch (IOException e) {
           
            r.close();
           
              
        }
            
    }

}



