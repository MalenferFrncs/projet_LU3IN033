import java.io.FileReader;

//import javax.annotation.processing.Filer;



public class IpV4 {
    private Champ version_IHL, tos , total_length, identification, flags_fragment_offset,ttl,protocole;
    private Champ header_checksum,source_adress,destination_adress,option_padding;
    private TCP data;
    public IpV4(FileReader r){
        try{
        version_IHL = new Champ(r,1,"version et IHL");
        tos = new Champ(r,1,"TOS");
        total_length = new Champ(r,2,"total length");
        identification = new Champ(r, 2, "indentification");
        flags_fragment_offset = new Champ(r, 2, "flags fragment offset");
        ttl = new Champ(r, 1, "TTL");
        protocole = new Champ(r, 1, "protocole");
        header_checksum = new Champ(r, 2, "Header checksum");
        source_adress = new Champ(r, 4, "Source adress");
        destination_adress = new Champ(r, 4, "Destionation adress");
        int taille_option = (version_IHL.getInt_from_bits(1))-20;
        option_padding = new Champ(r, taille_option, "Option et Padding");
        data = new TCP(r);
        }catch(WrongFileTypeException e){System.out.println(e.getMessage());}
    }

    public String getOctet(){
        String s = version_IHL.getOctet()+tos.getOctet()+total_length.getOctet()+identification.getOctet();
        s += flags_fragment_offset.getOctet()+ttl.getOctet()+protocole.getOctet()+header_checksum.getOctet();
        s += source_adress.getOctet()+destination_adress.getOctet()+option_padding;
        return s;
    }

    public String getVersion(){
        String r ="";
        try{
        r = version_IHL.getBitsAt(0);
        }catch(WrongFileTypeException e){System.out.println(e.getMessage());}
        return r;
    }

    public int getTailleEntete(){
        int r =0;
        try {
        r = version_IHL.getInt_from_bits(1);
        }catch(WrongFileTypeException e){System.out.println(e.getMessage());}
        return r*4;
    }

    public String getTOS(){return tos.getOctet();}

    public String getIdentification(){return identification.getOctet();}

    public String getflag(int i) throws WrongFileTypeException{
        String bits = flags_fragment_offset.getBitsAt(0);
        String flag = ""+bits.charAt(i);
        return flag; 
        
    }

    public int getOffset() throws WrongFileTypeException{
        int offset = Integer.parseInt(getflag(3));
        for(int i=1;i<4;i++){
            offset = offset*16; // decalage de 4 bit vers la gauche
            offset+= flags_fragment_offset.getInt_from_bits(i);
        }
        return offset;
    }

    public int getTTL(){
        return ttl.getInt_from_Champs();
    }

    public String getProtocole()throws DataTypeException{
        int protid = protocole.getInt_from_Champs();
        switch(protid){
            case 6 : return "TCP";
            default : throw new DataTypeException();
        }
    }

    public String getHeaderChecksum(){
        return header_checksum.getOctet();
    }

    public String getIpSource()throws WrongFileTypeException{
        String addr = "";
        for(int i=0;i<4;i++){
            int valOctet = source_adress.getInt_from_bits(i*2);
            valOctet = valOctet*16;
            valOctet += source_adress.getInt_from_bits((i*2)+1);
            addr += valOctet;
            if(i<3){addr+=".";}

        }
        return addr;
    }

    public String getIpDestionation()throws WrongFileTypeException{
        String addr = "";
        for(int i=0;i<4;i++){
            int valOctet = destination_adress.getInt_from_bits(i*2);
            valOctet = valOctet*16;
            valOctet += destination_adress.getInt_from_bits((i*2)+1);
            addr += valOctet;
            if(i<3){addr+=".";}

        }
        return addr;
    }

    public String getOption(){
        return "les options ne sont pas prisent en chargent";
    }

    public TCP getdata(){ 
        return data ; }

    



}
