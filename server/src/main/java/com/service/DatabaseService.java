package com.service;

import com.database.QueryParam;
import org.vibur.dbcp.ViburDBCPDataSource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@ApplicationScoped
public class DatabaseService {

    private static final String DATABASE_JDBC_KEY = "mis.database.jdbc";
    private static final String DATABASE_USER_KEY = "mis.database.user";
    private static final String DATABASE_PASS_KEY = "mis.database.pass";

    private ViburDBCPDataSource vibur;

    private String databaseJDBC;
    private String databaseUser;
    private String databasePass;

    public DatabaseService() {
        this.databaseJDBC = Optional.ofNullable(System.getProperty(DATABASE_JDBC_KEY))
                .orElse("jdbc:postgresql://127.0.0.1/mis_quasar");
        this.databaseUser = Optional.ofNullable(System.getProperty(DATABASE_USER_KEY))
                .orElse("mis_quasar");
        this.databasePass = Optional.ofNullable(System.getProperty(DATABASE_PASS_KEY))
                .orElse("mis_quasar");
    }

    @PostConstruct
    public void init() {

        vibur = new ViburDBCPDataSource();
        vibur.setDriverClassName("org.postgresql.Driver");
        vibur.setJdbcUrl(databaseJDBC);
        vibur.setUsername(databaseUser);
        vibur.setPassword(databasePass);

        vibur.start();
    }

    public long executeInsertQueryWithId(String sql, QueryParam... params) throws SQLException {

        try (Connection connection = vibur.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            for (int i = 0; i < params.length; i++) {
                appendQueryParam(i + 1, params[i], statement);
            }

            int rowCount = statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next())
                return rs.getLong("id");
            else
                return -1L;

        }
    }

    public long executeInsertQuery(String sql, QueryParam... params) throws SQLException {

        try (Connection connection = vibur.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                appendQueryParam(i + 1, params[i], statement);
            }

            int rowCount = statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next())
                return rs.getLong("id");
            else
                return -1L;

        }
    }

    public <T> List<T> executeSelectQuery(
            String sql, Function<ResultSet, T> mapper, QueryParam... params) {

        try (Connection connection = vibur.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                appendQueryParam(i + 1, params[i], statement);
            }

            ResultSet rs = statement.executeQuery();

            List<T> result = new ArrayList<>();

            while (rs.next()) {

                result.add(mapper.apply(rs));

            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void appendQueryParam(int index, QueryParam param, PreparedStatement statement) throws SQLException {

        if (param.getValue() == null) {
            statement.setNull(index, param.getType());
        } else {
            statement.setObject(index, param.getValue(), param.getType());
        }

    }

    @PreDestroy
    public void clean() {
        vibur.close();
    }

}
