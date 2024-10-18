package kwintaJ;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Component
public class Iphone implements Mobile
{
    private String model;

    @Override
    public void call()
    {
        System.out.println("calling from " + model);
    }

    public void setModel(String model)
    {
        this.model = model;
    }
}