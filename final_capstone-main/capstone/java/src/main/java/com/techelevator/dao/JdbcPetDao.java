package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.exception.UserNotFoundException;
import com.techelevator.model.AdoptedPetDTO;
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

import java.time.LocalDate;
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
    public List<AdoptedPetDTO> getAdoptedPets() {
        List<AdoptedPetDTO> adoptedPetList = new ArrayList<>();
        String sql = "SELECT p.pet_name, a.owner_name, a.adoption_date " +
                     "FROM pet AS p " +
                     "JOIN pet_adoption AS pa ON pa.pet_id = p.pet_id " +
                     "JOIN adoption AS a ON a.adoption_id = pa.adoption_id " +
                     "WHERE pa.adoption_id IS NOT NULL;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                AdoptedPetDTO adoptedPet = mapRowToAdoptedPetDTO(results);
                adoptedPetList.add(adoptedPet);
            }
        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Could not connect to data source");
        } catch(BadSqlGrammarException e) {
            throw new DaoException("Bad SQL grammar - Review the SQL statement syntax");
        } catch(DataIntegrityViolationException e) {
            throw new DaoException("Invalid operation - Data integrity error");
        }
        return adoptedPetList;
    }

    @Override
    public boolean create(String petName, int age, String species, String breed, int weight,
                          boolean redFlag, String gender, boolean adoptedStatus, String description) {
        String insertUserSql = "insert into pet (pet_name, age, species, breed, weight, red_flag, gender, adopted_status, description)" +
                "values (?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(insertUserSql, petName, age, species, breed, weight, redFlag,
                gender, adoptedStatus, description) == 1;
    }


    private Pet mapRowToPet(SqlRowSet rs) {
        Pet pet = new Pet();
        pet.setPetId(rs.getInt("pet_id"));
        pet.setPetName(rs.getString("pet_name"));
        pet.setAge(rs.getInt("age"));
        pet.setSpecies(rs.getString("species"));
        pet.setBreed(rs.getString("breed"));
        pet.setWeight(rs.getInt("weight"));
        pet.setRedFlag(rs.getBoolean("red_flag"));
        pet.setGender(rs.getString("gender"));
        pet.setAdoptedStatus(rs.getBoolean("adopted_status"));
        pet.setDescription(rs.getString("description"));
        return pet;
    }

    private AdoptedPetDTO mapRowToAdoptedPetDTO(SqlRowSet rs) {
        AdoptedPetDTO adoptedPetDTO = new AdoptedPetDTO();
        adoptedPetDTO.setPetName(rs.getString("pet_name"));
        adoptedPetDTO.setOwnerName(rs.getString("owner_name"));
        adoptedPetDTO.setAdoptionDate(rs.getDate("adoption_date").toLocalDate());
        return adoptedPetDTO;
    }

}
