package com.alfonso.ClubNautico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alfonso.ClubNautico.entity.Patron;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long>{

}
