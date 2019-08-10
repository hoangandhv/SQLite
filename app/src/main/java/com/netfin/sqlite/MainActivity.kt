package com.netfin.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_name.setOnClickListener {
            val dbHandler = SQLiteHelper(this, null)
            val user = Nhanvien(null,edt_name.text.toString())
            dbHandler.addName(user)
            Toast.makeText(this, edt_name.text.toString() + "Added to database", Toast.LENGTH_LONG).show()

        }
        btn_getname.setOnClickListener {
            val dbHandler = SQLiteHelper(this, null)
            val cursor= dbHandler.getAllName()
            cursor!!.moveToFirst()
            txt_name.append((cursor.getString(cursor.getColumnIndex(SQLiteHelper.COLUMN_NAME))))
            while (cursor.moveToNext()) {
                txt_name.append((cursor.getString(cursor.getColumnIndex(SQLiteHelper.COLUMN_NAME))))
                //txt_name.append("\n")
            }
            cursor.close()
        }
    }
}
