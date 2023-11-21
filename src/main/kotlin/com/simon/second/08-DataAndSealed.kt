package com.simon.second

import kotlin.math.exp

//1.数据类 只包含数据的类

data class UserInfo(val name:String, val age:Int)
//equals,hashCode,toString,componentN,copy
//上面四个不说了演示下copy
//标准库提供了pair和triple但是实际上数据类设计更加完善

//2.密封类（这个蛮有意思的，同样是对有限类型的限制，举个例子）
//我们内嵌的子类定义了两个状态,一个是关闭一个是开启
//那么我们配合when对我们的这个op按钮类型进行判断
sealed class UiOp {
    object Show: UiOp()
    object Hide: UiOp()
    class TranslateX(val px: Float): UiOp()
    class TranslateY(val px: Float): UiOp()
}
fun execute(view: View, op: UiOp) = when (op) {
    UiOp.Show -> view.visibility = View.VISIBLE
    UiOp.Hide -> view.visibility = View.GONE
    is UiOp.TranslateX -> view.translationX = op.px // 这个 when 语句分支不仅告诉 view 要水平移动，还告诉 view 需要移动多少距离，这是枚举等 Java 传统思想不容易实现的
    is UiOp.TranslateY -> view.translationY = op.px
}

class View {
    companion object{
        const val VISIBLE = true
        const val GONE = false
    }

    var translationY: Float = 0.0f
    var translationX: Float = 0.0f
    var visibility:Boolean = true
}

fun main(args: Array<String>) {
    val cp1 = UserInfo("simon",13);
    val cp2 = cp1.copy(name = "simon1",14)
    println(cp1.toString()+cp2.toString())
    //解构
    val (name,age) = cp2

    //
}