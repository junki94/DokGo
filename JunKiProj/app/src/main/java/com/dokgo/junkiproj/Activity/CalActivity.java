package com.dokgo.junkiproj.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dokgo.junkiproj.R;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

/**
 * Created by JawsGeun on 2018-01-30.
 */

public class CalActivity extends AppCompatActivity{
    DayViewDecorator oneDayDecorator;
    MaterialCalendarView materialCalendarView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);

//        materialCalendarView = (MaterialCalendarView)findViewById(R.id.calendarView);
//
//        materialCalendarView.state().edit()
//                .setFirstDayOfWeek(Calendar.SUNDAY)
//                .setMinimumDate(CalendarDay.from(2017,0,1))
//                .setMaximumDate(CalendarDay.from(2030,11,30))
//                .setCalendarDisplayMode(CalendarMode.MONTHS)
//                .commit();
//
//        materialCalendarView.addDecorators(
//                new SundayDecorator(),
//                new SaturdayDecorator(),
//                oneDayDecorator);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CalActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
