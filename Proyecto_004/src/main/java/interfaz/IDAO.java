package interfaz;



import java.sql.Connection;
import java.sql.SQLException;

public interface IDAO<T> {
    void create(Connection connection, T entity) throws SQLException;

    T read(Connection connection, int id) throws SQLException;

    void update(Connection connection, T entity) throws SQLException;

    void delete(Connection connection, int id) throws SQLException;

    void createTable(Connection connection) throws SQLException;
}

