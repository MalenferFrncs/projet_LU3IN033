
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
    public String getOctetAt(int i){
        return String.valueOf(octet.charAt(i*2))+octet.charAt((i*2)+1); 
    }
    public int getLength(){return length/2;}

    public String getBitsAt (int i) throws WrongFileTypeException{
        char c =octet.charAt(i);
        switch(c){
            case '0' : return "0000";
            case '1' : return "0001";
            case '2' : return "0010";
            case '3' : return "0011";
            case '4' : return "0100";
            case '5' : return "0101";
            case '6' : return "0110";
            case '7' : return "0111";
            case '8' : return "1000";
            case '9' : return "1001";
            case 'A' : return "1010";
            case 'B' : return "1011";
            case 'C' : return "1100";
            case 'D' : return "1101";
            case 'E' : return "1110";
            case 'F' : return "1111";
            default : throw new WrongFileTypeException();
        }
    }
    
    public String getBits(){
        String bits="";
        try{
        for(int i=0;i<length;i++){
            bits += getBitsAt(i);
        }
        }catch(WrongFileTypeException e){System.out.println(e.getMessage());}
        return bits;
    }

    public int getInt_from_bits(int i)throws WrongFileTypeException{
        char c =octet.charAt(i);
        switch(c){
            case '0' : return 0;
            case '1' : return 1;
            case '2' : return 2;
            case '3' : return 3;
            case '4' : return 4;
            case '5' : return 5;
            case '6' : return 6;
            case '7' : return 7;
            case '8' : return 8;
            case '9' : return 9;
            case 'A' : return 10;
            case 'B' : return 11;
            case 'C' : return 12;
            case 'D' : return 13;
            case 'E' : return 14;
            case 'F' : return 15;
            default : throw new WrongFileTypeException();
        }

    }

    public int getInt_from_Champs(){
        int res=0;
        try{
        for(int i=0;i<length;i++){
            res = res*16; //decalage de 4 bits vers la gauche
            res += getInt_from_bits(i);
        }
        }catch(WrongFileTypeException e){System.out.println(e.getMessage());}
        return res;

    }


    private byte getbyte_from_byte(int i)throws WrongFileTypeException{
        char c =octet.charAt(i);
        switch(c){
            case '0' : return 0;
            case '1' : return 1;
            case '2' : return 2;
            case '3' : return 3;
            case '4' : return 4;
            case '5' : return 5;
            case '6' : return 6;
            case '7' : return 7;
            case '8' : return 8;
            case '9' : return 9;
            case 'A' : return 10;
            case 'B' : return 11;
            case 'C' : return 12;
            case 'D' : return 13;
            case 'E' : return 14;
            case 'F' : return 15;
            default : throw new WrongFileTypeException();
        }

    }

    public byte getbyte_from_Champ(int i){
        byte res=0;
        i=i*2;
        try{
            res += getbyte_from_byte(i);
            res = (byte) (res*16); //decalage de 4 bits vers la gauche
            res += getbyte_from_byte(i+1);
        
        }catch(WrongFileTypeException e){System.out.println(e.getMessage());}
        return res;

    }
}