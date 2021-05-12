package sean.app.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import sean.app.R;
import sean.app.data.model.MembershipPlan;

import java.util.ArrayList;

public class MembershipAdapter extends RecyclerView.Adapter<MembershipAdapter.ViewHolder> {

    private final Context context;
    private final LayoutInflater mInflater;
    private ArrayList<MembershipPlan> adapterData;
    // click listener
    private ItemClickListener mClickListener;

    // data is passed into the constructor along with contect
    public MembershipAdapter(Context context, ArrayList<MembershipPlan> data) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.adapterData = data;
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_row_membership, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.nameTextView.setText(adapterData.get(position).getName());
        holder.detailsTextView.setText(adapterData.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        if (adapterData != null)
            return adapterData.size();
        else return 0;
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public void setAdapterData(ArrayList<MembershipPlan> adapterData) {
        this.adapterData = adapterData;
    }

    public MembershipPlan getItem(int id) {
        return adapterData.get(id);
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameTextView;
        TextView detailsTextView;
        Button viewButton;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_name);
            detailsTextView = itemView.findViewById(R.id.tv_details);
            viewButton = itemView.findViewById(R.id.btn_view);
            viewButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}