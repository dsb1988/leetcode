package prep2023

fun main() {
    val commands = arrayOf("G", "L", "RGRG", "RG", "LG")
    val result = doesCircleExist(commands)
    for (i in result.indices) {
        println("Command ${commands[i]}: ${result[i]}")
    }
}

fun doesCircleExist(commands: Array<String>): Array<String> {
    val result = mutableListOf<String>()
    for (command in commands) {
        val robotSim = RobotSim()
        repeat(4) { robotSim.simulateCommand(command) }
        if (robotSim.atStartPos()) {
            result.add("YES")
        } else {
            result.add("NO")
        }
    }
    return result.toTypedArray()
}

class RobotSim {
    private val robot = Robot()
    fun simulateCommand(command: String) {
        for (step in command.toCharArray()) {
            when {
                step.equals('R', true) -> {
                    robot.turnRight()
                }

                step.equals('L', true) -> {
                    robot.turnLeft()
                }

                step.equals('G', true) -> {
                    robot.go()
                }

                else -> {
                    println("Wrong input: $step, ignored")
                }
            }
        }
    }

    fun atStartPos() = robot.atStartPos()
}

class Robot {
    private var position = Coordinate(0, 0)
    private var direction = Direction.NORTH

    fun turnLeft() {
        direction = when (direction) {
            Direction.NORTH -> Direction.WEST
            Direction.EAST -> Direction.NORTH
            Direction.SOUTH -> Direction.EAST
            Direction.WEST -> Direction.SOUTH
        }
    }

    fun turnRight() {
        direction = when (direction) {
            Direction.NORTH -> Direction.EAST
            Direction.EAST -> Direction.SOUTH
            Direction.SOUTH -> Direction.WEST
            Direction.WEST -> Direction.NORTH
        }
    }

    fun go() {
        position = when (direction) {
            Direction.NORTH -> Coordinate(position.x, position.y + 1)
            Direction.EAST -> Coordinate(position.x + 1, position.y)
            Direction.SOUTH -> Coordinate(position.x, position.y - 1)
            Direction.WEST -> Coordinate(position.x - 1, position.y)
        }
    }

    fun atStartPos() = position == Coordinate(0, 0)
}

data class Coordinate(val x: Int, val y: Int)
enum class Direction {
    NORTH, EAST, SOUTH, WEST
}

