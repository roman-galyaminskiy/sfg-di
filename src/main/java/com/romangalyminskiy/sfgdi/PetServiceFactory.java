package com.romangalyminskiy.sfgdi;

import com.romangalyminskiy.sfgdi.services.*;

public class PetServiceFactory {

    public PetService getPetService(String petType) {
        return switch (petType) {
            case "cat" -> new CatPetService();
            case "dog" -> new DogPetService();
            default -> null;
        };
    }
}
