/**
 * Your Logger object will be instantiated and called as such:
 * var obj = Logger()
 * var param_1 = obj.shouldPrintMessage(timestamp,message)
 */

class Logger() {
    companion object {
        private const val MESSAGE_THRESHOLD = 10
    }

    private val queue = linkedMapOf<String, Int>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        val prevTimestamp = queue.getOrDefault(message, -1)
        return if (prevTimestamp > -1) {
            if (timestamp >= prevTimestamp + MESSAGE_THRESHOLD) {
                queue[message] = timestamp
                true
            } else {
                false
            }
        } else {
            queue[message] = timestamp
            true
        }
    }
}
