package com.workshare.supernova.db.sync.rails.dao.pagination.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.workshare.supernova.db.sync.rails.dao.pagination.model.TestPojo;

public class TestPojoResultSetMapper implements ResultSetMapper<TestPojo> {

    @Override
    public TestPojo map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        String ancestry = r.getString("ancestry") == null ? "" : r.getString("ancestry");
        String name = r.getString("name");
        final boolean deleted = r.getBoolean("is_deleted");
        return new TestPojo(r.getInt("id"), r.getString("uuid"), r.getLong("owner_id"), ancestry, name, deleted);
    }
}
