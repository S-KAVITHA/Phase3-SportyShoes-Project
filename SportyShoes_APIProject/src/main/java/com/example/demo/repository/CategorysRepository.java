package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Categorys;

//@author Kavitha S


@Repository
public interface CategorysRepository extends CrudRepository<Categorys, Integer>{

	@EntityGraph(value = "graph.Categorys.products", type = EntityGraphType.LOAD)
	List<Categorys> findBycategoryId(int category);	
	
}