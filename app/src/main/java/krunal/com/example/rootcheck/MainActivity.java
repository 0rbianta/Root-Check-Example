package krunal.com.example.rootcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.scottyab.rootbeer.RootBeer;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private ImageView imgResult;
    private Button btnChkRoot;
    private CardView cvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult=findViewById(R.id.txtResult);
        imgResult=findViewById(R.id.imgResult);
        btnChkRoot=findViewById(R.id.btnChkRoot);
        cvResult=findViewById(R.id.cvRootResult);

    }

    public void chkButtonClick(View v){
        checkRoot();
    }

    private void checkRoot(){
        btnChkRoot.setText("Check again");
        RootBeer rootBeer = new RootBeer(this);
        rootBeer.setLogging(true);
//        if (rootBeer.isRooted()) {
//            //we found indication of root
//            Log.e("isRooted", String.valueOf(rootBeer.isRooted()));
//            TextView.setText("Root Status:- Your device is Rooted.");
//        } else {
//            //we didn't find indication of root
//            Log.e("isRooted", String.valueOf(rootBeer.isRooted()));
//            TextView.setText("Root Status:- Your device is Not Rooted.");
//        }

        if (rootBeer.isRootedWithoutBusyBoxCheck()){
            //we found indication of root
            Log.e("isRootedBusyBoxCheck", String.valueOf(rootBeer.isRooted()));
            txtResult.setText("Your device is Rooted.");
            cvResult.setVisibility(View.VISIBLE);
            imgResult.setBackgroundResource(R.drawable.ic_baseline_lock_open_24);


        }else {
            //we didn't find indication of root
            Log.e("isRootedBusyBoxCheck", String.valueOf(rootBeer.isRooted()));
            txtResult.setText("Your device is Not Rooted.");
            cvResult.setVisibility(View.VISIBLE);
            imgResult.setBackgroundResource(R.drawable.ic_baseline_lock_open_24);

        }
    }
}
