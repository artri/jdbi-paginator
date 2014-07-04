package com.workshare.supernova.db.sync.rails.dao.pagination.model;

/**
 * this is CirrusFolder.
 * 
 * @author francescq
 * 
 */
public class TestPojo {
    private final int cirrusId;
    private final String uuid;
    private final long ownerId;
    private final String ancestry;
    private final String name;
    private final boolean deleted;

    public TestPojo(int id, String uuid, long ownerId, String ancestry, String name, boolean deleted) {
        super();
        this.cirrusId = id;
        this.uuid = uuid;
        this.ownerId = ownerId;
        this.ancestry = ancestry;
        this.name = name;
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getName() {
        return name;
    }

    public Integer getCirrusId() {
        return cirrusId;
    }

    public String getUuid() {
        return uuid;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getAncestry() {
        return ancestry;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cirrusId;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TestPojo other = (TestPojo) obj;
        if (cirrusId != other.cirrusId) {
            return false;
        }
        if (uuid == null) {
            if (other.uuid != null) {
                return false;
            }
        } else if (!uuid.equals(other.uuid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TestPojo [cirrusId=" + cirrusId + ", uuid=" + uuid + ", ownerId=" + ownerId + ", ancestry=" + ancestry + ", name=" + name + ", deleted=" + deleted + "]";
    }
}
