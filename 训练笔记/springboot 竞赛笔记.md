# SpringBoot Mybatis Plus 竞赛笔记

#### 默认情况下MP操作的表名就是实体类的类名，但是如果表名和类名不一致就需要我们自己设置映射规则。
#### 可以在实体类的类名上加上@TableName注解进行标识。

```java
@TableName("tb_user")
public class User {
//....
}
```
  

### 全局设置表名前缀
```yaml
mybatis-plus:
    global-config:
        db-config:
            #表名前缀
            table-prefix: tb_
```

#### 默认情况下使用MP插入数据时，如果在我们没有设置主键生成策略的情况下默认的策略是基于雪花算法的自增id。
#### 如果我们需要使用别的策略可以在定义实体类时，在代表主键的字段上加上 @TableId 注解，使用其type 属性指定主键生成策略。

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
@TableId(type = IdType.AUTO)
private Long id;
//.....
}
```

#### 全部主键策略定义在了枚举类 IdType 中， IdType 有如下的取值
```java
AUTO
数据库ID自增，依赖于数据库。该类型请确保数据库设置了 ID自增 否则无效
NONE
未设置主键类型。若在代码中没有手动设置主键，则会根据主键的全局策略自动生成（默认的主键全局策略是基于雪花算法的自增ID）
INPUT
需要手动设置主键，若不设置。插入操作生成SQL语句时，主键这一列的值会是 null 。
ASSIGN_ID
当没有手动设置主键，即实体类中的主键属性为空时，才会自动填充，使用雪花算法
ASSIGN_UUID
当实体类的主键属性为空时，才会自动填充，使用UUID
```

#### 全局配置id生成策略
```yaml
mybatis-plus:
    global-config:
        db-config:
    # id生成策略 auto为数据库自增
        id-type: auto
```

#### 设置字段映射关系

```java
@TableField("address")
private String addressStr;

```

#### 设置字段和列名的驼峰映射
```yaml
mybatis-plus:
    configuration:
    #是否开启自动驼峰命名规则（camel case）映射，即从经典数据库列名 A_COLUMN（下划线命名）到经典 Java 属性名 aColumn（驼峰命名） 的类似映射
    map-underscore-to-camel-case: false
```

#### 日志打印
```yaml
mybatis-plus:
    configuration:
        # 日志
        log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```



#### 有Where的查询在Mapper里面实现，没有Where的查询在Service里面实现  
---

#### 路径转义后返回给前端
```java
String url = "C:\\Users\\admin\\Desktop";
String jsUrl = url.replace("\\", "/");
```