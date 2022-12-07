public class Trame_info{

    public Trame trame;
    public IpV4 ip;
    public TCP tcp;
    public Http http =null;


    public Trame_info(Trame t){
        trame = t;
        ip = t.getdata();
        tcp = ip.getdata();
        http = tcp.getdata();
    }

}