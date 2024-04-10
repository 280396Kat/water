package ru.it2g.h2o.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.it2g.h2o.entity.Pumps;
import ru.it2g.h2o.entity.Tea;

import java.math.BigDecimal;
import java.util.List;

public interface TeaRepository extends JpaRepository<Tea, Long> {

    @Query(value = "select * from tea where is_stock = true", nativeQuery = true)
    List<Tea> findAllIsStockTea();

    @Query(value = "select * from tea where is_stock = true", nativeQuery = true)
    List<Tea> findTeaInfoByFilter(@Param("categoryId") Long categoryId,
                                      @Param("from") BigDecimal from,
                                      @Param("to") BigDecimal to,
                                      @Param("name") String name,
                                      @Param("vendorCode") Integer vendorCode
    );
}
