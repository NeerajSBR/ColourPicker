package com.farizma.colorpalettefromimage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import static com.farizma.colorpalettefromimage.display.colorList;
import static com.farizma.colorpalettefromimage.display.current_brush;
import static com.farizma.colorpalettefromimage.display.pathList;

public class drawer extends AppCompatActivity implements View.OnClickListener {
    private Button imgbutton;
    public static Path path = new Path();
    public static Paint paint_brush = new Paint();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        imgbutton = (Button)findViewById(R.id.save_btn);
        imgbutton.setOnClickListener(this);
        imgbutton.setVisibility(View.GONE);

    }

    public void pencil(View view) {
        paint_brush.setColor(Color.BLACK);
        currentColor(paint_brush.getColor());
    }
    public void eraser(View view) {
        pathList.clear();
        colorList.clear();
        path.reset();
    }
    public void redColor(View view) {
        paint_brush.setColor(Color.RED);
        currentColor(paint_brush.getColor());
    }
    public void yellowColor(View view) {
        paint_brush.setColor(Color.YELLOW);
        currentColor(paint_brush.getColor());
    }
    public void greenColor(View view) {
        paint_brush.setColor(Color.GREEN);
        currentColor(paint_brush.getColor());
    }
    public void magentaColor(View view) {
        paint_brush.setColor(Color.MAGENTA);
        currentColor(paint_brush.getColor());
    }
    public void blueColor(View view) {
        paint_brush.setColor(Color.BLUE);
        currentColor(paint_brush.getColor());
    }

    public void currentColor(int c) {
        current_brush = c;
        path = new Path();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.save_btn) {
            AlertDialog.Builder saveDialogue = new AlertDialog.Builder(this);
            saveDialogue.setTitle("Save?");
            saveDialogue.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            saveDialogue.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.cancel();
                }
            });
            saveDialogue.show();
        }
    }
}