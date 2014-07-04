package com.workshare.jdbi.pagination;

import java.util.Collection;
import java.util.Iterator;

public class PaginatedDaoImpl<T> implements Iterator<Collection<T>>, Iterable<Collection<T>> {

    private final int pageSize;
    private final PaginatedDao<T> paginatedDao;
    private int currentPage;
    private final Object filter;
    private final int count;

    public PaginatedDaoImpl(PaginatedDao<T> paginatedDao, Object filter, int pageSize) {
        this.paginatedDao = paginatedDao;
        this.pageSize = pageSize;
        this.currentPage = 0;
        this.filter = filter;

        this.count = paginatedDao.count(filter);
    }

    public int getPageSize() {
        return pageSize;
    }

    public Collection<T> getPage(int pageNumber) {
        int from = pageNumber * pageSize;
        int to = from + pageSize;
        return paginatedDao.loadPage(filter, from, to);
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean hasNext() {
        float fcount = (float) count;
        float fpageSize = (float) pageSize;
        float ratio = fcount / fpageSize;
        boolean hasNext = currentPage < ratio;
        return hasNext;
    }

    @Override
    public Collection<T> next() {
        Collection<T> resultCollection = getPage(currentPage);
        currentPage++;
        return resultCollection;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub

    }

    @Override
    public Iterator<Collection<T>> iterator() {
        return new PaginatedDaoImpl<T>(paginatedDao, filter, pageSize);
    }

    public int getNumberOfPages() {
        int pages = count / pageSize;
        int elementsInLastPage = count % pageSize;
        return (elementsInLastPage == 0) ? pages : ++pages;
    }
}
