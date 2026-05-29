package tacos.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Ingredient;
import tacos.data.IngredientRespository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRespository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRespository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findById(id).orElse(null);
    }

}
