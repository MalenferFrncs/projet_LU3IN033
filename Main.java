import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
      String fic="";
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez saisir le nom du fichier trace: \n");
            //fic = sc.next("[\\w.-]{1,}+\\.txt");
            fic=sc.nextLine();
        }
        catch(InputMismatchException e){
            System.err.println("Nom du fichier invalide.");
        }
        File f = new File(fic);//nom du fichier
        Affichage a =null;
        try{
            a = new Affichage(f);
        }
        catch(IOException e){
            System.err.println("Affichage impossible : problème dans la manipulation du fichier.");
        }
        a.makeAffichage();
        a.printGraph();
        a.printGrapheIn("out.txt");

    }
}
