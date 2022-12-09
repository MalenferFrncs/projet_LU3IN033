public class Trame_info{

    public Trame trame;
    public IpV4 ip;
    public TCP tcp;
    public Http http ;


    public Trame_info(Trame t){
        trame = t;
        ip = t.getdata();
        tcp = ip.getdata();
        http = tcp.getdata();
    }

    public String envoiData(){
        String affichage ="";
        affichage += "ip : "+ip.getIpSource()+ " port : "+tcp.get_src_port();
        affichage +=  " --> " ; 
        affichage += "ip : "+ip.getIpDestionation() +" port : "+ tcp.get_dest_port();
        
        affichage += " info transimissions : ";
        
        if(http.getRequette()=="" || http.getRequette().length()>100){
            
            affichage += tcp.getflagsAffichage();
            affichage += " win : "+tcp.getWindow()+" len : "+tcp.getTailleData()+"\n";
        } else { affichage += http.getRequette()+"\n";}

        System.out.println(affichage);
        return affichage ;

    }

    public String recoitData(){
        String affichage ="";
        affichage += "ip : "+ip.getIpDestionation()+" port : "+ tcp.get_dest_port();
        affichage +=  " <-- " ; 
        affichage += "ip : "+ip.getIpSource() +" port : "+ tcp.get_src_port();
        affichage += " info transimissions : ";
        if(http.getRequette()=="" || http.getRequette().length()>100){
            affichage += tcp.getflagsAffichage();
            affichage += " win : "+tcp.getWindow()+" len : "+tcp.getTailleData()+"\n";
        } else { affichage += http.getRequette() + "\n";}
        System.out.println(affichage);
        return affichage ;
       
    }

}