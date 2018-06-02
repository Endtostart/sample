================
  hadoop 相关
================
hadoop:
    hadoop 分为两部分,分布式存储 和 分布式处理
    分布式存储:
        HDFS : 分布式存储文件系统
        Hbase : 分布式数据库,建立在 HDFS文件系统之上，实现对数据的组织管理。特点：列族数据库,可进行时事查询
        Hive : 对一段时间内的数据进行分析查询。 非时事

    分布式计算:

        Map-Reduce 数据处理范围两个部分: map 和 reduce
            map过程对数据进行简单的处理分组
            reduce 对经过map 部分 处理分组的数据，每组数据对应一个reduce 处理
        Spak
            分布式计算框架
            可进行时事计算



Q&A:
    1 > HDFS 文件系统的 结构和特点
    2 > Hbase 和 Hive 的特点和比较
    3 > Map-Reduce 和 Spark 的特点和比较
    4 > Zookeeper





