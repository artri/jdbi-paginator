package com.workshare.supernova.db.sync.rails.dao.pagination.dao;

import java.util.Collection;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.workshare.jdbi.pagination.PaginatedDao;
import com.workshare.supernova.db.sync.rails.dao.pagination.mapper.TestPojoResultSetMapper;
import com.workshare.supernova.db.sync.rails.dao.pagination.model.TestPojo;

@RegisterMapper(TestPojoResultSetMapper.class)
public interface TestDao extends PaginatedDao<TestPojo> {
    public static final String readByOwnerIdPaginated = "SELECT id, uuid, owner_id, ancestry, name, is_deleted FROM folders WHERE owner_id = :ownerId AND uuid LIKE :uuid order BY id ASC LIMIT :start,:size";
    public static final String countByOwnerId = "SELECT count(1) FROM folders WHERE owner_id = :ownerId and is_deleted = false";
    public static final String create = "INSERT INTO folders (id, uuid, owner_id, ancestry, name, is_deleted) values (:cirrusId, :uuid, :ownerId, :ancestry, :name, :deleted)";

    @SqlUpdate(create)
    void create(@BindBean TestPojo account);

    @SqlQuery(readByOwnerIdPaginated)
    @Override
    public Collection<TestPojo> loadPage(@BindBean Object filter, @Bind("start") int start, @Bind("size") int pageSize);

    @SqlQuery(countByOwnerId)
    @Override
    public int count(@BindBean Object filter);
}
