package com.fact.tax.facttax.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fact.tax.facttax.model.AdminLevel;

@Repository
public class AdminRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int save(AdminLevel adminLevel) {
		return jdbcTemplate.update("insert into Cust_Admin_Level (cust_id, admin_id) values(?,?)",
				adminLevel.getCustId(), adminLevel.getAdminId());
	}

	// public List<AdminLevel> findById(Long id) {
	public List<String> getCustomerIds(int id,String adminId) {

		String query = "select * from 	Cust_Admin_Level  where level_id= "+id+" and admin_id = " + adminId;
		System.out.println("Query = "+query);

		List<String> data = jdbcTemplate.query(query, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
		return data;

	}
	
	public int saveCustAdminLevel(AdminLevel adminLevel) {
	      return jdbcTemplate.update("INSERT INTO Cust_Admin_Level(cust_id, admin_id) VALUES(?,?)", adminLevel.getCustId(), adminLevel.getAdminId());
		//return 1;
	}

	public List<AdminLevel>findUsersByDocumentLevel(String levelName){
		String query = "select * from 	admin_level  where admin_id = " + levelName;

		List<AdminLevel> data = jdbcTemplate.query(query, new RowMapper<AdminLevel>() {
			public AdminLevel mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminLevel adminLevel= new AdminLevel();
				return adminLevel;
			}
		});
		return data;
	
		
	}
	

	public List<String> getUserLevelId(int id) {

		String query = "select  level_id from 	Cust_Admin_Level  where cust_id = " + id;

		List<String> data = jdbcTemplate.query(query, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("level_id");
			}
		});
		return data;

	}

	public int updateLevelForCustmers(int[] customers, int levelId,int[]adminUserIds) {
		// level=level+1;
		// String query=
		// this.getJdbcTemplate().update(updateStatement, new Object[] {"workstation77",
		// ftpEvent.getId()});
		//if(adminUserIds)
		//for(int id :customers) {
		System.out.println("values in repo == customers= "+customers + "--> level Id = "+levelId+"   --> adminUser= "+adminUserIds);
		for(int i =0; i < customers.length;i++) {
			System.out.println("admin id = "+adminUserIds[i]);
		String updateQuery = "update Cust_Admin_Level set level_id = ? , admin_id = ? where cust_id = ?";
	//	for (int id : customers) {
			jdbcTemplate.update(updateQuery, levelId, adminUserIds[i],customers[i]);
		//}
		}
		return 1;
		/*
		 * jdbcTemplateObject.update(updateQuery, age, id);
		 * 
		 * return jdbcTemplate.update(
		 * "update Cust_Admin_Level set admin_id = ? where cust_id IN (:customers) ? "
		 * ,level, customers);
		 */
	}

}
