package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.exception.UserNotFoundException;
import com.techelevator.model.Pet;
import com.techelevator.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Component
public class JdbcPetDao implements PetDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pet getPetById(int petId) {
        String sql = "SELECT * FROM pet WHERE pet_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);
        if (results.next()) {
            return mapRowToPet(results);
        } else {
            throw new DaoException("Pet was not found.");
        }
    }

    @Override
    public List<Pet> findAll() {
        List<Pet> pets = new ArrayList<>();
        String sql = "select * from pet";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Pet pet = mapRowToPet(results);
            pets.add(pet);
        }

        return pets;
    }



    @Override
    public boolean create(String petName, int age, String species, int weight, boolean redFlag, String gender, boolean adoptedStatus) {
        String insertUserSql = "insert into pet (pet_name, age, species, weight, red_flag, gender, adopted_status)" +
                "values (?,?,?,?,?,?,?)";

        return jdbcTemplate.update(insertUserSql, petName, age, species, weight, redFlag,
                gender, adoptedStatus) == 1;
    }


    private Pet mapRowToPet(SqlRowSet rs) {
        Pet pet = new Pet();
        pet.setPetId(rs.getInt("pet_id"));
        pet.setPetName(rs.getString("pet_name"));
        pet.setAge(rs.getInt("age"));
        pet.setSpecies(rs.getString("species"));
        pet.setWeight(rs.getInt("weight"));
        pet.setRed_flag(rs.getBoolean("red_flag"));
        pet.setGender(rs.getString("gender"));
        pet.setAdoptedStatus(rs.getBoolean("adopted_status"));
        return pet;
    }

}
