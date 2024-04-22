package com.Sunnxt.Functions.Repository;

import com.Sunnxt.Functions.Entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Integer> {
    // Define custom query methods if needed
}
