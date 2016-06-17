package id.lsa.scb.spring.integration.errorwrapper;

/**
 * Created by arifpz on 01/06/16.
 */
public class NamePatternException extends Exception {

    /**
     *
     */
    public NamePatternException() {
        super();
    }

    /**
     *
     * @param message
     */
    public NamePatternException(String message){
        super(message);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public NamePatternException(String message, Throwable cause){
        super(message, cause);
    }

    /**
     *
     * @param cause
     */
    public NamePatternException(Throwable cause){
        super(cause);
    }

}
