package sudoku_checker

fun main() {

}

fun isValidSudoku(board: List<List<Char>>, subgridSize: Int = 3): Boolean {
    val gridSize = subgridSize * subgridSize
    if (board.size != gridSize || board.any { it.size != gridSize }) return false

    val seen = HashSet<String>()
    board.forEachIndexed { row, line ->
        line.forEachIndexed { col, value ->
            if (value != '-') {
                if (!(value in '1'..'9' || (gridSize > 9 && value in 'A'..'Z' && (value - 'A' + 10) <= gridSize))) return false

                if (!seen.add("$value in row $row") ||
                    !seen.add("$value in column $col") ||
                    !seen.add("$value in block ${row / subgridSize}-${col / subgridSize}")) {
                    return false
                }
            }
        }
    }
    return true
}










