package com.ungpay.thirdpartyplatformsandframeworks.ui.alipayui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHodlers> {


    private Context context;
    private ArrayList<String> datas;

    public RecycleViewAdapter(Context context, ArrayList<String> datas) {
        this.context = context;
        this.datas = datas;

    }

    @NonNull
    @Override
    public ViewHodlers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHodlers viewHodlers = new ViewHodlers(LayoutInflater.from(context).inflate(R.layout.activity_alipay_home_recycle_view_item, parent, false));
        return viewHodlers;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodlers holder, int position) {
        Log.e("~~",datas.get(position));
        holder.tvTransactionTitle.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class ViewHodlers extends RecyclerView.ViewHolder {
        TextView tvTransactionTitle;

        public ViewHodlers(@NonNull View itemView) {
            super(itemView);
            tvTransactionTitle = itemView.findViewById(R.id.content);
        }
    }
}
