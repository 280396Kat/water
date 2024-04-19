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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "bottle_racks_fk_id")
    private BottleRacks bottleRack;

    @ManyToOne
    @JoinColumn(name = "coffee_fk_id_fk_id")
    private Coffee coffee;

    @ManyToOne
    @JoinColumn(name = "cup_holders_fk_id")
    private CupHolders cupHolder;

    @ManyToOne
    @JoinColumn(name = "disposable_tableware_fk_id") // переделать на без S
    private DisposableTableware disposableTableware;

    @ManyToOne
    @JoinColumn(name = "pumps_fk_id")
    private Pumps pump;

    @ManyToOne
    @JoinColumn(name = "tea_fk_id")
    private Tea tea;

    @ManyToOne
    @JoinColumn(name = "water_fk_id")
    private Water water;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product catalog = (Product) o;
        return Objects.equals(id, catalog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
