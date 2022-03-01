package com.vinnykawa.copia

import androidx.appcompat.app.AppCompatActivity
import com.vinnykawa.copia.model.Receipt
import android.os.Bundle
import android.util.Log
import com.vinnykawa.copia.R
import com.vinnykawa.copia.MainActivity
import com.vinnykawa.copia.model.Transaction
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val receipts = ArrayList<Receipt>()
    private val transactions = ArrayList<Transaction>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //add data to receipt array
        val R001 = Receipt("R001", 100)
        receipts.add(R001)
        val R002 = Receipt("R002", 400)
        receipts.add(R002)
        val R003 = Receipt("R003", 350)
        receipts.add(R003)

        //add data to transactions array
        val MG001 = Transaction("MG001", 100)
        transactions.add(MG001)
        val MG002 = Transaction("MG002", 200)
        transactions.add(MG002)
        val MG003 = Transaction("MG003", 300)
        transactions.add(MG003)
        val MG004 = Transaction("MG004", 250)
        transactions.add(MG004)

        var remainder = 0

        for (i in receipts.indices) {
            val item = receipts[i]
            var amountToBePaid = item.amountToBePaid

            for (t in transactions.indices) {
                val tItem = transactions[t]
                val transactionAmount = tItem.amount
                val diff = amountToBePaid - (transactionAmount + remainder)
                if (diff == 0) {

                    //R001 satisfied
                    Log.d(TAG, """${item.id} ${tItem.ref} ${tItem.amount}""")
                    transactions.remove(tItem)
                    break
                }
                if (remainder < 0) {
                    //change remainder to positive
                    val balance = -remainder
                    Log.d(TAG, """${item.id} ${tItem.ref} $balance""")
                    remainder = 0
                } else if (diff > 0) {
                    Log.d(TAG, """${item.id} ${tItem.ref} ${tItem.amount}""")
                    amountToBePaid = diff
                } else {
                    //There is a remainder
                    remainder = diff
                    transactions.removeAt(t - 1)
                    Log.d(TAG, """${item.id} ${tItem.ref} $amountToBePaid""")
                    break
                }
            }
        }
    }

    companion object {
        private const val TAG = "Table"
    }
}