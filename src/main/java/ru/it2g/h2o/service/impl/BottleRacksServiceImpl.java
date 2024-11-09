package ru.it2g.h2o.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.bottleRacksDto.BottleRacksDto;
import ru.it2g.h2o.entity.BottleRacks;
import ru.it2g.h2o.mapper.BottleRacksMapper;
import ru.it2g.h2o.repository.BottleRacksRepository;
import ru.it2g.h2o.service.BottleRacksService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BottleRacksServiceImpl implements BottleRacksService {

    private final BottleRacksRepository bottleRacksRepository;

    private final BottleRacksMapper bottleRacksMapper;

    @Override
    public List<BottleRacksDto> getAllIsStockBottleRacks() {
    return bottleRacksMapper.toDto(bottleRacksRepository.findAllIsStockBottleRacks());
    }
}
