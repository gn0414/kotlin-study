package com.simon.second




//延时加载 lateinit
class MyTest {
    //我们的lateinit是用于延时加载我们的非基本类型的变量
    lateinit var myVar:String
    //我们的基本数据类型想要被延时加载可以像下面这样用
    var myInt:Int? = null
    //也就是允许为null且赋值为null

    fun checkMyVar(){
        if (::myVar.isInitialized){
            println(myVar)
        }else{
            println("未被初始化")
        }
    }

}

fun main(args: Array<String>) {
    var myTest = MyTest()
    myTest.checkMyVar()

    myTest.myVar = "hello kotlin"
    myTest.checkMyVar()

    var person = Person("simon")

    var person2 = Person("simon2",5)

    println(person2.name)
    println(person2.age)

    var nest = Outer.Nested()
    println(nest.foo())
    //不能访问外部元素
    var outer = Outer()

}
//我们的主构造器没有其他构造器那样有一个程序段所以我们可以在构造的时候使用init关键字
class Person constructor(firstName: String) {
    var name:String = firstName
    var age:Int?=null

    init {
        println("FirstName is $firstName")
    }
    //次构造器,我们就需要加前缀constructor
    //并且我们的次构造器需要先去代理主构造函数,同一个类里面代理主构造函数就使用this关键字
    constructor (name: String, age:Int) : this(name) {
        this.age = age
    }
}
//我们定义了一个类之后会默认有无参构造，如果想要隐藏构造器可以这样操作（私有化）
class DontCreateMe private constructor () {
}

//抽象类
abstract class Derived  {
    abstract fun f()
}

//嵌套类
class Outer {                  // 外部类
    private val bar: Int = 1
    class Nested {
        var str:String = "simon"
        // 嵌套类
        fun foo() = 2
    }
}