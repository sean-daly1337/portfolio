package sean.app.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sean.app.R;
import sean.app.data.model.Bookings;

public class BookingsAdapter extends RecyclerView.Adapter<BookingsAdapter.ViewHolder> {

    private final Context context;
    private final LayoutInflater mInflater;
    private ArrayList<Bookings> adapterData;
    // click listener
    private ItemClickListener mClickListener;

    // data is passed into the constructor along with context
    public BookingsAdapter(Context applicationContext, ArrayList<Bookings> bookingsArrayList) {
        this.context = applicationContext;
        this.mInflater = LayoutInflater.from(context);
        this.adapterData = bookingsArrayList;
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_upcoming_booking, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.dateTextView.setText(adapterData.get(position).getBookingDate());
        holder.timeTextView.setText(adapterData.get(position).getBookingTime());
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

    public void setAdapterData(ArrayList<Bookings> adapterData) {
        this.adapterData = adapterData;
        notifyDataSetChanged();
    }

    public Bookings getItem(int id) {
        return adapterData.get(id);
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView dateTextView;
        TextView timeTextView;
        Button cancelButton;

        ViewHolder(View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.tv_date_text);
            timeTextView = itemView.findViewById(R.id.tv_time_text);
            cancelButton = itemView.findViewById(R.id.btn_cancel);
            cancelButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
