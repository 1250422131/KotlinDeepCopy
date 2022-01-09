// SOURCE
// FILE: DeepCopy.java
package com.bennyhuo.kotlin.deepcopy.annotations;

public @interface DeepCopy {
}
// FILE: Main.kt [MainKt#main]
import com.bennyhuo.kotlin.deepcopy.annotations.DeepCopy

@DeepCopy
data class DataClass(val name: String)

@DeepCopy
data class Container(val dataClass: DataClass, val id: Int)

class PlainClass(val name: String)

fun main() {
    val container = Container(DataClass("x"), 0)
    val copy = container.deepCopy()
    println(copy)
}
// FILE: Main2.kt [com.bennyhuo.kotlin.deepcopy.sample.Main2Kt#main]
package com.bennyhuo.kotlin.deepcopy.sample

import com.bennyhuo.kotlin.deepcopy.annotations.DeepCopy

@DeepCopy
data class DataClass(val name: String)

@DeepCopy
data class Container(val dataClass: DataClass, val id: Int)

class PlainClass(val name: String)

fun main() {
    val container = Container(DataClass("y"), 1)
    val copy = container.deepCopy()
    println(copy)
}

// GENERATED
// FILE: Main.kt
Container(dataClass=DataClass(name=x), id=0)
// FILE: Main2.kt
Container(dataClass=DataClass(name=y), id=1)