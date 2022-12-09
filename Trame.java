import java.io.FileReader;


public class Trame {
    private Champ destination,source,type;
    private IpV4 data;
    
   
    Trame(FileReader r)throws WrongFileTypeException, EndOfFileException{
        //try{
            //preambule = new Champ(r,8,"preambule"); 
            destination = new Champ(r, 6, "destination");
            source = new Champ(r,6,"source");
            type = new Champ(r,2,"champ");
            data = new IpV4(r);
            //crc = new Champ(r,4,"CRC");


        //}catch(WrongFileTypeException e){
        //    System.out.println(e.getMessage());
        //}
    }


    public String getDataType() throws DataTypeException{
        String s = type.getOctet();
        switch (s){
            case "0800" : return "IP";
            //case "0806" : return "ARP";
            default : throw new DataTypeException();
        } 
    }

    private String getMacAdr(Champ c){
        String s = c.getOctet();
        String r = "";
        int i = 1;
            while(i<s.length()){
                r+=s.charAt(i);
                if(i%2==0){
                    r+=':';
                }
            }
    
        return r;
    }

    public String getAdrDest(){
        return getMacAdr(destination);
    }

    public String getAdrSource(){
        return getMacAdr(source);
    }

    public String getOctet(){
        return preambule.getOctet()+destination.getOctet()+source.getOctet()+type.getOctet()+data.getOctet()+crc.getOctet();
    }

    public IpV4 getdata(){
        return data;
    }
    


    
}
