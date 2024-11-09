package ru.it2g.h2o.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;
import ru.it2g.h2o.entity.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final RedisTemplate redisTemplate;

    public void save(Student student) {
      redisTemplate.opsForHash().put("student", student.getId(), student);
    }

    public List<Student> findAll() {
       return redisTemplate.opsForHash().values("student");
    }
}
