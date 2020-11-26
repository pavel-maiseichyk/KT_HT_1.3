package ht_131

fun main() {
    println("Введите количество секунд:")
    val seconds = readLine()
    try {
        print("Был в сети ${agoText(seconds = seconds!!.toInt())}")
    } catch (e: Exception) {
        print("Введите целое чиселко, пожалуйста...")
    }
}

fun agoText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "только что"
        in 60..3600 -> "${seconds / 60} ${minutesText((seconds / 60).toString())} назад"
        in 3601..24 * 3600 -> "${seconds / 3600} ${hoursText((seconds / 3600).toString())} назад"
        in 24 * 3600 + 1..48 * 3600 -> "сегодня"
        in 48 * 3600 + 1..72 * 3600 -> "вчера"
        else -> "давно"
    }
}

fun minutesText(input: String): String {
    return when {
        input.endsWith("1") -> "минуту"
        input.endsWith("2") || input.endsWith("3") || input.endsWith("4") -> "минуты"
        else -> "минут"
    }
}

fun hoursText(input: String): String {
    return when {
        input.endsWith("1") && !input.endsWith("11") -> "час"
        input.endsWith("2") || input.endsWith("3") || input.endsWith("4") -> "часа"
        else -> "часов"
    }
}