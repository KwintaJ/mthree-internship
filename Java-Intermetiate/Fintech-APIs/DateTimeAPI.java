import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;

import java.time.ZonedDateTime;
import java.time.ZoneId;

import java.time.Period;

import java.time.format.*;

public class DateTimeAPI
{
    public static void main(String[] args)
    {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd. MM. yyyy");

        //System.out.println(LocalDateTime.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDate.now().format(format1));

        System.out.println(ZonedDateTime.now().getZone());


        System.out.println("");
        System.out.println("Time in Los Angeles, USA:");
        System.out.println(LocalDateTime.now(ZoneId.of("America/Los_Angeles")));
    

        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(2002, 07, 9);
        Period totalYrs = Period.between(currentDate, birthDate);

        System.out.println("");
        System.out.println("I am this old:");
        System.out.println(totalYrs);
    }
}