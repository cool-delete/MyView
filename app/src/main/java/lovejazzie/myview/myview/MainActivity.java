package lovejazzie.myview.myview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import lovejazzie.myview.v4.NumText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      setContentView(new Myview(this));
//        setContentView(R.layout.activity_main);
        setContentView(new NumText(this));
    }


}
