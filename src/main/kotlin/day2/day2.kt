package day2 import java.io.File
fun main(){var depth=0
var aim=0
var position=0
File("src/main/kotlin/day2/input.txt").readLines().forEach{val(command,value)=it.split(" ")
with(value.toInt()){when(command){"forward"->{position+=this
depth+=aim * this}
"up"->{aim-=this}
"down"->{aim+=this}}}}
println(depth*position)}