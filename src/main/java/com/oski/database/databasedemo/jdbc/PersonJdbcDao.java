package com.oski.database.databasedemo.jdbc;

import com.oski.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthdate(rs.getTimestamp("birth_date"));
            return person;
        }
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM PERSON", new PersonRowMapper());
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE ID=?", new Object[]{id}, new PersonRowMapper());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM PERSON WHERE ID=?", new Object[]{id});
    }

    public int insert(Person person) {
        return jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (?, ?, ?, ?)",
                new Object[]{person.getId(), person.getName(),person.getLocation(),new Timestamp(person.getBirthdate().getTime())});
    }

    public int update(Person person) {
        return jdbcTemplate.update("UPDATE PERSON " +
                        "SET NAME = ?, LOCATION = ?, BIRTH_DATE = ? " +
                        "WHERE ID = ?",
                new Object[]{person.getName(),person.getLocation(),new Timestamp(person.getBirthdate().getTime()), person.getId()});
    }

}