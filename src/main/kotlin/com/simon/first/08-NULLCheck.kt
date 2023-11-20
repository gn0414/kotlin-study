package com.simon.first

fun main(args: Array<String>) {
    //类型后面加?表示可以为空
    var age:Int? = null
//    var age1:Int = null
    //抛出空指针异常
//    val ages = age!!.toInt()
    //不作处理返回null
    var ages1 = age?.toInt()
    //age为空返回-1
    var ages2 = age?.toInt() ?:-1

//    println(ages)
    println(ages1)
    println(ages2)

    println(parseInt("zzz"))
    println(parseInt("123"))
}
//当一个引用可能是null时，对应的类型声明必须明确地标记为可为null
fun parseInt(str:String):Int?{
    return str.toIntOrNull();
}