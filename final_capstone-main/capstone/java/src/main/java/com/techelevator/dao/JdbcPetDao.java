// "DAO is an abstraction for accessing data, the idea is to separate the technical
// details of data access from the rest of the application. It can apply to any kind
// of data.
//
// "JDBC is an API for accessing relational databases using Java.
//
// "JDBC is more low-level than an ORM, it maps some Java types to SQL types but no
// more than that, it just takes DDL and DML, executes it, and returns result sets."
// -- Nathan Hughes, https://stackoverflow.com/questions/7070467/dao-and-jdbc-relation

package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.AdoptedPetDTO;
import com.techelevator.model.AvailablePetDTO;
import com.techelevator.model.Pet;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcPetDao implements PetDao {

    // Data members
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
        String sql = "SELECT p.pet_name, a.owner_name, a.adoption_date, pi.image_path " +
                "FROM pet AS p " +
                "JOIN pet_adoption AS pa ON pa.pet_id = p.pet_id " +
                "JOIN adoption AS a ON a.adoption_id = pa.adoption_id " +
                "JOIN pet_image AS pi ON pi.pet_id = p.pet_id " +
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
    public List<AvailablePetDTO> getAvailablePets() {
        List<AvailablePetDTO> availablePetList = new ArrayList<>();
        String sql = "SELECT p.pet_name, p.species, p.breed, p.age, MIN(pi.image_path) AS image_path " +
                "FROM pet AS p " +
                "LEFT JOIN pet_image AS pi ON pi.pet_id = p.pet_id " +
                "WHERE p.adopted_status = false " +
                "GROUP BY p.pet_id, p.pet_name, p.species, p.breed, p.age " +
                "ORDER BY p.pet_name ASC;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                AvailablePetDTO availablePet = mapRowToAvailablePetDTO(results);
                if (results.getString("image_path") == null) {
                    availablePet.setImagePath("https://res.cloudinary.com/doliuuvrv/image/upload/v1685946485/Animal%20Shelter/placeholder-image_npzf77.jpg");
                }
                availablePetList.add(availablePet);
            }
        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Could not connect to data source");
        } catch(BadSqlGrammarException e) {
            throw new DaoException("Bad SQL grammar - Review the SQL statement syntax");
        } catch(DataIntegrityViolationException e) {
            throw new DaoException("Invalid operation - Data integrity error");
        }
        return availablePetList;
    }

    @Override
    public boolean create(String petName, int age, String species, String breed, int weight,
                          boolean redFlag, String gender, boolean adoptedStatus, String description) {
        String insertUserSql = "insert into pet (pet_name, age, species, breed, weight, red_flag, gender, adopted_status, description)" +
                "values (?,?,?,?,?,?,?,?,?)";
        try {
            return jdbcTemplate.update(insertUserSql, petName, age, species, breed, weight, redFlag,
                    gender, adoptedStatus, description) == 1;
        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Could not connect to data source");
        } catch(BadSqlGrammarException e) {
            throw new DaoException("Bad SQL grammar - Review the SQL statement syntax");
        } catch(DataIntegrityViolationException e) {
            throw new DaoException("Invalid operation - Data integrity error");
        }
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
        adoptedPetDTO.setImagePath(rs.getString("image_path"));
        return adoptedPetDTO;
    }

    private AvailablePetDTO mapRowToAvailablePetDTO(SqlRowSet rs) {
        AvailablePetDTO availablePetDTO = new AvailablePetDTO();
        availablePetDTO.setPetName(rs.getString("pet_name"));
        availablePetDTO.setSpecies(rs.getString("species"));
        availablePetDTO.setBreed(rs.getString("breed"));
        availablePetDTO.setAge(rs.getInt("age"));
        availablePetDTO.setImagePath(rs.getString("image_path"));
        return availablePetDTO;
    }

}
