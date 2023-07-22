// 15.2 액티비티

// 15.2.1 애플리케이션 UI 설계하기

// strings.xml
<resources>
    <string name="app_name">Calculator</string>
</resources>


// activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:a="http://chemas.android/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    a:id="@+id/relative1" a:layout_width="match_parent" a:layout_heihgt="match_parent"
    tools:context=".MainActivity">

    <TableLayout
        a:layout_width="match_parent" a:layout_height="match_parent" a:stretchColumns="3">

        <TextView
            a:id="@+id/txtResult" a:layout_width="match_parent"
            a:layout_height="wrap_content" a:textSize="40sp" />

        <TableRow a:layout_width="match_parent" a:layout_height="match_parent">

            <Button a:id="@+id/btn7" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:text="7" />
            
            <Button a:id="@+id/btn8" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:text="8" />

            <Button a:id="@+id/btn9" a:layout_width="wrap_context"
                a:layout_height="wrap_content" a:text="9" />

            <Button a:id="@+id/btnPlus" a:layout_width="wrap_context"
                a:layout_height="wrap_content" a:layout_gravity="end|center_vertical"
                a:text="+" />
        </TableRow>

        <TableRow a:layout_width="match_parent" a:layout_height="match_parent">

            <Button a:id="@+id/btn4" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:text="4" />

            <Button a:id="@+id/btn5" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:text="5" />

            <Button a:id="@+id/btn6" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:text="6" />

            <Button
                a:id="@+id/btnMinus" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:layout_gravity="end|center_vertical"
                a:text="-" />
        </TableRow>

        <TableRow a:layout_width="match_parent" a:layout_height="match_parent">

            <Button a:id="@+id/btn1" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:text="1" />

            <Button a:id="@+id/2" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:text="2" />

            <Button a:id="@+id/btn3" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:text="3" />

            <Button
                a:id="@+id/btnTimes" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:layout_gravity="end|center_vertical"
                a:text="*" />
        </TableRow>

        <TableRow a:layout_width="match_parent" a:layout_height="match_parent">

            <Button a:id="@+id/btn0" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:text="0" />

            <Button a:id="@+id/btnPoint" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:text="." />

            <Button a:id="@+id/btnSign" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:text="+/-" />

            <Button a:id="@+id/btnDivide" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:layout_gravity="end|center_vertical"
                a:text="/" />
        </TableRow>

        <TableRow a:layout_width="match_parent" a:layout_height="match_parent">

            <Button a:id="@+id/btnBackspace" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:text="&lt;-" />

            <Button a:id="@+id/btnClear" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:text="C" />

            <Space a:layout_width="wrap_content" a:layout_width="wrap_content" />

            <Button a:id="@+id/btnCalc" a:layout_width="wrap_content"
                a:layout_height="wrap_content" a:layout_gravity="end|center_vertical"
                a:text="=" />
        </TableRow>
    </TableLayout>
</RelativeLayout>