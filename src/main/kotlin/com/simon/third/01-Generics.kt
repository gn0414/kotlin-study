package com.simon.third

//泛型学习（和java一样）
//1.构造方法泛型
class Box<T>(t:T){
    var value = t
}
//自动类型推断还有点东西
val box: Box<Int> = Box<Int>(1)
// 或者
val box1 = Box(1) // 编译器会进行类型推断，1 类型 Int，所以编译器知道我们说的是 Box<Int>

//2.函数泛型
fun <T> boxIn(value: T) = Box(value)

fun <T : Comparable<T>> sort(list: List<T>) {
    //上界泛型元素类似于class<T> extend ?
    //只有Comparable 的子类型可以替代 T
}
//甚至还能多上界约束
fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence, T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}
//3.声明处型变
/*
*声明处的类型变异使用协变注解修饰符：in、out，消费者 in, 生产者 out。
使用 out 使得一个类型参数协变，协变类型参数只能用作输出，可以作为返回值类型但是无法作为入参的类型：
* */

// 定义一个支持协变的类
//使用 out 使得一个类型参数协变，协变类型参数只能用作输出，可以作为返回值类型但是无法作为入参的类型：
class Runoob<out A>(val a: A) {
    fun foo(): A {
        return a
    }
}

// 定义一个支持逆变的类
//in 使得一个类型参数逆变，逆变类型参数只能用作输入，可以作为入参的类型但是无法作为返回值的类型：
class Runoob1<in A>(a: A) {
    fun foo(a: A) {
    }
}
fun main(args: Array<String>) {
    //泛型实例简单创建
    var boxInt = Box<Int>(10)
    var boxString = Box<String>("Runoob")

    println(boxInt.value)
    println(boxString.value)
    //
    val box4 = boxIn<Int>(1)
    val box5 = boxIn(1)     // 编译器会进行类型推断

    sort(listOf(1, 2, 3)) // Int 是 Comparable<Int> 的子类型
//    sort(listOf(HashMap<Int, String>()))
    //上面这个我们可以到看我们的子元素是HashMap<Int, String>() 不是Comparable<HashMap<Int, String>>的子类所以报错了
    //如果没写默认上界是Any
    //
}
