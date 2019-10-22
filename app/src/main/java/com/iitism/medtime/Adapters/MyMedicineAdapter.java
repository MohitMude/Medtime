package com.iitism.medtime.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iitism.medtime.ModelClass.MyMedicineModel;
import com.iitism.medtime.R;

import java.util.List;

public class MyMedicineAdapter extends RecyclerView.Adapter<MyMedicineAdapter.ViewHolder> {

    Context context;
   List<MyMedicineModel> list;

    public MyMedicineAdapter(Context context, List<MyMedicineModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medicine_card,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

      MyMedicineModel myMedicineModel=list.get(position);
      String a="Name : "+myMedicineModel.getMedname();
      String b="Type : "+myMedicineModel.getMedtype();

      holder.medname.setText(a);
      holder.medtype.setText(b);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView medname,medtype;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            medname=itemView.findViewById(R.id.txt_med_name);
            medtype=itemView.findViewById(R.id.txt_med_type);
        }
    }
}
