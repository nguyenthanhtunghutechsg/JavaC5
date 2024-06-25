package com.hutech.tests3.Repositories;

import com.hutech.tests3.Entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, String> {
}
