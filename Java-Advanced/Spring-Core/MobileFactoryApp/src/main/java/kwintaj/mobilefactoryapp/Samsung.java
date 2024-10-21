package kwintaj.mobilefactoryapp;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class Samsung implements Mobile
{
    @Getter
    @Setter
    private String model;

    @Override
    public void call()
    {
        System.out.println("calling from " + model);
    }
}