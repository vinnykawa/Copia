package com.vinnykawa.copia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.vinnykawa.copia.model.Receipt;
import com.vinnykawa.copia.model.Transaction;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Table";
 private ArrayList<Receipt> receipts = new ArrayList<>();
 private ArrayList<Transaction> transactions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add data to receipt array
        Receipt R001 = new Receipt("R001",100);
        receipts.add(R001);
        Receipt R002 = new Receipt("R002",400);
        receipts.add(R002);
        Receipt R003 = new Receipt("R003",350);
        receipts.add(R003);

        //add data to transactions array
        Transaction MG001 = new Transaction("MG001",100);
        transactions.add(MG001);
        Transaction MG002 = new Transaction("MG002",200);
        transactions.add(MG002);
        Transaction MG003 = new Transaction("MG003",300);
        transactions.add(MG003);
        Transaction MG004 = new Transaction("MG004",250);
        transactions.add(MG004);

        int remainder = 0;

        for(int i = 0; i < receipts.size(); i++){
            Receipt item = receipts.get(i);

            int receiptTotal = item.getAmountToBePaid();

            for(int t = 0; t < transactions.size(); t++){
                Transaction tItem = transactions.get(t);

                int transactionAmount = tItem.getAmount();

                int diff = receiptTotal - (transactionAmount + remainder );

                if(diff==0){

                    //R001 satisfied
                    Log.d(TAG, item.getId()+" "+tItem.getRef()+" "+tItem.getAmount()+"\n");

                    transactions.remove(tItem);

                    break;

                }

                if(remainder<0){
                    Log.d(TAG,item.getId()+" "+tItem.getRef()+" "+-(remainder)+"\n");

                    remainder = 0;

                }
                else
                if(diff>0){
                    Log.d(TAG,item.getId()+" "+tItem.getRef()+" "+tItem.getAmount()+"\n");

                    receiptTotal =  diff;

                } else {
                    //There is a remainder

                    remainder = diff;

                    transactions.remove(t-1);
                    Log.d(TAG,item.getId()+" "+tItem.getRef()+" "+receiptTotal+"\n");
                    break;

                }

            }

        }

    }

}