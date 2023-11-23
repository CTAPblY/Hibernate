package org.example;

import org.example.hibernate.entity.Numb;
import org.example.hibernate.entity.Service;
import org.hibernate.tool.schema.spi.SqlScriptException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws SqlScriptException {
        Service service = new Service();
//        Numb numb = new Numb(4, "+36", "Hungry");
//        service.save(numb);
        for (Numb number : service.getAll()){
            if (number.getId() == 1)
                System.out.printf("%-5s %-10s  %-10s %n", "id", "country", "numb");
            System.out.printf("%-5d %-10s %-10s %n", number.getId(), number.getCountry(), number.getNumb());
        }
    }
}