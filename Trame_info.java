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

        if(!isHttp()){

            affichage += "TCP : "+tcp.getflagsAffichage();
            affichage += " win : "+tcp.getWindow()+" len : "+tcp.getTailleData()+"seq :"+tcp.get_seq_num()+"ack :"+tcp.get_ack_num()+"\n";
        } else { affichage += "HTTP : "+ http.getRequette()+"\n";}


        return affichage ;

    }

    public String recoitData(){
        String affichage ="";
        affichage += "ip : "+ip.getIpDestionation()+" port : "+ tcp.get_dest_port();
        affichage +=  " <-- " ;
        affichage += "ip : "+ip.getIpSource() +" port : "+ tcp.get_src_port();
        affichage += " info transimissions : ";
        if(!isHttp()){
            affichage += "TCP : "+tcp.getflagsAffichage();
            affichage += " win : "+tcp.getWindow()+" len : "+tcp.getTailleData()+"seq :"+tcp.get_seq_num()+"ack :"+tcp.get_ack_num()+"\n";
        } else { affichage += "HTTP : "+ http.getRequette() + "\n";}

        return affichage ;

    }

    private boolean isHttp(){
        String s = http.getRequette();

        if (s.equals("")){return false;}
        else{
            String str =s.substring(0, 1);
            if(str.equals("H")){if (s.substring(1, 2).equals("T")){return false;}
                                else {return true;} }
            if(str.equals("G")){return true;}
            if(str.equals("D")){return true;}
            if(str.equals("H")){return true;}
            return false;
        }
    }
}
