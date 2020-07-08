package database.csv;

import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaFactory;
import org.apache.calcite.schema.SchemaPlus;

import java.util.Map;

/**
 * Schema，是table和function的名称空间，它是一个可嵌套的结构，Schema还可以有subSchema，
 * 理论上可以无限嵌套，但一般不会这么做。Schema可以理解成Database，Database下面有table，
 * 这样就和传统数据库的概念联系起来了，在Calcite中，顶层的Schema是root，自定义的Schema是root的subSchema，
 * 同时还可以设置defaultSchema，类似我们使用数据库时，使用use database命令以后就不用再输入database名字前缀。
 * <p>
 * Table，就很好理解了，就是数据库中的表。在table描述了字段名以及相应的类型、表的统计信息，例如表有多少条记录等等，
 * 这里先不展开讲。另外重要的是数据文件的存储以及如何扫描读取数据文件。
 */
public class CsvSchemaFactory implements SchemaFactory {

   /**
    * parentSchema 他的父节点，一般为root
    * name     数据库的名字，它在model中定义的
    * operand  也是在mode中定义的，是Map类型，用于传入自定义参数。
    */
   @Override
   public Schema create(SchemaPlus parentSchema, String name, Map<String, Object> operand) {
      return new CsvSchema(String.valueOf(operand.get("dataFile")));
   }
}
