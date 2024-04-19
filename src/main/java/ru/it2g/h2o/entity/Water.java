package ru.it2g.h2o.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Water {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "vendor_code")
    private Integer vendorCode;

    @Column(name = "is_stock")
    private Boolean isStock;

    @Column(name = "displacement")
    private Double displacement;

    @OneToMany
    @JoinColumn(name = "water")
    private List<Product> product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Water water = (Water) o;
        return Objects.equals(id, water.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
