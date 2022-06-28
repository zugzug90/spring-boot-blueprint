#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import ${package}.model.${firstModel};

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

@Repository
@Slf4j
public class Pg${firstModel}Storage implements ${firstModel}Storage {

    private static final int[] INTS = {Types.INTEGER};
    private static final int[] VARCHARS = {Types.VARCHAR};

    private final JdbcTemplate jdbc;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public ${firstModel} store(${firstModel} item) {
        return null;
        // TODO: implement me
    }

    @Override
    public ${firstModel} getById(String id) {
        return null;
        // TODO: implement me
    }

    @Override
    public boolean delete(String id) {
        return false;
        // TODO: implement me
    }

    private static Long convertToNullIfZero(ResultSet rec) throws SQLException {
        long entityId = rec.getLong("external_entity_id");
        return entityId == 0 ? null : entityId;
    }

    private static OffsetDateTime convertToOffsetDateTimeIfNotNull(ResultSet rec, String columnName, String zoneId) throws SQLException {
        Timestamp timestamp = rec.getTimestamp(columnName);
        return timestamp == null ? null : OffsetDateTime.ofInstant(Instant.ofEpochMilli(timestamp.getTime()), ZoneId.of(zoneId));
    }

    public Pg${firstModel}Storage(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbc);
    }

}
