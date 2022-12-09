import java.io.FileReader;

public class Http {
    private String[] requette;
    private int fin_entete = 0, nb_l_entete=0;
    Champ http;


    public Http(FileReader r, int taille) throws WrongFileTypeException, EndOfFileException{


        http = new Champ(r,taille,"requette http");
        int i = 0; // indice octet
        requette = new String[20];
        byte[] currentstr = new byte[200];
        int j = 0; // indice chaine
        byte currentChar = 0;
        System.out.println(""+taille);
        System.out.println(http.toString());
        while (i<taille) {
            //System.out.println(""+i);
            currentChar = http.getbyte_from_Champ(i);
            System.out.println(http.getBitsAt(i)+http.getBitsAt(i+1));
            System.out.println(""+currentChar);


            switch(currentChar){
                case 13 : if (http.getbyte_from_Champ(i+1)==10){
                    System.out.println("fin de phrase");
                    requette[nb_l_entete] = new String(currentstr);
                    nb_l_entete++;
                    for(int k = 0 ; k<j; k++){
                    currentstr[k]=0;
                    }
                    j=0;

                    if((http.getbyte_from_Champ(i+2)==13)&&(http.getbyte_from_Champ(i+3)==10)){
                        fin_entete = i+3;
                        return; // fin de l'entete
                    }else{i+=2;}
                }else{currentstr[j]=currentChar; j++;i++;}
                break;
                default : currentstr[j]=currentChar; j++;i++;break;
            }
        }
    }

    public String getRequette(){
        return requette[0];
    }

    public String getEntete(){
        String str = "";
        for (int  i = 0; i<nb_l_entete;i++){
            str+=requette[i]+"\n";
        }
        return str;
    }




}
