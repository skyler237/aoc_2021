package day6 import java.io.File
fun main(){val x=File("src/main/kotlin/day6/input.txt").readText().trim().split(',').map{it.toInt()}
val y=LongArray(9)
x.forEach{y[it]+=y[it]+1}
for(i in 0 until 256){val a=i%9
val b=(a+7)%9
y[b]+=y[a]
if(i==79||i==255)println(y.sum())}}