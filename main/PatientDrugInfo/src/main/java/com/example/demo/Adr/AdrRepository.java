package com.example.demo.Adr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdrRepository extends JpaRepository<Adr,Integer>{
}
