package accounting_system.model.implement;

import accounting_system.model.AbstractPet;
import accounting_system.model.AnimalGenius;

import java.time.LocalDate;

public class Dog extends AbstractPet {
    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalGenius.DOG);
    }
}
