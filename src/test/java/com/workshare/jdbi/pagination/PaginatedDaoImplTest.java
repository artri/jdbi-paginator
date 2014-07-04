package com.workshare.jdbi.pagination;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.logging.SLF4JLog;

import com.googlecode.flyway.core.Flyway;
import com.workshare.jdbi.pagination.PaginatedDaoImpl;
import com.workshare.supernova.db.sync.rails.dao.pagination.dao.TestDao;
import com.workshare.supernova.db.sync.rails.dao.pagination.filter.TestFilter;
import com.workshare.supernova.db.sync.rails.dao.pagination.model.TestPojo;

public class PaginatedDaoImplTest {
    private TestDao testDao;
    private Flyway flyway;

    private PaginatedDaoImpl<TestPojo> paginatedDaoImpl;
    private int pageSize;

    private TestFilter testFilter;

    @Before
    public void setUp() {
        DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:test", "username", "password");
        DBI dbi = new DBI(ds);
        dbi.setSQLLog(new SLF4JLog());
        Handle h = dbi.open();

        flyway = new Flyway();
        flyway.setDataSource(ds);
        flyway.setLocations("migration");
        flyway.migrate();

        testDao = dbi.open(TestDao.class);
        pageSize = 10;
        testFilter = new TestFilter(1, "uuid%");
    }

    @After
    public void quit() {
        flyway.clean();
    }

    @Test
    public void shouldPaginate() {
        createNFolders(testDao, 20);
        paginatedDaoImpl = new PaginatedDaoImpl<TestPojo>(testDao, testFilter, pageSize);

        Collection<TestPojo> resultPage = paginatedDaoImpl.getPage(0);

        Assert.assertEquals(paginatedDaoImpl.getPageSize(), resultPage.size());
    }

    @Test
    public void shouldReturnCountOfResults() {
        createNFolders(testDao, 20);
        paginatedDaoImpl = new PaginatedDaoImpl<TestPojo>(testDao, testFilter, pageSize);

        int count = paginatedDaoImpl.getCount();

        Assert.assertEquals(20, count);
    }

    @Test
    public void shouldReturn5Elements() {
        createNFolders(testDao, 25);
        paginatedDaoImpl = new PaginatedDaoImpl<TestPojo>(testDao, testFilter, pageSize);

        Collection<TestPojo> resultPage = paginatedDaoImpl.getPage(2);

        Assert.assertEquals(5, resultPage.size());
        Assert.assertEquals(3, paginatedDaoImpl.getNumberOfPages());
    }

    @Test
    public void shouldIterate3Pages() {
        createNFolders(testDao, 25);
        paginatedDaoImpl = new PaginatedDaoImpl<TestPojo>(testDao, testFilter, pageSize);

        int numberOfPages = 0;
        for (Collection<TestPojo> cirrusFolderPage : paginatedDaoImpl) {
            numberOfPages++;
        }

        Assert.assertEquals(3, numberOfPages);
        Assert.assertEquals(3, paginatedDaoImpl.getNumberOfPages());
    }

    @Test
    public void shouldIterate2Pages() {
        createNFolders(testDao, 20);
        paginatedDaoImpl = new PaginatedDaoImpl<TestPojo>(testDao, testFilter, pageSize);
        int numberOfPages = 0;

        for (Collection<TestPojo> cirrusFolderPage : paginatedDaoImpl) {
            numberOfPages++;
        }

        Assert.assertEquals(2, numberOfPages);
        Assert.assertEquals(2, paginatedDaoImpl.getNumberOfPages());
    }

    private static List<TestPojo> createNFolders(TestDao testDao, int numFolders) {
        List<TestPojo> cirrusFoldersList = new ArrayList<TestPojo>();
        for (int i = 0; i < numFolders; i++) {
            TestPojo testPojo = newTestPojo(i, false);
            cirrusFoldersList.add(testPojo);
            testDao.create(testPojo);
            System.out.println("Added CirrusFolder: " + testPojo);
        }
        return cirrusFoldersList;
    }

    public static TestPojo newTestPojo(int folderId, boolean deleted) {
        int ownerId = 1;
        return new TestPojo(folderId, "uuid-" + folderId, ownerId, "", "name", deleted);
    }
}
