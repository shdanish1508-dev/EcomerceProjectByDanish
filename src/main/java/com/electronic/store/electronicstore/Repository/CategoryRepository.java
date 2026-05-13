package com.electronic.store.electronicstore.Repository;

import com.electronic.store.electronicstore.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long>
{

}
