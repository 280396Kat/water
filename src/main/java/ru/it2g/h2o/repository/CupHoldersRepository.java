package ru.it2g.h2o.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.it2g.h2o.entity.BottleRacks;
import ru.it2g.h2o.entity.CupHolders;

import java.math.BigDecimal;
import java.util.List;

public interface CupHoldersRepository extends JpaRepository<CupHolders, Long> {

    @Query(value = "select * from cup_holders where is_stock = true", nativeQuery = true)
    List<CupHolders> findAllIsStockCupHolders();

    @Query(value = "select * from cup_holders where is_stock = true", nativeQuery = true)
    List<CupHolders> findCupHoldersInfoByFilter(@Param("categoryId") Long categoryId,
                                                  @Param("from") BigDecimal from,
                                                  @Param("to") BigDecimal to,
                                                  @Param("name") String name,
                                                  @Param("vendorCode") Integer vendorCode
    );
}
