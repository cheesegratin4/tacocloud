package tacos.data;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import tacos.Ingredient;

public interface IngredientRespository
        extends CrudRepository<Ingredient, String> {
}
