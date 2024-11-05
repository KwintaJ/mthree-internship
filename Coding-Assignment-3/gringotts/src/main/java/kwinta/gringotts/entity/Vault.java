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
public class Vault 
{
    @Id
    private int vaultNum;
    private int wizard;
    private int galleon;
    private int sickle;
    private int knut;
}