package com.simon.first

fun main(args: Array<String>) {
    //$ 表示一个变量名或者变量值
    var a = 1
    var s1 = "a is $a"
    println(s1)
    a = 2
    //${}是一个变量的方法返回值
    var s2 = "${s1.replace("is","was")},but now a = $a";
    println(s2)
}
