## 创建数据库
1. 在 neo4j desktop 创建名为 spring-neo4j-6-demo 的项目，或者随便什么名字
2. 创建一个名为 MarvelBooks 的数据库，或者随便什么名字
3. 运行之前创建的数据库
4. 查看数据：点击 open，打开 neo4j browser，输入 `LOAD CSV WITH HEADERS FROM "file:///marvel-data-small.csv" AS row RETURN row` 并运行
5. 导入数据：首先安装 APOC 插件（注意必须要安装），然后打开 neo4j browser 并运行 `marvel-load-data.cypher` 中的代码。
