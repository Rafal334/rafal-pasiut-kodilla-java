package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredPostTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS set vip_level = \"not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.execute(sqlUpdate);

        //When
        String sqlProcedure = "Call UpdateVipLevels()";
        statement.execute(sqlProcedure);

        //Then
        String checkSql = "Select count(*) AS NOT_SET_COUNT from readers where vip_level = \"not set\"";
        ResultSet result = statement.executeQuery(checkSql);
        int count = -1;
        if (result.next()) {
            count = result.getInt("NOT_SET_COUNT");
        }
        Assert.assertEquals(0, count);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS set BESTSELLER = null";
        Statement statement = dbManager.getConnection().createStatement();
        statement.execute(sqlUpdate);

        //When
        String sqlProcedure = "Call UpdateBestsellers()";
        statement.execute(sqlProcedure);

        //Then
        String checkSql = "Select count(*) AS NOT_SET_COUNT from books where bestseller is null";
        ResultSet result = statement.executeQuery(checkSql);
        int count = -1;
        if (result.next()) {
            count = result.getInt("NOT_SET_COUNT");
        }
        Assert.assertEquals(0, count);
    }
}
