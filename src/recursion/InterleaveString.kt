/*
Given strings x,y, and z, find if z is interleaving of x,y
 */

fun main() {
    println("is interleave? ${isInterleave("xy", "yz", "xyyz")}")
}

fun isInterleave(x: String, y: String, z: String): Boolean {
    if (z.length != x.length + y.length) return false
    return isInterleave(x,y,z, x.length, y.length)
}

fun isInterleave(x: String, y: String, z: String, m: Int, n: Int): Boolean {
    if (m == 0) return y == z.substring(0,n)
    if (n == 0) return x == z.substring(0,m)
    
    if (z[m+n-1] == x[m-1] && z[m+n-1] == y[n-1]) {
        return (isInterleave(x,y,z, m-1, n) || isInterleave(x,y,z,m,n-1))
    } else if (z[m+n-1] == x[m-1]) {
        return isInterleave(x,y,z,m-1,n)
    } else if (z[m+n-1] == y[n-1]) {
        return isInterleave(x,y,z, m, n-1)
    }
    return false
}


