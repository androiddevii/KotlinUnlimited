package sudoku_checker

fun main() {

    test(
        name = "Sudoku with board size 9×9 grid (3×3 subgrids), then return true",
        result = isValidSudoku(listOf(
            listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
            listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
        )),
        correctResult = true
    )

    test(
        name = "Sudoku with all empty cells, then return true",
        result = isValidSudoku(listOf(
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
        )),
        correctResult = true
    )

    test(
        name = "Sudoku with all empty cells represented with '.', then return false ",
        result = isValidSudoku(listOf(
            listOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            listOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            listOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            listOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            listOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            listOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            listOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            listOf('.', '.', '.', '.', '.', '.', '.', '.', '.'),
            listOf('.', '.', '.', '.', '.', '.', '.', '.', '.')
        )),
        correctResult = false
    )

    // Duplicate in rows
    test(
        name = "Sudoku with row duplication, then return false",
        result = isValidSudoku(listOf(
            listOf('5', '3', '3', '-', '7', '-', '-', '-', '-'),
            listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
        )),
        correctResult = false
    )

    // Duplicate in columns
    test(
        name = "Sudoku with column duplication, then return false",
        result = isValidSudoku(listOf(
            listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
            listOf('5', '-', '-', '1', '9', '5', '-', '-', '-'),
            listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
        )),
        correctResult = false
    )

    // Duplicate in sub-grids
    test(
        name = "Sudoku with sub-grid 3x3 box duplication, then return false",
        result = isValidSudoku(listOf(
            listOf('5', '3', '-', '-', '-', '-', '-', '-', '-'),
            listOf('6', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '5', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
        )),
        correctResult = false
    )

    test(
        name = "Sudoku with non-numeric characters, then return false",
        result = isValidSudoku(listOf(
            listOf('E', '3', '-', '-', '7', '-', '-', '-', '-'),
            listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
        )),
        correctResult = false
    )

    test(
        name = "Sudoku with special characters, then return false",
        result = isValidSudoku(listOf(
            listOf('#', '3', '-', '-', '7', '-', '-', '-', '-'),
            listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
        )),
        correctResult = false
    )

    test(
        name = "Sudoku with out-of-range numbers using zero, then return false",
        result = isValidSudoku(listOf(
            listOf('1', '0', '-', '-', '7', '-', '-', '-', '-'),
            listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
            listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
            listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
            listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
            listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
            listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
            listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
            listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
        )),
        correctResult = false
    )

    test(
        name = "Sudoku with board size 8×9 grid (3×3 subgrids), then return false",
        result = isValidSudoku(listOf(
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
        )),
        correctResult = false
    )

    test(
        name = "Sudoku with board size 9×9 grid (3×3 subgrids) completed, then return true",
        result = isValidSudoku(listOf(
            listOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
            listOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
            listOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
            listOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
            listOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
            listOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
            listOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
            listOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
            listOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
        )),
        correctResult = true
    )

    test(
        name = "Sudoku with inconsistent row lengths, then return false",
        result = isValidSudoku(listOf(
            listOf('-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            listOf('-', '-', '-', '-', '-', '-', '-', '-', '-')
        )),
        correctResult = false
    )

    test(
        name = "Sudoku with board size 4×4 grid (2×2 subgrids), then return true",
        result = isValidSudoku(
          board = listOf(
            listOf('1', '-', '-', '4'),
            listOf('-', '4', '1', '-'),
            listOf('-', '1', '-', '3'),
            listOf('2', '-', '4', '-')
          ),
          subgridSize = 2
        ),
        correctResult = true
    )

    test(
        name = "Sudoku with board size 3×4 grid (2×2 subgrids), then return false",
        result = isValidSudoku(
            board = listOf(
                listOf('1', '-', '-', '4'),
                listOf('-', '4', '1', '-'),
                listOf('-', '1', '-', '3'),
            ),
            subgridSize =2
        ),
        correctResult = false
    )

    test(
         name = "Sudoku with board size 16×16 grid (4×4 subgrids) completed, then return true",
         result = isValidSudoku(
            board = listOf(
                 listOf('1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G'),
                 listOf('5','6','7','8','9','A','B','C','D','E','F','G','1','2','3','4'),
                 listOf('9','A','B','C','D','E','F','G','1','2','3','4','5','6','7','8'),
                 listOf('D','E','F','G','1','2','3','4','5','6','7','8','9','A','B','C'),
                 listOf('2','1','4','3','6','5','8','7','A','9','C','B','E','D','G','F'),
                 listOf('6','5','8','7','A','9','C','B','E','D','G','F','2','1','4','3'),
                 listOf('A','9','C','B','E','D','G','F','2','1','4','3','6','5','8','7'),
                 listOf('E','D','G','F','2','1','4','3','6','5','8','7','A','9','C','B'),
                 listOf('3','4','5','6','7','8','9','A','B','C','D','E','F','G','1','2'),
                 listOf('7','8','9','A','B','C','D','E','F','G','1','2','3','4','5','6'),
                 listOf('B','C','D','E','F','G','1','2','3','4','5','6','7','8','9','A'),
                 listOf('F','G','1','2','3','4','5','6','7','8','9','A','B','C','D','E'),
                 listOf('4','3','2','1','8','7','6','5','C','B','A','9','G','F','E','D'),
                 listOf('8','7','6','5','C','B','A','9','G','F','E','D','4','3','2','1'),
                 listOf('C','B','A','9','G','F','E','D','4','3','2','1','8','7','6','5'),
                 listOf('G','F','E','D','4','3','2','1','8','7','6','5','C','B','A','9')
            ),
            subgridSize = 4
        ),
        correctResult = true
    )
}


fun test(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed - $name")
    }
}


