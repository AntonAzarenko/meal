package com.azarenka.repository;

import com.azarenka.domain.Booker;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookerRepository {

    List<Booker> getAllByUserEmail(String email);

    void save(Booker booker);
}
