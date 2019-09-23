package com.rodrigomiragaya.recyclerviewanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.Interpolator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;
    private ConstraintSet constrainOld = new ConstraintSet();
    private ConstraintSet constrainNew = new ConstraintSet();
    private boolean altLayout;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private InfoAdapter infoAdapter;
    private List<InfoClass> mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);

        constrainOld.clone(layout);
        constrainNew.clone(this,R.layout.activity_main2);

        //remove TTBar
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recy1);
        recyclerView2 = findViewById(R.id.recy2);
        mData = new ArrayList<>();

        mData.add(new InfoClass("Nombre", "Romualdo"));
        mData.add(new InfoClass("CUIT", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sollicitudin urna ut egestas commodo. Nunc ultrices vulputate neque nec commodo. Class aptent taciti"));
        mData.add(new InfoClass("Sexo", "Ftrices. Aenean varius vitae urna mattis accumsan. Nulla elementum placerat tellus eget ornare. Etiam quis lorem vitae lectus euismod pulvinar. Pra"));
        mData.add(new InfoClass("Persona", "DFipit tellus. Donec sapien neque, tristique et ipsum vel, dapibus interdum "));
        mData.add(new InfoClass("Vencimiento", "rerit ante, ut aliquet u"));
        mData.add(new InfoClass("Apellido", "Non sodales orci tincidunt non. Maecenas quis lore"));
        mData.add(new InfoClass("Nombre", "Tempor urna finibus. Pellentesque interdum tortor ac pharetra imperdiet. Phasellus nulla metus, pulvinar sit amet sollicitudin et, hendrerit eget diam. "));
        mData.add(new InfoClass("Nombre", "Romualdo"));
        mData.add(new InfoClass("CUIT", "DLorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sollicitudin urna ut egestas commodo. Nunc ultrices vulputate neque nec commodo. Class aptent taciti"));
        mData.add(new InfoClass("Sexo", "Sltrices. Aenean varius vitae urna mattis accumsan. Nulla elementum placerat tellus eget ornare. Etiam quis lorem vitae lectus euismod pulvinar. Pra"));
        mData.add(new InfoClass("Persona", "Vipit tellus. Donec sapien neque, tristique et ipsum vel, dapibus interdum "));
        mData.add(new InfoClass("Vencimiento", "Qerit ante, ut aliquet u"));
        mData.add(new InfoClass("Apellido", "Non sodales orci tincidunt non. Maecenas quis lore"));
        mData.add(new InfoClass("Nombre", "Romualdo"));
        mData.add(new InfoClass("CUIT", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sollicitudin urna ut egestas commodo. Nunc ultrices vulputate neque nec commodo. Class aptent taciti"));
        mData.add(new InfoClass("Sexo", "Itrices. Aenean varius vitae urna mattis accumsan. Nulla elementum placerat tellus eget ornare. Etiam quis lorem vitae lectus euismod pulvinar. Pra"));
        mData.add(new InfoClass("Persona", "Kipit tellus. Donec sapien neque, tristique et ipsum vel, dapibus interdum "));
        mData.add(new InfoClass("Vencimiento", "Merit ante, ut aliquet u"));
        mData.add(new InfoClass("Apellido", "Vnon sodales orci tincidunt non. Maecenas quis lore"));
        mData.add(new InfoClass("Nombre", "Dtempor urna finibus. Pellentesque interdum tortor ac pharetra imperdiet. Phasellus nulla metus, pulvinar sit amet sollicitudin et, hendrerit eget diam. "));

        infoAdapter = new InfoAdapter(this, mData);
        recyclerView.setAdapter(infoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        infoAdapter = new InfoAdapter(this, mData);
        recyclerView2.setAdapter(infoAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

    }

    public void chageLayouts(){
        Transition transition = new ChangeBounds();
        transition.setDuration(500);
        TransitionManager.beginDelayedTransition(layout, transition);

        if (!altLayout){
            constrainNew.applyTo(layout);
            altLayout = true;
        }
    }
}
