=====================
 关于log4j2的一些知识
=====================
> 主要组件:
    1. Logger   # It is used to log the messages
                # 用来记录信息
    2. Appender # It is used to publish the logging information to the destination
                  like a file, database, console etc.
                # 用来声明日志信息的输出目的地，可以是文件，数据库，控制台 等等
    3. Layout   # It is used to format logging information in different styles
                # 用来格式化日志信息的格式

> 日志级别:
    Trace < Debug < Info < Warn < Error < Fatal

> 接口实现:
    Appender >
        ConsoleAppender :
            # 输出结果到System.out或是System.err
        FileAppender :
            # 输出结果到指定文件，同时可以指定输出数据的格式。append=“false”指定不追加到文件末尾
        RollingFileAppender :
            # 自动追加日志信息到文件中，直至文件达到预定的大小，然后自动重新生成另外一个文件来记录之后的日志
    Layout >
        PatternLayout :
        XMLLayout :
        ...

> 配置介绍:
    1.
    --------------------------------------------------
    <Filters>
        <ThresholdFilter level="error" onMatch="ACCEPT"
            onMismatch="DENY" />
    </Filters>
    --------------------------------------------------
    注: 该配置用于过滤错误级别。当前配置只会输出error级别以上的日志信息
        level="error"       匹配的级别
        onMatch="ACCEPT"    接受匹配到的信息
        onMismatch="DENY"   拒绝未匹配到的信息
        onMismatch="NEUTRAL" 当还有后置过滤时,NEUTRAL会将筛选中的数据交给后置处理

> 相关链接
    https://blog.csdn.net/autfish/article/details/51203709