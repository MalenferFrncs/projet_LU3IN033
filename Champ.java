
import java.io.FileReader;
import java.io.IOException;

public class Champ {
    private String octet="", name;
    private int length;

    public Champ( FileReader r, int length,String name)throws WrongFileTypeException{
        this.name = name;
        this.length = length*2;
        int currentChar;
        for(int i =0; i<this.length; i++){
            try{
            currentChar = r.read();
            if(currentChar==10 || currentChar == 13 || currentChar == 32){ //si on a un espace/fin de ligne/retour a la ligne 
                i--;                                               //on ignore le tour
                if(currentChar == 10){
                    for(int j=0; j<4; j++){                    // si on a un retour a la ligne
                        currentChar=r.read();                  // on retir l'offset de 4 octets
                    }
                }
            }
            else{
                if(currentChar>47 && currentChar<103){      //valeurs entier des carachtère compris entre 0 et f
                    switch (currentChar){
                        case 48 : octet +='0'; break;
                        case 49 : octet +='1'; break;
                        case 50 : octet +='2'; break;
                        case 51 : octet +='3'; break;
                        case 52 : octet +='4'; break;
                        case 53 : octet +='5'; break;
                        case 54 : octet +='6'; break;
                        case 55 : octet +='7'; break;           //convestion des entiers du flux en caractère hexa
                        case 56 : octet +='8'; break;
                        case 57 : octet +='9'; break;

                        case 65 : case 97 : octet +='A'; break;
                        case 66 : case 98 : octet +='B'; break;
                        case 67 : case 99 : octet +='C'; break;
                        case 68 : case 100 : octet +='D'; break;
                        case 69 : case 101 : octet +='E'; break;
                        case 70 : case 102 : octet +='F'; break;

                        default : throw(new WrongFileTypeException());
                    }

                }
                else{throw(new WrongFileTypeException());}  
            }
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
        
    }

    public String getName(){return name;}
    public String getOctet(){return octet;}
    public int getLength(){return length/2;}
    
}
