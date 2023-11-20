package com.simon.first

fun main(args: Array<String>) {
    println(getStringLength(123))
    println(getStringLength("123"))
}

fun getStringLength(obj: Any):Int?{
//    if (obj is String){
//        return obj.length
//    }
//    return null

    if (obj !is String){
        return null
    }
    //在这个分支中,obj会自动转换为String类型
    return obj.length
}