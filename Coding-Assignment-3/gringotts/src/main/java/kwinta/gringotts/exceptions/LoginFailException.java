package kwinta.gringotts.exceptions;

public class LoginFailException extends GringottsException
{
    private String errMsg;

    public LoginFailException(String errMsg)
    {
        this.errMsg = errMsg;
    }
}