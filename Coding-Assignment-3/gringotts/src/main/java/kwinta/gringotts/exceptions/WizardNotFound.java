package kwinta.gringotts.exceptions;

public class WizardNotFound extends GringottsException
{
    private String errMsg;

    public WizardNotFound()
    {
        this.errMsg = "wizard-not-found";
    }
}