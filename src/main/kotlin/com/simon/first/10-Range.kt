package com.simon.first

fun main(args: Array<String>) {
    for (i in 1..4) print(i)
    //什么都不输出,所以得知默认是升序的
    for (i in 4..1) print(i)

    for (i in 1..10){
        print(i)
    }
    println()
    //使用step指定步长
    for(i in 1..4 step 2){
        print(i)
    }
    println()
    for(i in 4 downTo  1 step 2){
        print(i)
    }
    println()
    //使用until函数排除结束元素
    for(i in 1 until 10){
        print(i)
    }
}