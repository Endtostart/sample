=========================
关于线程的一些测试
=========================
1.OverrideStart
测试内容：
    测试重写Thread的start方法后,
    执行start方法的情况
测试结果：
    重写start方法后,执行start方法,被重写,导致线程并没有启动,而只是简单的方法调用

2.CaughtException
测试内容:
    用uncaughtExceptionHandler捕获处理异常