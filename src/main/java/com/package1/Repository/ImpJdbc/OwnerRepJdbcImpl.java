package com.package1.Repository.ImpJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.package1.Repository.OwnerRepository;
import com.package1.entity.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("ownerRepository")
public class OwnerRepJdbcImpl implements OwnerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Owner> rowMapper = new RowMapper<Owner>() {
		@Override
		public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
			Owner owner = new Owner();
			owner.setId(rs.getLong("id"));
			owner.setFirstName(rs.getString("first_name"));
			owner.setLastName(rs.getString("last_name"));
			return null;
		}
	};

	@Override
	public List<Owner> findAll() {
		String sql = "select id,first_name,last_name from owners";
		return jdbcTemplate.query(sql,rowMapper);
	}

	@Override
	public Owner findOwners(Long id) {
		return null;
	}

	@Override
	public void create(Owner owner) {

	}

	@Override
	public Owner findById(Long id) {
		String sql = "select id,first_name,last_name from owners where id = ?";
		return DataAccessUtils.singleResult(jdbcTemplate.query(sql,rowMapper,id));
	}
}
