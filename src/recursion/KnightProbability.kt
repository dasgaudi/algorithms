/*
Given a knight, a starting position on a chessboard, and a number of movements N
Determine the probability that the knight will be still on the chessboard
 */

fun main() {
    val moves: List<List<Int>> = listOf(listOf(1,2), listOf(1,-2), listOf(-1,2), listOf(-1,-2), listOf(2,1), listOf(2,-1), listOf(-2,1), listOf(-2,-1))
    println("the results of the move: ${knightProbabilty(4, 0,0, 1, moves)}")
}

fun knightProbabilty(dim: Int, i: Int, j: Int, N: Int, moves: List<List<Int>>): Double {
    if (N == 0) {
        if (isStillOnBoard(i, j, dim)) return 1.0 else 0.0
    }
    if (!isStillOnBoard(i, j, dim)) return 0.0
    var prob = 0.0
    for (move in moves) {
        prob += knightProbabilty(dim, i+move[0], j+move[1], N-1, moves)
    }
    return prob/moves.size
}

fun isStillOnBoard(i: Int, j: Int, dim: Int): Boolean {
    return (i in 0 until dim && j in 0 until dim)
}