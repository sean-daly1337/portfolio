package sean.app.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import sean.app.R;
import sean.app.data.model.DeliverySlotModel;
import sean.app.ui.interfaces.OnItemClickListener;

import java.util.ArrayList;

public class DeliverySlotAdapter extends RecyclerView.Adapter<DeliverySlotAdapter.MyHolder> {

    private final Context context;
    private final OnItemClickListener listener;
    ArrayList<DeliverySlotModel> deliverySlotModels;

    public DeliverySlotAdapter(Context context, ArrayList<DeliverySlotModel> deliverySlotModels, OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
        this.deliverySlotModels = deliverySlotModels;
    }

     /*
    INITIALIZE VIEWHOLDER
     */

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_delivery_time, parent, false);
        return new MyHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.setData(deliverySlotModels.get(position));
    }

    @Override
    public int getItemCount() {
        return deliverySlotModels.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_range;
        LinearLayout ll_root;
        DeliverySlotModel deliverySlotModel = null;

        public MyHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv_range = itemView.findViewById(R.id.tv_range);
            ll_root = itemView.findViewById(R.id.ll_root);

        }

        public void setData(DeliverySlotModel deliverySlotModel) {
            this.deliverySlotModel = deliverySlotModel;
            tv_range.setText(deliverySlotModel.getRange());
            if (deliverySlotModel.getDisable()) {
                tv_range.setTextColor(context.getResources().getColor(R.color.colorThemeInputHint));
                ll_root.setBackground(context.getResources().getDrawable(R.drawable.bg_disable_delivery_time));
            } else {
                if (deliverySlotModel.getSelected()) {
                    tv_range.setTextColor(context.getResources().getColor(R.color.colorWhite));
                    ll_root.setBackground(context.getResources().getDrawable(R.drawable.bg_selected_delivery_time));
                } else {
                    tv_range.setTextColor(context.getResources().getColor(R.color.colorThemeRoyalBlue));
                    ll_root.setBackground(context.getDrawable(R.drawable.bg_unselected_delivery_time));
                }
            }
        }

        @Override
        public void onClick(View v) {
            for (DeliverySlotModel deliverySlotModel : deliverySlotModels) {
                if (!deliverySlotModel.getDisable()) {
                    deliverySlotModel.setSelected(deliverySlotModel.equals(deliverySlotModels.get(getAdapterPosition())));
                }
            }
            listener.onItemClick(getAdapterPosition());
            notifyDataSetChanged();
        }

    }
}