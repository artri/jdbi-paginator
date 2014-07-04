package com.workshare.jdbi.pagination;

import java.util.Collection;

public interface PaginatedDao<T> {
    abstract Collection<T> loadPage(Object filter, int lastId, int pageSize);

    abstract int count(Object filter);
}
