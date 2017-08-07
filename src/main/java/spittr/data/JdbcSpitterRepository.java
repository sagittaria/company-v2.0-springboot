package spittr.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spittr.Spitter;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private static final String INSERT_SPITTER = "insert into Spitter (id, firstname, "
            + "lastname,username, password) values (?, ?, ?, ?, ?)";
    
    private static final String SELECT_SPITTER_BY_USERNAME = "select id, firstname, lastname,"
            + "username, password from spitter where username=?";
    
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
        return jdbcOperations.queryForObject(SELECT_SPITTER_BY_USERNAME, new SpitterRowMapper(),username);
    }

    private static final class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spitter(rs.getLong("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"), 
                    rs.getString("username"),
                    rs.getString("password"));
        }
    }
    
}
