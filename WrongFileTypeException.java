public class WrongFileTypeException extends Exception{
    public WrongFileTypeException(){
        super("Le fichier n'est pas au format exadecimal");
    }
}