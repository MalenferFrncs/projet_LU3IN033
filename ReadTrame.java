import java.io.FileReader;


public class ReadTrame {

    ReadTrame(){}

    public Trame getNextTrame(FileReader f){

    Trame t;
    t = new Trame(f);
    return t;
    }

}
