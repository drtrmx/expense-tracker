package hu.elte.alkfejl.expensetracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "places")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Place implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transaction> transactions;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Category.class, cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST
            })
    @JoinTable(name = "categories_places",
            joinColumns = {@JoinColumn(name ="place_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    @JsonIgnore
    private List<Category> categories;
}
