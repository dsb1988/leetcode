package prep2023

fun main() {
    val votes = arrayOf("ABC","ACB","ABC","ACB","ACB")
    rankTeams(votes)
}

fun rankTeams(votes: Array<String>): String {
    val maxTeams = 26
    val numberOfTeams = votes[0].length
    var ranks = arrayOf<IntArray>()
    for (i in 0..maxTeams) {
        val array = IntArray(numberOfTeams) { 0 }
        ranks += array
    }

    votes.forEach { vote ->
        vote.forEachIndexed { place, team ->
            val teamNumber = team - 'A'
            ranks[teamNumber][place]++
        }
    }

    val teams = votes[0].toCharArray()
    val sorted = teams.sortedWith { t1, t2 ->
        for (i in 0 until numberOfTeams) {
            val t1Number = t1 - 'A'
            val t2Number = t2 - 'A'
            if (ranks[t1Number][i] != ranks[t2Number][i]) {
                return@sortedWith ranks[t2Number][i] - ranks[t1Number][i]
            }
        }
        t1 - t2
    }

    return String(sorted.toCharArray())
}

