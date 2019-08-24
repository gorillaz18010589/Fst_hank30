package tw.brad.apps.bradb30;
//目的:按下時間框框或點選日期,跳出日期框
//2.設計吐司麵包,在
//4.搭配新版本(未用)
//5.待gitub
//加入implementation 'com.android.support:design:28.0.0'

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;
import java.util.Date;
public class MainActivity extends AppCompatActivity {
    private TextView birthday;
    private View rootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.rootView);
        birthday = findViewById(R.id.birthday);

    }

    //創建輸入框,請他點選生日呼叫方法
    public void selectDate(View view) {
        final DatePickerDialog dialog = new DatePickerDialog(this, //1.這個頁面
                DatePickerDialog.THEME_DEVICE_DEFAULT_DARK, //2.模式
                null,2019,8,15);//3.預設日期

        //當點選日期對話框觸發式建
        dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) { //回傳年,月,日
                birthday.setText(year +"/" + month  +"/" + day);//顯示在螢幕

            }
        });


        DatePicker picker= dialog.getDatePicker(); //從肚子裡取得日期picker

        //指定這個日期以後的時間都不能選
        Calendar limit = Calendar.getInstance();//取得日立的資料物件實體
        limit.set(2019,8,15); //設定日期
        long limitdate = limit.getTimeInMillis(); //取得這個物件的千分之一秒
        picker.setMaxDate(limitdate); //設置最大的

        dialog.show();//顯示出來
    }

    //按按鈕出現toast提醒一般版本
    public void test1(View view){
        Toast toast = Toast.makeText(this,"hello,world",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.FILL_HORIZONTAL + Gravity.CENTER_VERTICAL,
                0,0);//專門設計一個版面容器(水平置中,垂直至中,偏移量x,偏移量y)
//        toast.show();
        showMyToast("haha");//呼叫自訂的toast的方法
    }

    //險是我自訂的toast的圖片跟設計
    private  void showMyToast(String mesg){
        LayoutInflater layoutInflater = getLayoutInflater(); //從你這裡的activity取得浮現的東西物件實體
        View view = layoutInflater.inflate(R.layout.toast_view,null);//指定我要的畫面為(資源區)

        TextView txtMesg = view.findViewById(R.id.toast_mesg);
        txtMesg.setText(mesg); //你輸入的自訂文字顯示出來

        //設定toast的調整,跟我自己設計的整合
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.FILL_HORIZONTAL + Gravity.CENTER_VERTICAL,
                0,100);//專門設計一個版面容器(水平置中,垂直至中,偏移量x,偏移量y)
        toast.setDuration(Toast.LENGTH_SHORT); //出現短短的時間
        toast.setView(view);
        toast.show();

    }
    //引入Snackbar的api類似toast
    public void test2(View view) {
        Snackbar.make(rootView,
                "Hello, World",Snackbar.LENGTH_LONG).show();
    }
}