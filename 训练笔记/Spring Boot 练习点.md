# Spring Boot 练习点

#### List多行删除测试

```java
public void testDelete(){
List<Integer> ids = new ArrayList<>();
ids.add(5);
ids.add(6);
ids.add(7);
int i = userMapper.deleteBatchIds(ids);
System.out.println(i);
}
@Test
public void testDeleteById(){
int i = userMapper.deleteById(8);
System.out.println(i);
}
@Test
public void testDeleteByMap(){
Map<String, Object> map = new HashMap<>();
map.put("name","提姆");
map.put("age",22);
int i = userMapper.deleteByMap(map);
System.out.println(i);
}
```

### 更新操作
```java
@Test
public void testUpdate(){
//把id为2的用户的年龄改为14
User user = new User();
user.setId(2L);
user.setAge(14);
int i = userMapper.updateById(user);
System.out.println(i);
}
```


#### 分页查询练习