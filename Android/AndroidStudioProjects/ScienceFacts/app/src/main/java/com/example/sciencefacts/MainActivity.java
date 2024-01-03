package com.example.sciencefacts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String[] scienceFacts = {
            "Sohoton Natural Bridge National Park.",
            "Sambawan Island , Biliran.",
            "Sto. Nino Shrine and Heritage Museum.",
            "Lake Danao , Cabalian.",
            "Lulugayan Falls, Calbiga Samar.",
            "Homonhon Island, Guiuan Estern Samar.",
            "Marabut Rock Formation ,Marabut Samar.",
            "Tinago Falls , Biliran.",
            "Sto. Nino Church , Tacloban City , Leyte.",
            "Macqueda Bay, Catbalogan , Samar .",
            "Capul Island , Northern Samar.",
            "Silago Rock Formation.",
            "Navalas Chruch, Guimaras.",
            "Rafael Farm , Babatngon , Leyte.",
            "Biri Island Rock Formation.",
            "Pinipiskan Falls & Sulpan Cave , San Jorge, Samar.",
            
            "Divinubo Island , Borongan ,Eastern Samar.",
            "San Juanico Bridge.",
            "Panian Tubod.",
            "Kalanggaman Island , Palompon, Leyte.",




    };
    private final int[] scienceFactImages = {
            R.drawable.pic_1,
            R.drawable.pic_2,
            R.drawable.pic_3,
            R.drawable.pic_4,
            R.drawable.pic_5,
            R.drawable.pic_6,
            R.drawable.pic_7,
            R.drawable.pic_8,
            R.drawable.pic_9,
            R.drawable.pic_10,
            R.drawable.pic_11,
            R.drawable.pic_12,
            R.drawable.pic_13,
            R.drawable.pic_14,
            R.drawable.pic_15,
            R.drawable.pic_16,
            R.drawable.pic_17,
            R.drawable.pic_18,
            R.drawable.pic_19,
            R.drawable.pic_20,


    };

    private TextView factTextView;

    private Button generateButton;

    private ImageView factImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateButton = findViewById(R.id.generateButton);
        factTextView = findViewById(R.id.factTextView);
        factImageView = findViewById(R.id.factImageView);


        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              displayRandomFact();
            }
        });
    }
    private void displayRandomFact(){
        int randomIndex = new Random().nextInt(scienceFacts.length);

        factTextView.setText(scienceFacts[randomIndex]);

        factImageView.setImageResource(scienceFactImages[randomIndex]);
    }
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

            }
        });

        builder.show();
    }

    public void shareApp(View view){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Check out this app!");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "I found this amazing app. You should try it!\nwww.google.com");

        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }



}
