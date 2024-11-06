package kwinta.gringotts.exceptions;

public class WizardNotFound extends GringottsException
{
    private String errMsg;

    public WizardNotFound()
    {
        this.errMsg = "wizard-not-found";
    }

    @Override
    public String getMessage()
    {
        return errMsg;
    }
}