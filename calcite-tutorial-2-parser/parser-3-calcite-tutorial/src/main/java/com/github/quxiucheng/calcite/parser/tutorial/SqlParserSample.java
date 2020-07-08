package com.github.quxiucheng.calcite.parser.tutorial;

import org.apache.calcite.config.Lex;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.dialect.OracleSqlDialect;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;

/**
 * @author quxiucheng
 * @date 2019-04-22 11:45:00
 */
public class SqlParserSample {

    public static void main(String[] args) throws SqlParseException {
        parserSql();
        parserExp();

    }

    /**
     * 解析SQL
     * @throws SqlParseException
     */
    public static void parserSql() throws SqlParseException {
        // 解析配置 - mysql设置
        SqlParser.Config mysqlConfig = SqlParser.configBuilder().setLex(Lex.MYSQL).build();
        // 创建解析器
        SqlParser parser = SqlParser.create("", mysqlConfig);
        // Sql语句
        String sql = "INSERT INTO tmp_node\n" +
                "SELECT s1.id1, s1.id2, s2.val1\n" +
                "FROM source1 as s1 INNER JOIN source2 AS s2\n" +
                "ON s1.id1 = s2.id1 and s1.id2 = s2.id2 where s1.val1 > 5 and s2.val2 = 3";
        // 解析sql
        SqlNode sqlNode = parser.parseQuery(sql);
        // 还原某个方言的SQL
        System.out.println(sqlNode.toSqlString(OracleSqlDialect.DEFAULT));

    }

    /**
     * 解析表达式
     * @throws SqlParseException
     */
    public static void parserExp() throws SqlParseException {
        // 解析配置 - mysql设置
        SqlParser.Config mysqlConfig = SqlParser.configBuilder().setLex(Lex.MYSQL).build();
        String exp = "id = 1 and name='1'";
        SqlParser expressionParser = SqlParser.create(exp, mysqlConfig);
        // Sql语句
        // 解析sql
        SqlNode sqlNode = expressionParser.parseExpression();
        // 还原某个方言的SQL
        System.out.println(sqlNode.toSqlString(OracleSqlDialect.DEFAULT));
    }

}
