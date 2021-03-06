package com.tuya.core;

import com.tuya.core.exceptions.SqlParseException;
import com.tuya.core.model.TableInfo;
import org.junit.Test;
import scala.Tuple3;

import java.util.HashSet;

import static com.tuya.core.util.SqlParseUtil.print;

public class SqlParseTest {

    String sql1 = "alter table dwd_afterservice_feedback_item\n" +
            "add columns ( app_name        string comment 'app名称',\n" +
            "    app_owner       string  comment 'app拥有者')";

    String sql = "";
    private HashSet<TableInfo> inputTables = new HashSet<>();

    @Test
    public void sparkSqlParse() throws SqlParseException {
        System.out.println(sql);
        Tuple3<HashSet<TableInfo>, HashSet<TableInfo>, HashSet<TableInfo>> parse = new SparkSQLParse().parse(sql);
        print(parse);

    }

    @Test
    public void hiveSqlParse() throws SqlParseException {
        Tuple3<HashSet<TableInfo>, HashSet<TableInfo>, HashSet<TableInfo>> parse = new HiveSQLParse().parse(sql);
        print(parse);

    }

    @Test
    public void prestoSqlParse() throws SqlParseException {
        System.out.println(sql);
        Tuple3<HashSet<TableInfo>, HashSet<TableInfo>, HashSet<TableInfo>> parse = new PrestoSqlParse().parse(sql);
        print(parse);
    }






}
