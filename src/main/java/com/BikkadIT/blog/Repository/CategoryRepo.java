package com.BikkadIT.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.BikkadIT.blog.Entities.Category;

public interface CategoryRepo  extends JpaRepository<Category, Integer> {

}
