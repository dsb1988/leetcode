import kotlin.math.min

fun main() {
    val solution = Solution()
    var edges = arrayOf<IntArray>()
    edges += intArrayOf(0, 1, 2)
    edges += intArrayOf(0, 4, 8)
    edges += intArrayOf(1, 2, 3)
    edges += intArrayOf(1, 4, 2)
    edges += intArrayOf(2, 3, 1)
    edges += intArrayOf(3, 4, 1)
    println(solution.findTheCity(5, edges, 2))
}

class Solution {
    fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
        var dis = arrayOf<IntArray>()
        for (i in 0 until n) {
            dis += IntArray(n) { 10001 }
        }

        // Fill the matrix
        for (e in edges) {
            dis[e[0]][e[1]] = e[2]
            dis[e[1]][e[0]] = e[2]
        }

        // No cycle loops
        for (i in 0 until n) {
            dis[i][i] = 0
        }

        // Floyd Warshall to find suboptimal through k
        for (k in 0 until n) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    dis[i][j] = min(dis[i][j], dis[i][k] + dis[k][j])
                }
            }
        }

        // Find the city with the smallest neighbors
        var smallest = n
        var result = 0
        for (i in 0 until n) {
            var count = 0
            for (j in 0 until n) {
                if (dis[i][j] <= distanceThreshold) count++
            }
            if (count <= smallest) {
                smallest = count
                result = i
            }
        }

        return result
    }
}