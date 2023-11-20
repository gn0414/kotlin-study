package com.simon.second

fun main(args: Array<String>) {
    //for循环可以对任何提供迭代器对象来便利
    //for(item in collection)print(item)
    val ints:Array<Int> = arrayOf(1,2,3)
    for (item in ints){
        print(item)
    }
    //如果想通过索引来读(会编译优化，也可以选择下面这个方式)
    for(i in ints.indices){
        print(ints[i])
    }
    println()
    for((index,item) in ints.withIndex()){
        print("$index:$item ")
    }
    //while 和 doWhile循环
//    while (布尔表达式){
//        //内容
//    }
//    do{
//        //内容
//    }while (布尔表达式)
    var x = 5
    while (x>0){
        println(x--)
    }

    var y = 5
    do {
        println(y--)
    }while (y > 0)

    test1()

    foo()
}
fun test():Int{
    //return break 和 continue
    for (i in 1..10){
        if (i == 3)continue
        println(i)
        if (i>5)break
    }
    return 10
}

//Break和Continue标签
//这个爽炸了,直接跳指定循环舒服了
//continue同理跳到指定循环
fun test1(){
    loop@ for(i in 1..100){
        loop1@for (j in 1..100){
            if (i == j) {
                println("i==j")
                break@loop
            }
        }
    }
}
//标签处返回
//举个例子
fun foo(){
    var ints:Array<Int> = arrayOf(1,2,3)
    //如果没有标签处返回就会返回整个函数的返回,如果是有标签就会是标签处返回
    ints.forEach lit@{
        if (it == 3) return@lit
        println(it)
    }
    //lambda表达式使用隐式标签
    ints.forEach {
        if (it == 2) return@forEach
        print(it)
    }
    //匿名函数
    var x = ints.forEach(fun(value:Int){
        if (value == 2) return@forEach
        print(value)
    })


}
