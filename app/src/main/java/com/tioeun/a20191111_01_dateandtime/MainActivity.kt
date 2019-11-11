package com.tioeun.a20191111_01_dateandtime

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : BaseActivity() {

//    시작일자/시간을 모두 저장하고 있는 캘린더 변수.
    var startDateTimeCalendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        startDateBtn.setOnClickListener { 
            var datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

//                시작일시 변수에 선택값 반영
                startDateTimeCalendar.set(year, month, dayOfMonth)

//                버튼에 2019-09-08 양식으로 출력.
                var sdf = SimpleDateFormat("yyyy-MM-dd (EEE)")

//                버튼에 sdf를 이용해서 선택된 날짜를 String으로 변환
                startDateBtn.text = sdf.format(startDateTimeCalendar.time)

            }, startDateTimeCalendar.get(Calendar.YEAR)
             , startDateTimeCalendar.get(Calendar.MONTH)
             , startDateTimeCalendar.get(Calendar.DAY_OF_MONTH))

            datePickerDialog.show()
        }
        
        startTimeBtn.setOnClickListener {
            var timePickerDialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->

                startDateTimeCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                startDateTimeCalendar.set(Calendar.MINUTE, minute)

                var sdf = SimpleDateFormat("a hh시 mm분")

                startTimeBtn.text = sdf.format(startDateTimeCalendar.time)
            },
                startDateTimeCalendar.get(Calendar.HOUR_OF_DAY),
                startDateTimeCalendar.get(Calendar.MINUTE), false)
            timePickerDialog.show()
        }
    }

    override fun setValues() {

    }


}
