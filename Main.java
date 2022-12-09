import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
      String fic="";
      String c="";
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
        try{
            Scanner scan= new Scanner(System.in);
            System.out.println("\nVeuillez maintenant choisir le filtre que vous voulez appliquez à votre affichage : \n Format : IP,IP Source,IP Destination,TCP,TCP Source,TCP Destination,HTTP \n Dans le cas où un filtre n'est pas à appliquer, taper none; \n");
            c=scan.nextLine();
        }
        catch(InputMismatchException e){
            System.err.println("Format non respecté");
        }
        //System.out.println(c);
        a.makeCondition(c);
        a.makeAffichage();
        a.printGraph();
        a.printGrapheIn("out.txt");

    }
}
