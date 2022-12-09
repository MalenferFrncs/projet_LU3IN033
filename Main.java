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
            System.out.println("Nom du fichier non valide");
        }
        File f = new File(fic);//nom du fichier
        Affichage a = new Affichage(f);
        a.graph();

    }
}
