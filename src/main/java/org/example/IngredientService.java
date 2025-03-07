package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Transactional
    public void saveIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    @Transactional(readOnly = true)
    public Optional<Ingredient> getIngredientById(Long id) {
        return ingredientRepository.findById(id);
    }

    @Transactional
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}