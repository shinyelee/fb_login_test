package com.shinyelee.fb_login_test

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.datepicker.DateSelector
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity : AppCompatActivity() {

    val dataModelList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.getReference("myMemo")

        val listView = findViewById<ListView>(R.id.mainLV)

        val adapter_list = ListViewAdapter(dataModelList)

        listView.adapter = adapter_list

        myRef.child(Firebase.auth.currentUser!!.uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataModelList.clear()

                for (dataModel in snapshot.children) {
                    Log.d("Data", dataModel.toString())
                    dataModelList.add(dataModel.getValue(DataModel::class.java)!!)
                }
                adapter_list.notifyDataSetChanged()
                Log.d("DataModel", dataModelList.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        val writeButton = findViewById<ImageView>(R.id.writeBtn)
        writeButton.setOnClickListener {

            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("운동 메모 다이얼로그")

            val mAlertDialog = mBuilder.show()

            val DateSelectBtn = mAlertDialog.findViewById<Button>(R.id.dateSelectBtn)

            var dateText = ""

            DateSelectBtn?.setOnClickListener {

                val today = GregorianCalendar()
                val year : Int = today.get(Calendar.YEAR)
                val month : Int = today.get(Calendar.MONTH)
                val date : Int = today.get(Calendar.DATE)

                val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(
                        view: DatePicker?,
                        year: Int,
                        month: Int,
                        dayOfMonth: Int
                    ) {
                        Log.d("MAIN", "${year}, ${month+1}, ${dayOfMonth}")
                        DateSelectBtn.setText("${year}, ${month+1}, ${dayOfMonth}")

                        dateText = "${year}, ${month+1}, ${dayOfMonth}"
                    }
                }, year, month, date)
                dlg.show()
            }

            val saveBtn = mAlertDialog.findViewById<Button>(R.id.saveBtn)
            saveBtn?.setOnClickListener {

                val healthMemo = mAlertDialog.findViewById<EditText>(R.id.healthMemo)?.text.toString()

                val database = Firebase.database
                val myRef = database.getReference("myMemo").child(Firebase.auth.currentUser!!.uid)

                val model = DataModel(dateText, healthMemo)

                myRef
                    .push()
                    .setValue(model)

                mAlertDialog.dismiss()
            }
        }
    }
}