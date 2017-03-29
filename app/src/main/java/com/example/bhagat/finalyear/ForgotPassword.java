package com.example.bhagat.finalyear;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.msg91.sendotp.library.SendOtpVerification;
import com.msg91.sendotp.library.VerificationListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Shashank on 29-03-2017.
 */

public class ForgotPassword extends AppCompatActivity {
    Button send;
    EditText mobileNo;
    RadioButton isProvider,isConsumer;
    String userType;
    VerificationListener mVerification;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        /*MessageDigest md = null;
        try {
            PackageInfo info = this.getPackageManager().getPackageInfo(
                    this.getPackageName(),
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
        Log.i("SecretKey = ",Base64.encodeToString(md.digest(), Base64.DEFAULT));
        */


        send = (Button) findViewById(R.id.send_mobile_no);
        mobileNo = (EditText) findViewById(R.id.mobile_no);
        isProvider = (RadioButton) findViewById(R.id.is_provider);
        isConsumer = (RadioButton) findViewById(R.id.is_consumer);

        if(isProvider.isChecked()){
            userType = "provider";
        }
        else{
            userType = "consumer";
        }

        //mVerification = SendOtpVerification.createSmsVerification(this, "set_phone_number", this, "set_country_code");


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = mobileNo.getText().toString();
                if (number.trim().length() == 0) {
                    Toast.makeText(ForgotPassword.this, "Please enter a mobile no", Toast.LENGTH_LONG).show();
                } else {


                    //sending otp on given number
                    /*Map<String, String> params = new HashMap<>();
                    params.put("user_mobile_no", number.trim());
                    params.put("user_type",userType);
                    String url = UserDetails.getInstance().url + "forgot_password.php";
                    VolleyNetworkManager.getInstance(getApplicationContext()).makeRequest(params,
                            url, new VolleyNetworkManager.Callback() {
                                @Override
                                public void onSuccess(String response) {

                                }
                                @Override
                                public void onError(String error) {
                                    Toast.makeText(getApplicationContext(),error,Toast.LENGTH_LONG).show();
                                }
                            });*/

                }
            }
        });
    }
}
