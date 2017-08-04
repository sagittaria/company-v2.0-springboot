package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import spittr.Spitter;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private static final String INSERT_SPITTER = "insert into Spitter (id, firstname, "
            + "lastname,username, password) values (?, ?, ?, ?, ?)";
    
    private JdbcOperations jdbcOperations;
    
    @Autowired
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
    this.jdbcOperations = jdbcOperations;
    }
    
    public Spitter save(Spitter spitter) {
        jdbcOperations.update(INSERT_SPITTER,
                spitter.getId(),
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getUsername(),
                spitter.getPassword());
        return spitter;
    }
    
    public Spitter findByUsername(String username) {
        return null;
    }

}
