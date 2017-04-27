package by.htp.selen.Exeption;

/**
 * Created by user on 24.03.17.
 */
public class UnknownDriverTypeExeption extends RuntimeException {
    private static final long serialVersionUID = -2223342345234423234L;

    public UnknownDriverTypeExeption(String msg){
        super(msg);
    }


}
