package com.workshare.supernova.db.sync.rails.dao.pagination.filter;


public class TestFilter {
    private final int ownerId;
    private final String uuid;

    public TestFilter(int ownerId, String uuid) {
        super();
        this.ownerId = ownerId;
        this.uuid = uuid;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getUuid() {
        return uuid;
    }
}
