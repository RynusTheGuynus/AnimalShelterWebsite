package com.techelevator.dao;



import com.techelevator.exception.DaoException;
import com.techelevator.model.Adoption;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JdbcAdoptionDao implements AdoptionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAdoptionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Adoption getAdoptionById(int adoptionId) {
        String sql = "SELECT * FROM adoption WHERE adoption_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, adoptionId);
        if (results.next()) {
            return mapRowToAdoption(results);
        } else {
            throw new DaoException("Adoption was not found.");
        }
    }

    @Override
    public List<Adoption> findAll() {
        List<Adoption> adoptions = new ArrayList<>();
        String sql = "select * from adoption";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Adoption adoption = mapRowToAdoption(results);
            adoptions.add(adoption);
        }
        return adoptions;
    }



    @Override
    public boolean create(int petId, String ownerName, String ownerAddress, String ownerEmail,
                          String ownerPhoneNumber, LocalDate adoptionDate) {
        String insertUserSql = "insert into adoption (pet_id, owner_name, owner_address, owner_email, owner_phone_number, adoption_date)" +
                "values (?,?,?,?,?,?)";

        return jdbcTemplate.update(insertUserSql, petId, ownerName, ownerAddress, ownerEmail,
                                  ownerPhoneNumber, adoptionDate) == 1;
    }


    private Adoption mapRowToAdoption(SqlRowSet rs) {
        Adoption adoption = new Adoption();
        adoption.setAdoptionId(rs.getInt("adoption_id"));
        adoption.setOwnerName(rs.getString("owner_name"));
        adoption.setOwnerAddress(rs.getString("owner_address"));
        adoption.setOwnerEmail(rs.getString("owner_email"));
        adoption.setOwnerPhoneNumber(rs.getString("owner_phone_number"));
        adoption.setAdoptionDate(rs.getObject("adoption_date", LocalDate.class));
        return adoption;
    }

}
