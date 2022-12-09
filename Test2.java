import java.io.File;
import java.io.*;

public class Test2 {
    

    public static void main(String[] args){
        String fname = "";
        try {
            fname = args[0];
        } catch (IndexOutOfBoundsException e) {
            System.err.println("cette fonction prend un argument");
        }
        Affichage a = null;
        File f = new File(fname);
        try{
            System.out.println("construction de l'affichage");
        a = new Affichage(f);
        }
        catch(IOException io){System.err.println("problèmes dans la manipulation du fichier");}

        a.makeAffichage();
        a.printGraph();
        a.printGrapheIn("out.txt");
    }
}
