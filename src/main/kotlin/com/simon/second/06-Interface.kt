package com.simon.second

//1.一个类或者对象可以实现多个接口，这个就不说了（有默认实现的就实现时可以选择不实现）
interface MyInterface{
    fun bar()
    //默认实现
    fun foo(){
        println("foo")
    }
}
//2.接口中的属性只能是抽象的，不允许初始化值，在实现接口时必须重写属性
interface MyInterface1{
    var name:String
//    var age:Int = 1 error
}
//3.同名方法多实现
interface A{
    fun foo(){
        println("A")
    }
    fun bar(){
        println("ABar")
    }
}
interface B{
    fun foo(){
        println("B")
    }
    fun bar(){
        println("BBar")
    }
}

class C:A,B{
    override fun foo() {
        //可以选择两个一起
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        //可以选择丢弃
        super<A>.bar()
    }
}
class MyImpl:MyInterface1{
    override var name: String = "simon"
}