package ru.it2g.h2o.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.it2g.h2o.entity.Catalog;

import java.math.BigDecimal;
import java.util.Optional;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {

   @Query(value = "select * from catalog " +
           "left join bottlte_racks on catalog.id = bottlte_racks.fk_catalog_id " +
           "left join coffee on catalog.id = coffee.fk_catalog_id " +
           "left join cup_holders on catalog.id = cup_holders.fk_catalog_id " +
           "left join disposable_tableware on catalog.id = disposable_tableware.fk_catalog_id " +
           "left join tea on catalog.id = tea.fk_catalog_id " +
           "left join water on catalog.id = water.fk_catalog_id " +
           "where "
   )

   Optional<Catalog> findCatalogInfoByFilter(@Param("categoryId") Long categoryId,
                                             @Param("from") BigDecimal from,
                                             @Param("to") BigDecimal to,
                                             @Param("name") String name,
                                             @Param("vendorCode") String vendorCode
   );

}
