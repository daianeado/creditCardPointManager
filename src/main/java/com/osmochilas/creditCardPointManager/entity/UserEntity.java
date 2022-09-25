package com.osmochilas.creditCardPointManager.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="cpf")
    private String cpf;

    @Column(name="createdat")
    private LocalDate createdAt;

    @OneToMany
    @JoinColumn(name = "user", insertable = false, updatable = false)
    @Transient
    private List<CreditCardEntity> creditCards;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEntity that = (UserEntity) o;
        return cpf != null && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
