package accounting_system.storage;

import accounting_system.model.AbstractAnimal;
import accounting_system.model.AbstractPackAnimal;
import accounting_system.model.AbstractPet;
import accounting_system.model.implement.*;
import accounting_system.model.Skill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализация интерфейса Storage
 * Хранилище реализовано на HashMap
 */
public class KennelStorage implements Storage{
    Map<Integer, AbstractAnimal> dbAnimals = new HashMap<>();

    public KennelStorage() {
        init();
    }

    private void init(){
        AbstractPet cat = new Cat("Тим", LocalDate.of(2020, 04, 22));

        int per = cat.getAge();

        cat.learnSkill(new Skill("Принести тапки"));
        cat.learnSkill(new Skill("Сидеть"));
        dbAnimals.put(cat.getId(), cat);

        AbstractPet dog = new Dog("Пушок", LocalDate.of(2019, 1, 24));
        dog.learnSkill(new Skill("Принести тапки"));
        dog.learnSkill(new Skill("Голос!"));
        dbAnimals.put(dog.getId(), dog);

        AbstractPet hamster = new Hamster("Хомяк", LocalDate.of(2024, 7, 20));
        hamster.learnSkill(new Skill("Бегать в колесе"));
        dbAnimals.put(hamster.getId(), hamster);

        AbstractPackAnimal horse = new Horse("Гнедой", LocalDate.of(2021, 2, 4));
        horse.setLoadCapacity(300);
        horse.learnSkill(new Skill("Галоп!"));
        dbAnimals.put(horse.getId(), horse);


        AbstractPackAnimal donkey = new Donkey("Нестор", LocalDate.of(2022, 8, 24));
        donkey.setLoadCapacity(500);
        donkey.learnSkill(new Skill("Каш!"));
        dbAnimals.put(donkey.getId(), donkey);

        AbstractPackAnimal camel = new Camel("Рыжий", LocalDate.of(2020, 5, 20));
        camel.setLoadCapacity(1000);
        camel.learnSkill(new Skill("КАШ!"));
        dbAnimals.put(camel.getId(), camel);
    }
    @Override
    public List<AbstractAnimal> getAllAnimals() {
        List<AbstractAnimal> result = new ArrayList<>();
        for (AbstractAnimal animal: dbAnimals.values()) {
            result.add(animal);
        }
        return result;
    }

    @Override
    public AbstractAnimal getAnimalById(int animalId) {
        return dbAnimals.getOrDefault(animalId, null);
    }

    @Override
    public boolean addAnimal(AbstractAnimal animal) {
        if (dbAnimals.containsKey(animal.getId())) {return false;}
        dbAnimals.put(animal.getId(), animal);
        return true;
    }

    @Override
    public int removeAnimal(AbstractAnimal animal) {
        if (!dbAnimals.containsKey(animal.getId())) {
            return -1;
        }
        AbstractAnimal removed = dbAnimals.remove(animal.getId());
        return removed.getId();
    }
}
