package com.simon.second

class User(var name:String)
//1.扩展函数
fun User.Print(){
    println("用户名:${name}")
}
//2.扩展函数swap
fun MutableList<Int>.swap(index1:Int,index2:Int){
    var tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}
//3.扩展函数是静态解析的（具体是哪个对象调用就是哪个对象的扩展函数）和动态绑定正好不一样
open class D
class E: D()
fun C.foo() = "C"

fun D.foo() = "D"
fun printFoo(d: D){
    println(d.foo())
}
//4.还可以扩展一个空对象，使用Any那不是所有类的toString都会判空了？
fun Any?.toString():String{
    if (this == null)return "null"
    return toString()
}
//5.伴生对象的扩展(方法和属性)
class MyClass{
    companion object{

    }
}

fun MyClass.Companion.foo(){
    println("伴生对象的方法扩展")
}

val MyClass.Companion.id: Int
    get() = 1
//6.作用域也可以扩展,懒得分包了不掩饰了

//7.扩展声明为成员
class F{
    fun bar(){
        println("F bar")
    }

    fun G.foo(){
        barG()
        bar()
    }

    fun caller(g:G){
        g.foo()
    }

}
class G{
    fun barG(){
        println("G bar")
    }
}

fun main(args: Array<String>) {
    var user = User("simon")
    user.Print()

    var l = mutableListOf(1,2,3)
    l.swap(0,2)
    println(l.toString())
    //虽然传的是D对象，但是接受的是C对象，所以调用的是C的foo，所以为静态的
    printFoo(E())

    println(MyClass.foo())
    println(MyClass.id)

    var g = G()
    var f = F()
    f.caller(g)

}