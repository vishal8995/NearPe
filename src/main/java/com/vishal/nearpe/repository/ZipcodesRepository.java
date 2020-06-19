package com.vishal.nearpe.repository;

import com.vishal.nearpe.entity.Zipcodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipcodesRepository extends JpaRepository<Zipcodes, Integer> {
}
