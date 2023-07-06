package com.easybytes.easyschool.repository;

import com.easybytes.easyschool.model.Holiday;
import com.easybytes.easyschool.rowmappers.HolidayRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Repository stereotype annotation is used to add a bean of this class
 * type to the Spring context and indicate that given Bean is used to perform
 * DB related operations and
 */
@Repository
public class HolidaysRepository {
    // Working with spring boot with JdbcTemplate it is very easy.
    // Spring Boot autoconfigures DataSource, JdbcTemplate and NamedParameterJdbcTemplate classes
    // based on the DB connection details mentioned in property file,
    // and you can @Autowired them directly into your own repository classes.
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HolidaysRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Holiday> findAllHolidays() {
        String sql = "SELECT * FROM HOLIDAYS";

        // If column names in a table and field names in pojo/bean are same/matching,
        // then we can use BeanPropertyRowMapper which is provided by Spring framework
        //var rowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);


        //return jdbcTemplate.query(sql, rowMapper);
        return jdbcTemplate.query(sql, new HolidayRowMapper());
    }
}
