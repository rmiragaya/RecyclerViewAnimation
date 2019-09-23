package com.rodrigomiragaya.recyclerviewanimation;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {


    Context mContext;
    List<InfoClass> data;


    public InfoAdapter(Context mContext, List<InfoClass> data) {
        this.mContext = mContext;
        this.data = (data);
    }


    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final InfoViewHolder holder, final int position) {


        holder.icono.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_anim));

        holder.layout.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));

        holder.titulo.setText(data.get(position).getTitulo());
        holder.info.setText(data.get(position).getInfo());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "" + position + " " + data.get(position).getTitulo(), Toast.LENGTH_SHORT).show();
//                BounceInterpolator bounceInterpolator = new BounceInterpolator();
//                ObjectAnimator anim = ObjectAnimator.ofFloat(holder.layout, "translationX", 0f, -200 );
//                anim.setInterpolator(bounceInterpolator);
//                anim.setDuration(1100).start();
                if (mContext instanceof MainActivity){
                    ((MainActivity)mContext).chageLayouts();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView info;
        ImageView icono;
        ConstraintLayout layout;


        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.tituloid);
            info = itemView.findViewById(R.id.infoId);
            icono = itemView.findViewById(R.id.iconoid);
            layout = itemView.findViewById(R.id.constraintlayoutid);


        }
    }

}
