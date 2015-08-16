package custom_toast.java.com.customtoastexample;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class CustomToast extends ActionBarActivity {

    public static String SUCCESS = "SUCCESS";
    public static String WARNING = "WARNING";
    public static String ERROR = "ERROR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);
    }

    public void showCustomToast(View v){

        RadioGroup radioSelection = (RadioGroup) findViewById(R.id.radioGroup);

        int selectedId = radioSelection.getCheckedRadioButtonId();

        if(selectedId == R.id.rbSuccess){
            this.createToast("Success message", SUCCESS, Toast.LENGTH_LONG);
        }
        else if(selectedId == R.id.rbWarning)
        {
            this.createToast("Warning message", WARNING, Toast.LENGTH_LONG);
        }
        else{
            this.createToast("Error message", ERROR, Toast.LENGTH_LONG);
        }

    }

    public void createToast(String message, String type, int duration){


        LayoutInflater inflater = getLayoutInflater();
        View toastView = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.rootLayout));

        ImageView imgView = (ImageView) toastView.findViewById(R.id.imgError);
        TextView msg = (TextView) toastView.findViewById(R.id.txtMessage);
        TableRow row = (TableRow)  toastView.findViewById(R.id.tableRow);

        if(type.equals(SUCCESS)){
            imgView.setImageResource(R.drawable.success);
            msg.setText(message);
            row.setBackgroundColor(getResources().getColor(R.color.green));
        }
        else if(type.equals(WARNING))
        {
            imgView.setImageResource(R.drawable.warning);
            msg.setText(message);
            row.setBackgroundColor(getResources().getColor(R.color.orange));
        }
        else{
            imgView.setImageResource(R.drawable.error);
            msg.setText(message);
            row.setBackgroundColor(getResources().getColor(R.color.red));
        }


        Toast toast = new Toast(this);
        toast.setDuration(duration);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setView(toastView);
        toast.show();

    }
}
