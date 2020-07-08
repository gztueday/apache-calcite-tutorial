package database.test;

import org.apache.calcite.plan.RelOptUtil;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.tools.FrameworkConfig;
import org.apache.calcite.tools.RelBuilder;

/**
 * Created by zouyi on 2019/10/29.
 */
public class CalciteCoreTest {

   public static void main(String[] args) {

      final FrameworkConfig config = null;
      final RelBuilder builder = RelBuilder.create(config);
      final RelNode node = builder
              .scan("EMP")
              .build();
      System.out.println(RelOptUtil.toString(node));
   }
}
