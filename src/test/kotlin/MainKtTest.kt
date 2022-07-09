import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionFromPaymentSystem_cardMaestro_else() {
        //arrange
        val Transfer = 65000.00
        val vard = "Maestro"

        //act
        val result = commissionFromPaymentSystem(
            amountTransfer =  Transfer,
            paymentSystem = vard
        )
        val delta = result - 0.0

        //assert
        assertEquals(0.0, result, delta)
    }
    @Test
    fun commissionFromPaymentSystem_cardMaestro_if() {
        //arrange
        val Transfer = 85000.00
        val vard = "Maestro"

        //act
        val result = commissionFromPaymentSystem(
            amountTransfer =  Transfer,
            paymentSystem = vard
        )
        val delta = result - 0.00

        //assert
        assertEquals(0.00, result, delta)
    }

    @Test
    fun commissionFromPaymentSystem_cardMasterCard_if() {
        //arrange
        val Transfer = 74000.00
        val vard = "MasterCard"

        //act
        val result = commissionFromPaymentSystem(
            amountTransfer =  Transfer,
            paymentSystem = vard
        )
        val delta = result - 0.00

        //assert
        assertEquals(0.00, result, delta)
    }
    @Test
    fun commissionFromPaymentSystem_cardMasterCard_else() {
        //arrange
        val Transfer = 85_000.00
        val vard = "MasterCard"

        //act
        val result = commissionFromPaymentSystem(
            amountTransfer =  Transfer,
            paymentSystem = vard
        )
        val delta = result - 530.00

        //assert
        assertEquals(530.00, result, delta)
    }
    @Test
    fun commissionFromPaymentSystem_MIR_if() {
        //arrange
        val Transfer = 85_101.00
        val vard = "MIR"

        //act
        val result = commissionFromPaymentSystem(
            amountTransfer =  Transfer,
            paymentSystem = vard
        )
        val delta = result - 638.25749

        //assert
        assertEquals(638.25749, result, delta)
    }
    @Test
    fun commissionFromPaymentSystem_MIR_else() {
        //arrange
        val Transfer = 600.00
        val vard = "MIR"

        //act
        val result = commissionFromPaymentSystem(
            amountTransfer =  Transfer,
            paymentSystem = vard
        )
        val delta = result - 35.00

        //assert
        assertEquals(35.00, result, delta)
    }
    @Test
    fun commissionFromPaymentSystem_VK() {
        //arrange
        val Transfer = 85_101.00
        val vard = "VKPay"

        //act
        val result = commissionFromPaymentSystem(
            amountTransfer =  Transfer,
            paymentSystem = vard
        )
        val delta = result - 0.0

        //assert
        assertEquals(0.0, result, delta)
    }
}