import java.io.FileReader;

public class Http {
    private String[] requette;
    private int fin_entete = 0, nb_l_entete=0;
    

    public Http(FileReader r, int taille) throws WrongFileTypeException{
        
        Champ http;
        http = new Champ(r,taille,"requette http");
        int i = 0; // indice octet
        requette = new String[20];       
        byte[] currentstr = new byte[75];
        int j = 0; // indice chaine
        byte currentChar = 0;
        while (i<taille) {
            currentChar = http.getbyte_from_Champ(i);
            switch(currentChar){
                case 10 : if (http.getbyte_from_Champ(i+1)==13){
                    requette[nb_l_entete] = new String(currentstr);
                    nb_l_entete++;
                    currentstr = new byte[75];
                    j=0;
                    i+=2;
                    if((http.getbyte_from_Champ(i+2)==10)&&(http.getbyte_from_Champ(i+3)==13)){
                        fin_entete = i+3;                        
                        return; // fin de l'entete
                    }
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
