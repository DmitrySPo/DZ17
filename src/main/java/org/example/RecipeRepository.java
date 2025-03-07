package org.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("FROM Recipe r WHERE lower(r.name) LIKE lower(concat('%', ?1, '%'))")
    List<Recipe> findByNameLike(String searchTerm);
}