package studyguide1;

public class InvalidNumberException extends Exception{
    private String message;
    InvalidNumberException(String message){
        this.message=message;
    }

}

