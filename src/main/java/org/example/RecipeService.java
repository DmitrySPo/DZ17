package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Transactional
    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Transactional(readOnly = true)
    public List<Recipe> findRecipesByName(String searchTerm) {
        return recipeRepository.findByNameLike(searchTerm);
    }

    @Transactional
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}