package kwinta.gringotts.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.sql.Timestamp;

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
public class Transaction 
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int transactionId;
    private int fromVault;
    private int toVault;
    private int knuts;
    private Timestamp transactionTime;
}
