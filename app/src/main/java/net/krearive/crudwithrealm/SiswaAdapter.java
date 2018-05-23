package net.krearive.crudwithrealm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by idn on 9/26/2017.
 */

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ModelSiswa> dataSiswa;

    public SiswaAdapter(Context context, ArrayList<ModelSiswa> dataSiswa) {
        this.context = context;
        this.dataSiswa = dataSiswa;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //sambungkin komponen di dalam list-item
        TextView tvNama, tvAlamat;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvNama = (TextView) itemView.findViewById(R.id.tv_list_nama);
            tvAlamat = (TextView) itemView.findViewById(R.id.tv_list_alamat);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //sambungin sama list_item
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //set data
        holder.tvNama.setText(dataSiswa.get(position).getNama());
        holder.tvAlamat.setText(dataSiswa.get(position).getAlamat());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(context, UpdateSiswaActivity.class);
                pindah.putExtra("DATA_ID", dataSiswa.get(position).getId());
                pindah.putExtra("DATA_NAMA", dataSiswa.get(position).getNama());
                pindah.putExtra("DATA_ALAMAT", dataSiswa.get(position).getAlamat());
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSiswa.size();
    }


}
