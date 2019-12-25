package com.azarenka.repository;

import com.azarenka.domain.Booker;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface BookerRepository {

    List<Booker> getAllByUserEmail(String email);

    void save(Booker booker);

    List<Booker> getAllByEmailAndDate(@Param("date") LocalDate date, @Param("email") String email);
}
