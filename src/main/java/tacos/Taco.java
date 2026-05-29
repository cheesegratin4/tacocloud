package tacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import jakarta.persistence.*;
import lombok.Generated;

//@Entity    //mySQL
@Data
public class Taco {

    //@Id    //MySQL
    //@GeneratedValue(strategy = GenerationType.AUTO)    //MySQL
    //private Long id;    //MySQL

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    //@ManyToMany()    //MySQL
    @Size(min=1, message="You mu7st choose at least 1 ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();

    private Date createdAt = new Date();

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

}
