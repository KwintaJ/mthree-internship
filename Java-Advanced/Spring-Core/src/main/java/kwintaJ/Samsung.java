package kwintaJ;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.*;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class Samsung implements Mobile
{
    @Getter
    @Setter
    @Value("s24")
    private String model;

    @Override
    public void call()
    {
        System.out.println("calling from " + model);
    }

    /* public void setModel(String model)
    {
        this.model = model;
    }*/
}