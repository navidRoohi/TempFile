package com.example.navidroohibroojeni.labassignment6a;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{


    private Button clearBtn;
    private TextView textView;
    private GestureDetector detector;
    private String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clearBtn = (Button)findViewById(R.id.clearId);
        textView = (TextView)findViewById(R.id.textviewId);

        detector = new GestureDetector(this, this);
    }


    // clear Button
    public void clearPage(View view){
        textView.setText("");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }


    // Six implemented methods from interface : GestureDetector.OnGestureListene
    @Override
    public boolean onDown(MotionEvent e) {
        message = String.format("onDown: (%f, %f)\n", e.getX(), e.getY());
        textView.setText(textView.getText() + message);
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        message = String.format("onShowPress: (%f, %f)\n", e.getX(), e.getY());
        textView.setText(textView.getText() + message);

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        message = String.format("onSingleTapUp: (%f, %f)\n", e.getX(), e.getY());
        textView.setText(textView.getText() + message);
        return true;
    }


    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        message =  String.format("onScroll e1: (%f, %f)\n", e1.getX(), e1.getY() );
        message +=  String.format("onScroll e2: (%f, %f)\n", e2.getX(), e1.getY() );
        message +=  String.format("onScroll distance: (%f, %f)\n", distanceX, distanceY );

        textView.setText(textView.getText() + message);

        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        message = String.format("onLongPress: (%f, %f)\n", e.getX(), e.getY());
        textView.setText(textView.getText() + message);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        message =  String.format("onFling e1: (%f, %f)\n", e1.getX(), e1.getY() );
        message +=  String.format("onFling e2: (%f, %f)\n", e2.getX(), e1.getY() );
        message +=  String.format("onFling velocity: (%f, %f)\n", velocityX, velocityY );

        textView.setText(textView.getText() + message);

        return true;
    }
}
