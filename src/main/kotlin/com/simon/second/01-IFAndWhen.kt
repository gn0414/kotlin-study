package com.simon.second

fun main(args: Array<String>) {
    //if
    var a = 1
    var b = 2
    var max:Int
    if (a > b){
        max = a
    }else{
        max = b
    }
    //作为表达式结果赋值给max1 感觉这个简单啊
    var max1 = if(a>b)a else b
    println(max)
    println(max1)

    //同样可以和区间一起
    var x = 6
    if( x in 1..6) println("x在区间里面")
    //when when类似于其他语言的switch
    when(x){
        1,3 -> println("x==1 or x==3")
        2 -> println("x==2")
        //区间也可以
        in 4..5 -> println("4<=x<=5")
        //可以类型判断也基本上就是判断式都ok
        is Int -> println("x是数字")
        else ->{
            println("x是其他数字")
        }
    }
    //还能判断集合中是否存在
    var items = setOf<String>("apple","banana")
    when{
        "banana" in items -> println("banana in items")
        "apple" in items -> println("apple in items")
    }

}