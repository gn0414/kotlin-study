package com.simon.second
//1.延时加载 lateinit
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
//2.我们的主构造器没有其他构造器那样有一个程序段所以我们可以在构造的时候使用init关键字
class Person3 constructor(firstName: String) {
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
//3.我们定义了一个类之后会默认有无参构造，如果想要隐藏构造器可以这样操作（私有化）
class DontCreateMe private constructor () {
}

//4.抽象类
abstract class Derived  {
    abstract fun f()
}

//5.嵌套类
class Outer {                  // 外部类
    private val bar: Int = 1
    class Nested {
        var str:String = "simon"
        // 嵌套类
        fun foo() = 2
    }
    //那么我们的嵌套类与我们的内部类有什么区别呢?
}
//6.内部类
class Outer1{
    private val bar:Int = 2
    //内部类
    inner class Nested1{
        var str:String = "innerSimon"
        fun getBar():Int{return this@Outer1.bar}
    }
}
//7.匿名内部类
interface TestInterFace{
    fun test()
}
class Test{
    var v = "成员属性"
    fun setInterFace(test: TestInterFace){
        //我们可以看到我们的这个参数是这个接口
        test.test()
    }
}

//8.类的修饰符
/**
 * 属性修饰符
 * abstract 抽象类
 * final 类不可继承
 * enum 枚举类
 * open 类可继承 默认类是final的
 * annotation 注解类
 * 访问修饰符
 * private 一个文件可以
 *protected 同一个文件或者子类可见
 * public 所有调用的地方都可以见
 * internal 同一个模块中可见
 *
 * */


fun main(args: Array<String>) {
    var myTest = MyTest()
    myTest.checkMyVar()

    myTest.myVar = "hello kotlin"
    myTest.checkMyVar()

    var person = Person3("simon")

    var person2 = Person3("simon2",5)

    println(person2.name)
    println(person2.age)
    //嵌套类
    var nest = Outer.Nested()
    println(nest.foo())
    //外部和内部元素均无法互相访问

    //内部类
    //我们内部类的对象在获取时也要初始化我们的外部类对象
    //（可能用到外部类的属性所以也要获取实例）
    //外部无法访问内部但是内部可以访问外部
    var bar = Outer1().Nested1().getBar()
    //我们外部对象访问不了内部的str属性
//    var str = Outer1().str
    println(bar)

    //匿名内部类
    /*
    * 采用对象表达式来创建接口对象，即匿名内部类的实例
    * */
    var test = Test()
    test.setInterFace(object : TestInterFace{
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }
    })
}

