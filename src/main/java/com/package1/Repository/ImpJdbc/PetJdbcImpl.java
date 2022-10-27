package com.package1.Repository.ImpJdbc;

import com.package1.Repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PetJdbcImpl implements PetRepository {

	@Autowired
	public JdbcTemplate jdbcTemplate;


	@Override
	public void deleteByOwnerId(Long owner_id) {
		String sql = "delete from owner where owner_id = ?";
		jdbcTemplate.update(sql,owner_id);

	}
}
