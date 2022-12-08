import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args){
        File f = new File("");//nom du fichier
        Trame_champ tc = new Trame_champ(f);

        Affichage a = new Affichage(f);

    }
}
