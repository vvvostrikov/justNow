const val SEC_60 = 60
const val SEC_61 = 61
const val ONE_HOUR = (60 * 60)
const val ONE_HOUR_PLUS_SEC = (60 * 60 + 1)
const val ONE_DAY = (60 * 60 * 24)
const val ONE_DAY_TO_PLUS_SEC = (60 * 60 * 24 + 1)
const val TWO_DAY = (60 * 60 * 48)
const val TWO_DAY_TO_PLUS_SEC = (60 * 60 * 48 + 1)
const val THREE_DAY = (60 * 60 * 72)
const val FOR_THE_RIGHT = 10

fun main() {
    val name = "Александр Костелов"
    val sec = 1           // только что

    println("$name был(а) в сети ${agoToText(sec)}.")

}

fun agoToText(sec: Int): String {
    return when {
        sec <= SEC_60 -> "только что"
        sec in SEC_61..ONE_HOUR -> rightMinutes(sec)
        sec in ONE_HOUR_PLUS_SEC..ONE_DAY -> rightHours(sec)
        sec in ONE_DAY_TO_PLUS_SEC..TWO_DAY -> "сегодня"
        sec in TWO_DAY_TO_PLUS_SEC..THREE_DAY -> "вчера"
        else -> "давно"
    }
}

fun rightMinutes(sec: Int): String {

    val min = (sec / 60)
    return when {
        min == 60 -> "1 час назад"
        min % FOR_THE_RIGHT == 1 -> "$min минуту назад"
        min % FOR_THE_RIGHT == 2 -> "$min минуты назад"
        min % FOR_THE_RIGHT == 3 -> "$min минуты назад"
        min % FOR_THE_RIGHT == 4 -> "$min минуты назад"
        else -> "$min минут назад"
    }
}

fun rightHours(sec: Int): String {
    val hour = (sec / 60 / 60)

    return when {
        hour == 24 -> "сегодня"
        hour % FOR_THE_RIGHT == 1 -> "$hour час назад"
        hour % FOR_THE_RIGHT == 2 -> "$hour часа назад"
        hour % FOR_THE_RIGHT == 3 -> "$hour часа назад"
        hour % FOR_THE_RIGHT == 4 -> "$hour часа назад"
        else -> "$hour часов назад"
    }
}