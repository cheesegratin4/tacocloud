package tacos;

import jakarta.validation.constraints.*;
// import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.persistence.*;

import java.io.Serial;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document    //MongoDB
//@Entity    //MySQL
//@Table(name="TACO_ORDER")    //MySQL
public class TacoOrder implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)    //[JPA]
    private String id;

    private Date placedAt = new Date();

    //@ManyToOne    //[JPA]
    private User user;
    public void setUser(User user) { this.user = user; }
    public User getUser() { return user; }

    @NotNull
    @Size(min = 1, max = 100)
    @NotBlank(message = "Delivery name is required")
    private String deliveryName;

    @NotBlank(message="street is required")
    private String deliveryStreet;

    @NotBlank(message = "city is required")
    private String deliveryCity;

    @NotBlank(message = "state is required")
    private String deliveryState;

    @NotBlank(message="zip code is required")
    private String deliveryZip;

    // @CreditCardNumber(message = "Not a valid credit card number")
    // private String ccNumber;

    @NotBlank(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits (integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    //@OneToMany(cascade = CascadeType.ALL)    //MySQL
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }
}
