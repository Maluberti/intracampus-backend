package com.laurp.intracampus.repositories;

import com.laurp.intracampus.Domain.Atletica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtleticaRepository extends JpaRepository<Atletica, Long> {
}
