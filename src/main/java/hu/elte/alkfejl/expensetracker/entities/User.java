package hu.elte.alkfejl.expensetracker.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String username;

    @Column()
    @NotNull
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    public List<Transaction> transactions;

    public enum Role {
        ROLE_ADMIN, ROLE_OWNER
    }
}
