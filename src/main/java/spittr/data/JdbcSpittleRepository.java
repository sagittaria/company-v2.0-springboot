package spittr.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import spittr.Spittle;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    public Spittle findOne(long id) {
        return null;
    }

}
