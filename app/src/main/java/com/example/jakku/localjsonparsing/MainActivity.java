package com.example.jakku.localjsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = (TextView) findViewById(R.id.text_view);
//        TextView text1 = (TextView) findViewById(R.id.text_view1);
//        TextView text2 = (TextView) findViewById(R.id.text_view2);
//        TextView text3 = (TextView) findViewById(R.id.text_view3);

        String data = "";

        try{
            JSONObject object1 =new  JSONObject(loadJSONFromAsset());
            JSONArray object  =object1.getJSONArray("People");
           // JSONArray array =
            for(int i=0; i<object.length(); i++){
                JSONObject array = object.getJSONObject(i);

                String name1 = array.getString("name");
                int age1 = array.getInt("age");
//                text.setText(array.getString("name"));
//                text1.setText(array.getString("age"));
//                text2.setText(array.getString("name"));
//                text3.setText(array.getString("age"));

                data += "Node"+i+" : \n id= "+ name1 +" \n Name= "+ age1 ;

            }
             text.setText(data);


        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

    private String loadJSONFromAsset(){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream is = getAssets().open("people.json");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(is));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            bufferedReader.close();

            Log.d("X","Response Ready:"+stringBuilder.toString());

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
