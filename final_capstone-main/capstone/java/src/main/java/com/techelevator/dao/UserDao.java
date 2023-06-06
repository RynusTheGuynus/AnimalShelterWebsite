// "The Data Access Object (DAO) pattern is a structural pattern that allows us to isolate
// the application/business layer from the persistence layer (usually a relational database
// but could be any other persistence mechanism) using an abstract API.
//
// "The API hides from the application all the complexity of performing CRUD operations in
// the underlying storage mechanism. This permits both layers to evolve separately without
// knowing anything about each other.  -- https://www.baeldung.com/java-dao-pattern

package com.techelevator.dao;

import com.techelevator.model.LoginDTO;
import com.techelevator.model.User;
import java.util.List;

public interface UserDao {



    // Data members
    List<User> findAll();
    List<User> viewPendingApplications();
    User getUserById(int userId);
    User getUserEmailById(int userId);
    User findByUsername(String username);
    int findIdByUsername(String username);
    boolean changePassword(String username, String password);
    boolean approveVolunteer(User user, int userId);
    boolean declineVolunteer(User user, int userId);

    // Methods
    boolean create(String username, String password, String role, String firstName, String lastName,
                   String emailAddress, String phoneNumber, int age, String emergencyFirstName, String emergencyLastName,
                   String emergencyPhone);

    boolean promoteToAdmin(User user, int id);

    String getRole(String username);
}
