package com.mantis.schoolRegistrationSystem.repository;

import com.mantis.schoolRegistrationSystem.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {
    List<Adress> findByCity(String city);
    List<Adress> findByCountry (String country);
}
