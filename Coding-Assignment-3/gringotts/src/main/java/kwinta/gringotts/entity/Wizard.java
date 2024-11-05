package kwinta.gringotts.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Wizard 
{
    @Id
    private int id;
    private String name;
    private String password;
}
