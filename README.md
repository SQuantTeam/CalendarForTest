# CalendarForTest
This is a simple java program which is to complete Advanced Software Test course.

Pit变异测试需安装idea pit插件，参见http://pitest.org/

目录结构说明：
-src
    -manual#手动变异代码
    -mock#测试代码外部调用的类和方法的MockObject
    -pit#pitest插件使用的父包
        -raw#原始代码
        -test#对原始代码的单元测试，后缀表示被测试类中的第几个方法
    -util#工具类包