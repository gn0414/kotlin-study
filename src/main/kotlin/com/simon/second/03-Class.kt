package com.simon.second

import kotlin.properties.Delegates

class Empty {}
class Runoob {
    //类的属性
    var name:String = "simon"
    var url:String = "www.baidu.com"
    var city:String = "赣州"
    //创建对象
    val site = Runoob()
    //成员函数
    fun foo(){
        println("foo is use")
       //调用属性
        println(site.city)
        println(site.name)
        println(site.url)
    }
}
//kotlin里面可以有一个主构造器以及一个或者多个此构造器，主构造器是类头部的一部分
class Person constructor(firstName:String){}
//如果主钩早期没有任何注解或者可见度修饰符那么可以省略构造器关键词
class Person1(firstName: String){}
//定义了一个Person2类，包含两个可变变量，lastName和no，lastName而修改了getter，no修改了setter
class Person2{
    var lastName:String = "zhang"
        get() = field.toUpperCase() //将变量赋值后转化为大写
        set

    var no:Int = 100
        get() = field
        set(value){
            field = if (value<10) value else -1
        }
    //不可见
    var heiht:Float = 145.4f
        private set

    //backing filed 后备变量
    //例如下面一种情况
//    var name:String = "HelloWorld"
//        get() = name

    var name:String = ""
        get() = field
        set(value){
            field = value
        }

    //另外还有一个非空属性的延迟加载

}

fun main(args: Array<String>) {
    var ps = Person2()
    println(ps.lastName)
    ps.no = 10
    println(ps.no)
//    ps.heiht = 10.2f
    //报错set是private
    println(ps.heiht)
    //后备变量

    /*
    * 我造！怎么溢出了？？
    * println(ps.name)
    * 梳理下逻辑
    * 我ps.name调用name属性的get方法获取值,发现还是name属性,那继续get，自然就溢出了
    * set同理
    * 那这样我们就在外部如何访问修改他的值呢？？？
    * 这个时候后备变量就起作用了！
    * 也就是我们的变量的值就是filed的值
    * 我们属性使用会自动地调用set get方法
    * 但是这下就不会了
    * */
    ps.name = "Hello kotlin"
    println(ps.name)
}

