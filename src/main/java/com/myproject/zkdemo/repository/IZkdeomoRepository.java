package com.myproject.zkdemo.repository;

import com.myproject.zkdemo.entity.Zkdemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IZkdeomoRepository extends JpaRepository<Zkdemo,Long> {
}
