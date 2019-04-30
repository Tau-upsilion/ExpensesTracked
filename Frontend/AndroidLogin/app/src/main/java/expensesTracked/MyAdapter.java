package expensesTracked;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<ListItem> listItems;
    private Context context;
    public MyAdapter(List<ListItem> listItems, Context context){
        this.listItems = listItems;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        ListItem listItem = listItems.get(i);
        holder.textViewHead.setText(listItem.getHeader());
        holder.textViewDescription.setText(listItem.getDesc());
        holder.textViewAmount.setText(listItem.getDesc());
    }

    @Override
    public int getItemCount() {

        return listItems.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView textViewHead;
        public TextView textViewDescription;
        public TextView textViewAmount;

        public ViewHolder(View itemView){
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
            textViewAmount = (TextView) itemView.findViewById(R.id.textViewAmount);
        }
    }
}
