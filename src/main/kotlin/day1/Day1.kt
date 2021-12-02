package day1 import java.io.File
fun main(){with(File("src/main/kotlin/day1/input.txt").readLines().map{it.toInt()}){
println(this.subList(1,this.size).mapIndexed{i,x->(x-this[i])>0}.count{it})
val sums=this.subList(0,this.size-2).mapIndexed{i,x->x+this[i+1]+this[i+2]}
println(sums.subList(0,sums.size-1).mapIndexed{i,x->sums[i+1]-x>0}.count{it})}}