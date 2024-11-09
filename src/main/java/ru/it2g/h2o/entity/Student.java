package ru.it2g.h2o.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("student")
@Data
public class Student {

    @Id
    private String id;

    private String name;
}
