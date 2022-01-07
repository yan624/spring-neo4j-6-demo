# 创建数据库
1. 在 neo4j desktop 创建名为 spring-neo4j-6-demo 的项目，或者随便什么名字
2. 创建一个名为 MarvelBooks 的数据库，或者随便什么名字
3. 运行之前创建的数据库
4. 查看数据：点击 open，打开 neo4j browser，输入 `LOAD CSV WITH HEADERS FROM "file:///marvel-data-small.csv" AS row RETURN row` 并运行
5. 导入数据：首先安装 APOC 插件（注意必须要安装），然后打开 neo4j browser 并运行 `marvel-load-data.cypher` 中的代码。

// 为两个已知结点建立两条关系
OPTIONAL MATCH (hlp:`ComicIssue`) WHERE id(hlp) = $__id__ WITH hlp WHERE hlp IS NULL CREATE (comicIssue:`ComicIssue`) SET comicIssue = $__properties__ RETURN comicIssue UNION MATCH (comicIssue:`ComicIssue`) WHERE id(comicIssue) = $__id__ SET comicIssue += $__properties__ RETURN comicIssue
MATCH (startNode)-[rel:`INCLUDES`]->(:`Character`) WHERE (id(startNode) = $fromId AND NOT (id(rel) IN $__knownRelationShipIds__)) DELETE rel
MATCH (startNode)-[rel:`INCLUDES`]->(:`Character`) WHERE (id(startNode) = $fromId AND NOT (id(rel) IN $__knownRelationShipIds__)) DELETE rel

OPTIONAL MATCH (hlp:`Character`) WHERE id(hlp) = $__id__ WITH hlp WHERE hlp IS NULL CREATE (character:`Character`) SET character = $__properties__ RETURN character UNION MATCH (character:`Character`) WHERE id(character) = $__id__ SET character += $__properties__ RETURN character
MATCH (startNode) WHERE id(startNode) = $fromId MATCH (endNode) WHERE id(endNode) = $toId MERGE (startNode)-[relProps:`INCLUDES`]->(endNode) RETURN id(relProps)
OPTIONAL MATCH (hlp:`Character`) WHERE id(hlp) = $__id__ WITH hlp WHERE hlp IS NULL CREATE (character:`Character`) SET character = $__properties__ RETURN character UNION MATCH (character:`Character`) WHERE id(character) = $__id__ SET character += $__properties__ RETURN character
MATCH (startNode) WHERE id(startNode) = $fromId MATCH (endNode) WHERE id(endNode) = $toId MERGE (startNode)-[relProps:`INCLUDES`]->(endNode) RETURN id(relProps)

**// 为一个已知结点建立一条关系
OPTIONAL MATCH (hlp:`ComicIssue`) WHERE id(hlp) = $__id__ WITH hlp WHERE hlp IS NULL CREATE (comicIssue:`ComicIssue`) SET comicIssue = $__properties__ RETURN comicIssue UNION MATCH (comicIssue:`ComicIssue`) WHERE id(comicIssue) = $__id__ SET comicIssue += $__properties__ RETURN comicIssue
MATCH (startNode)-[rel:`INCLUDES`]->(:`Character`) WHERE (id(startNode) = $fromId AND NOT (id(rel) IN $__knownRelationShipIds__)) DELETE rel
MATCH (startNode)-[rel:`INCLUDES`]->(:`Character`) WHERE (id(startNode) = $fromId AND NOT (id(rel) IN $__knownRelationShipIds__)) DELETE rel

OPTIONAL MATCH (hlp:`Character`) WHERE id(hlp) = $__id__ WITH hlp WHERE hlp IS NULL CREATE (character:`Character`) SET character = $__properties__ RETURN character UNION MATCH (character:`Character`) WHERE id(character) = $__id__ SET character += $__properties__ RETURN character
MATCH (startNode) WHERE id(startNode) = $fromId MATCH (endNode) WHERE id(endNode) = $toI**d MERGE (startNode)-[relProps:`INCLUDES`]->(endNode) RETURN id(relProps)

// 为一个已知结点建立一条关系，借助 `@RelationshipProperties`
OPTIONAL MATCH (hlp:`ComicIssue`) WHERE id(hlp) = $__id__ WITH hlp WHERE hlp IS NULL CREATE (comicIssue:`ComicIssue`) SET comicIssue = $__properties__ RETURN comicIssue UNION MATCH (comicIssue:`ComicIssue`) WHERE id(comicIssue) = $__id__ SET comicIssue += $__properties__ RETURN comicIssue
MATCH (startNode)-[rel:`INCLUDES`]->(:`Character`) WHERE (id(startNode) = $fromId AND NOT (id(rel) IN $__knownRelationShipIds__)) DELETE rel

OPTIONAL MATCH (hlp:`Character`) WHERE id(hlp) = $__id__ WITH hlp WHERE hlp IS NULL CREATE (character:`Character`) SET character = $__properties__ RETURN character UNION MATCH (character:`Character`) WHERE id(character) = $__id__ SET character += $__properties__ RETURN character
MATCH (startNode:`ComicIssue`) WHERE id(startNode) = $fromId MATCH (endNode) WHERE id(endNode) = $toId CREATE (startNode)-[relProps:`INCLUDES`]->(endNode) SET relProps += $__properties__ RETURN id(relProps)
MATCH (startNode)-[rel:`INCLUDES`]->(:`Character`) WHERE (id(startNode) = $fromId AND NOT (id(rel) IN $__knownRelationShipIds__)) DELETE rel
