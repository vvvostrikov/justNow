

/*const val MASTER_CARD = "MasterCard"
const val MAESTRO = "Maestro"
const val MIR = "MIR"
const val VISA = "VISA"
const val VK_PAY = "VKPay"
const val FREE_COMMISSION = 0.00
const val COMMISSION_FROM_MASTER_AND_MAESTRO = 0.006
const val ADDITIONAL_COMMISSION_FROM_MASTER_AND_MAESTRO = 20.00
const val COMMISSION_FROM_VISA_AND_MIR = 0.0075
const val MIN_TRANSFER_FOR_MASTER_AND_MAESTRO = 75_000.00
const val MIN_COMMISSION_FOR_VISA_AND_MIR = 35.00*/

fun main() {

    val amountTransfer = 85_101.00
    val outCommission = commissionFromPaymentSystem(amountTransfer = 85_101.00, paymentSystem = "MasterCard")

    println("Сумма перевода: ${String.format("%.2f", amountTransfer)} руб.")
    println("Комиссия за перевод: ${String.format("%.2f", outCommission)} руб.")
}

fun commissionFromPaymentSystem(
    TOTAL_CARD: Array<String> = arrayOf("MasterCard", "Maestro", "MIR", "VISA", "VKPay"),
    FREE_COMMISSION: Double = 0.00,
    COMMISSION_FROM_MASTER_AND_MAESTRO: Double = 0.006,
    ADDITIONAL_COMMISSION_FROM_MASTER_AND_MAESTRO: Double = 20.00,
    COMMISSION_FROM_VISA_AND_MIR: Double = 0.0075,
    MIN_TRANSFER_FOR_MASTER_AND_MAESTRO: Double = 75_000.00,
    amountTransfer: Double,
    MIN_COMMISSION_FOR_VISA_AND_MIR: Double = 35.00,
    paymentSystem: String,
): Double {

    return when (paymentSystem) {

        TOTAL_CARD[0] -> if (amountTransfer < MIN_TRANSFER_FOR_MASTER_AND_MAESTRO) amountTransfer * FREE_COMMISSION
        else (amountTransfer * COMMISSION_FROM_MASTER_AND_MAESTRO) + ADDITIONAL_COMMISSION_FROM_MASTER_AND_MAESTRO

        TOTAL_CARD[1] -> if (amountTransfer < MIN_TRANSFER_FOR_MASTER_AND_MAESTRO) amountTransfer * FREE_COMMISSION
        else (amountTransfer * COMMISSION_FROM_MASTER_AND_MAESTRO) + ADDITIONAL_COMMISSION_FROM_MASTER_AND_MAESTRO

        TOTAL_CARD[2] -> if (amountTransfer * COMMISSION_FROM_VISA_AND_MIR > MIN_COMMISSION_FOR_VISA_AND_MIR) amountTransfer * COMMISSION_FROM_VISA_AND_MIR
        else MIN_COMMISSION_FOR_VISA_AND_MIR

        else -> FREE_COMMISSION
    }
}