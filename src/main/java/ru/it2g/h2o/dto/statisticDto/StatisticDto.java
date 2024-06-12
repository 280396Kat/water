package ru.it2g.h2o.dto.statisticDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticDto {

    private String name;

    private Integer countSession;
}

