import java.io.FileReader;
//import java.util.zip.Checksum;

public class TCP {
    private Champ src_port, des_port,seq_num,ack_num,thl_reser, ved_flags, window,
    checksum,urg_pointer,options;
    private Http data = null ;

    public TCP(FileReader r, int taille) throws WrongFileTypeException, EndOfFileException {
        try {
            src_port = new Champ(r, 2, "source port");  
            des_port = new Champ(r, 2, "destionation port");
            seq_num = new Champ(r,4,"sequence number");
            ack_num = new Champ(r, 4, "ACK number");
            thl_reser = new Champ(r,1,"thl res");
            ved_flags = new Champ(r, 1, "erv, flags");
            window = new Champ(r,2,"window");
            checksum = new Champ(r,2,"checksum");
            urg_pointer = new Champ(r, 2, "urgent pointer");
            int taille_option = (thl_reser.getInt_from_bits(0)*4)-20;
            //System.out.println(""+taille_option);
            options = new Champ(r, taille_option, "options tcp");
            data = new Http(r,(taille-(thl_reser.getInt_from_bits(0)*4)));
        } catch (Exception e) {
             //TODO: handle exception
        }
        
        

        
    }

    public int get_src_port(){
        return src_port.getInt_from_Champs();
    }

    public int get_dest_port(){
        return des_port.getInt_from_Champs();
    }

    public int get_seq_num(){
        return seq_num.getInt_from_Champs();
    }

    public int get_ack_num(){
        return ack_num.getInt_from_Champs();
    }

    public int getTHL()throws WrongFileTypeException{
       return thl_reser.getInt_from_bits(0);            
    }

    public boolean[] getflags() throws WrongFileTypeException{
        boolean[] flags = new boolean[6];
        String tmp = ved_flags.getBitsAt(0); 
        if (tmp.charAt(2)=='1' ){flags[0]=true;}
        if (tmp.charAt(3)=='1' ){flags[1]=true;}
        tmp = ved_flags.getBitsAt(1);
        if (tmp.charAt(0)=='1' ){flags[2]=true;}
        if (tmp.charAt(1)=='1' ){flags[3]=true;}
        if (tmp.charAt(2)=='1' ){flags[4]=true;}
        if (tmp.charAt(3)=='1' ){flags[5]=true;}

        return flags;
    }

    public int getWindow(){
        return window.getInt_from_Champs();
    }

    public String getCheckSum(){
        return checksum.getOctet();
    }

    public int getUrgPointer(){
        return urg_pointer.getInt_from_Champs();
    }

    public String option(){
        return "pas pris en charge lol";
    }


    public Http getdata(){
        return data;
    }
     
}
