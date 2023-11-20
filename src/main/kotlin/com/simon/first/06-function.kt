package com.simon.first
//1.函数基本定义格式
fun sum(a:Int,b:Int):Int{//函数返回值Int
    return a + b
}

fun main(args: Array<String>) {
    //2.可以用表达式作为函数体
    //表达式不是public就可以省略返回值类型
    fun sum(a: Int,b: Int) = a+b

}
// 3.public 方法表达式就要明确写出
public fun sumPub(a:Int , b: Int):Int = a+b
//无返回值可以省略
fun printZzz(){
    println("printZzz")
}
public fun printXxx(){
    println("printXxx")
}
//可变长参数列表
fun vars (vararg v:Int){
    for (vt in v) {
        println(vt)
    }
}

//lambda表达式
val sumLambda: (Int,Int)->Int = {x,y -> x+y}
