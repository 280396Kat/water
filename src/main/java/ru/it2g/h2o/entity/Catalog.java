package ru.it2g.h2o.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "catalog")
    private List<BottleRacks> bottleRacks;

    @OneToMany(mappedBy = "catalog")
    private List<Coffee> coffees;

    @OneToMany(mappedBy = "catalog")
    private List<CupHolders> cupHolders;

    @OneToMany(mappedBy = "catalog")
    private List<DisposableTableware> disposableTablewares;

    @OneToMany(mappedBy = "catalog")
    private List<Pumps> pumps;

    @OneToMany(mappedBy = "catalog")
    private List<Tea> teas;

    @OneToMany(mappedBy = "catalog")
    private List<Water> waters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(id, catalog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
