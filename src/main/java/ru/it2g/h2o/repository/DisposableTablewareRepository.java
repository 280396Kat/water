package ru.it2g.h2o.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.it2g.h2o.entity.CupHolders;
import ru.it2g.h2o.entity.DisposableTableware;

import java.math.BigDecimal;
import java.util.List;

public interface DisposableTablewareRepository extends JpaRepository<DisposableTableware, Long> {

    @Query(value = "select * from disposable_tableware where is_stock = true", nativeQuery = true)
    List<DisposableTableware> findAllIsStockDisposableTableware();

    @Query(value = "select * from disposable_tableware where is_stock = true", nativeQuery = true)
    List<DisposableTableware> findDisposableTablewareInfoByFilter(@Param("categoryId") Long categoryId,
                                                @Param("from") BigDecimal from,
                                                @Param("to") BigDecimal to,
                                                @Param("name") String name,
                                                @Param("vendorCode") Integer vendorCode
    );
}
