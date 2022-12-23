package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Exceptions.EntryException;
import com.masai.model.Entry;

public interface EntryRepo extends JpaRepository<Entry,Integer> {
	

}
