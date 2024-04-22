package com.Sunnxt.Functions.Repository;

import com.Sunnxt.Functions.Entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<Search, Integer> {
    // Define custom query methods if needed
}
