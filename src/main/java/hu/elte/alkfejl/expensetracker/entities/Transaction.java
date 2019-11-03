package hu.elte.alkfejl.expensetracker.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Transaction implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @NotNull
    private User owner;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private double value;

    @ManyToOne(targetEntity = Category.class)
    private Category category;

    @ManyToOne(targetEntity = Place.class)
    private Place place;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private String description;
}
