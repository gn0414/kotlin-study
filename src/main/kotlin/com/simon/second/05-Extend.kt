package com.simon.second

import javax.naming.Context

//基本的继承演示
open class Base(p:Int)
class BaseDerived(p:Int):Base(p){}

//1.如果子类有主构造函数，则基本必须在主构造函数中立刻初始化
open class Person5(var name:String,var age:Int){
    //要声明出来可以被重写
    open fun study(){
        println("我毕业了")
    }
}

class Student(name: String,age: Int,var no:String,var score:Int):Person5(name,age){}
//个人理解就是：如果基类主构造函数有这两个字段,那么我们的子类在声明时也必须吧这个字段带入自己的主构造函数

//2.如果子类没有主构造函数
//class Student1():Person5(name = "simon",12){
//
//}
//就像上面上的必须马上初始化就直接赋值给基类的主构造函数
//或者像下面在次构造里面写一个super基类的构造方法
class Student2: Person5{
    //也就是我只有这个有参构造，构造的同时调用父类的主构造方法
    constructor(name: String,age: Int):super(name,age){}
    //3.重写方法
    override fun study() {
        println("我还在读书")
    }
}
//4.重写属性(一般用不上了解就行)
interface Foo{
    val count:Int
}
//将一个val属性重写为var（常-》变）
//不能变量变成常量
class Bar1(override var count:Int):Foo
//将属性重写属性和值
class Bar2 : Foo {
    override var count: Int = 1
}

fun main(args: Array<String>) {
    var s = Student("Runoob",18,"s123",89)
    println("${s.name}")
    println("${s.age}")
    println("${s.no}")
    println("${s.score}")
    //重写
    var s2 = Student2("simon",19)
    s2.study()

}