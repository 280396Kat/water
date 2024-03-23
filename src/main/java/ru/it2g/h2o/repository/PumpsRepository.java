package ru.it2g.h2o.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.it2g.h2o.entity.DisposableTableware;
import ru.it2g.h2o.entity.Pumps;

import java.math.BigDecimal;
import java.util.List;

public interface PumpsRepository extends JpaRepository<Pumps, Long> {

    @Query(value = "select * from pumps where is_stock = true", nativeQuery = true)
    List<Pumps> findAllIsStockPumps();

    List<Pumps> findPumpsInfoByFilter(@Param("categoryId") Long categoryId,
                                                                  @Param("from") BigDecimal from,
                                                                  @Param("to") BigDecimal to,
                                                                  @Param("name") String name,
                                                                  @Param("vendorCode") String vendorCode
    );
}
