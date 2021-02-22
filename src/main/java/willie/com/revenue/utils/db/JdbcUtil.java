package willie.com.revenue.utils.db;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcUtil {
    public static <T> List<T> query(DataSource dataSource, String sql, Class<T> rowMapper) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        return jdbc.query(sql, new BeanPropertyRowMapper<>(rowMapper));
    }

    public static void execute(DataSource dataSource, String sql) {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        jdbc.execute(sql);
    }
}
