package sean.app.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import sean.app.R;
import sean.app.data.model.GymFactory;

import java.util.ArrayList;

public class GymFactoryAdapter extends RecyclerView.Adapter<GymFactoryAdapter.MyHolder> {

    private final Context context;
    ArrayList<GymFactory> gymFactories;
    // click listener
    private ItemClickListener mClickListener;

    public GymFactoryAdapter(Context context, ArrayList<GymFactory> gymFactories) {
        this.context = context;
        this.gymFactories = gymFactories;

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_row_gym_factory, parent, false);
        return new MyHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.linearLayout.setBackground(gymFactories.get(position).getDrawableId());
        holder.levelTextView.setText(gymFactories.get(position).getLevel());
        holder.typeTextView.setText(gymFactories.get(position).getType());
        holder.detailTextView.setText(gymFactories.get(position).getDetail());
    }

    @Override
    public int getItemCount() {
        return gymFactories.size();
    }


    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public void setAdapterData(ArrayList<GymFactory> adapterData) {
        this.gymFactories = adapterData;
    }

    public GymFactory getItem(int id) {
        return gymFactories.get(id);
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView levelTextView, typeTextView, detailTextView;
        Button bookClassButton;
        LinearLayout linearLayout;

        public MyHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            levelTextView = itemView.findViewById(R.id.tv_level);
            typeTextView = itemView.findViewById(R.id.tv_type);
            bookClassButton = itemView.findViewById(R.id.btn_book_class);
            linearLayout = itemView.findViewById(R.id.ll_root);
            detailTextView = itemView.findViewById(R.id.tv_detail);

            bookClassButton.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }

    }
}