package sql;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectQuery;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.druid.stat.TableStat.Name;

import java.util.List;
import java.util.Map;

import static check.CheckUtil.isNotEmpty;

public class SqlCheckUtils {

    private static final String SELECT_CONSTANT = "SELECT";

    public enum SqlStatusConstant {

        NOT_SELECT("70000", "不是有效的查询语句"),
        ILLEGAL_GRAMMAR("70001", "语法不正确"),
        HIGH_RISK("70002", "高危语句"),
        MULTI_SQL("70003", "多条语句");

        private String code;
        private String msg;

        private SqlStatusConstant(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 检查是否是合法的查询语句
     *
     * @param sql
     * @param databaseType
     * @return
     */
    public static Boolean checkSelectSql(String sql, String databaseType) throws Exception {
        List<SQLStatement> statements = null;
        statements = SQLUtils.parseStatements(sql, databaseType);

        if (isNotEmpty(statements)) {

            if (statements.size() > 1) {
                throw new Exception(SqlStatusConstant.MULTI_SQL.getMsg());
            }

            String operateType = "";
            SQLStatement stmt = statements.get(0);
            MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
            stmt.accept(visitor);
            Map<Name, TableStat> map = visitor.getTables();
            for (Map.Entry<Name, TableStat> entry : map.entrySet()) {
                operateType = entry.getValue().toString().toLowerCase();
            }

            if (!SELECT_CONSTANT.equals(operateType.toUpperCase()))
                throw new Exception(SqlStatusConstant.NOT_SELECT.getMsg());

            //解析where条件，禁止 where 1=1  的高危条件
            SQLSelectStatement ss = (SQLSelectStatement) statements.get(0);
            SQLSelectQuery query = ss.getSelect().getQuery();
            if (query instanceof SQLSelectQueryBlock) {
                SQLSelectQueryBlock qb = (SQLSelectQueryBlock) query;
                if (qb.getWhere() == null) {
                    throw new Exception(SqlStatusConstant.HIGH_RISK.getMsg() + "," + "sql语句没有where条件");
                }
            }
        }

        return Boolean.TRUE;
    }


}
