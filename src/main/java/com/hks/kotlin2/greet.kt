package com.hks.kotlin2

fun main(args: Array<String>){
    val name = if(args.any()) args[0] else "Kotlin"
    println("Hello, $name!!!")
}