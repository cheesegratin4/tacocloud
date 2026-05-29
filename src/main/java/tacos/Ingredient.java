package tacos;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.domain.Persistable;
import jakarta.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
//@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
//@Entity    //mySQL
@Document(collection = "ingredients")    //MongoDB
public class Ingredient {

    @Id
    private String id;

    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE
    }

    public Type getType() {
        return type;
    }

    public Ingredient (String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

}
