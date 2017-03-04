package by.black_pearl.userapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import by.black_pearl.userapp.R;
import by.black_pearl.userapp.UserData;
import by.black_pearl.userapp.activities.UserDetailActivity;

/**
 * Created by BLACK_Pearl.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static String NUM_NAME = "№";
    private static String NAME_NAME = "Name";

    private List<UserData> mUsers;
    private Context mContext;

    public RecyclerViewAdapter(Context context) {
        this.mContext = context;
        mUsers = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(position == 0) {
            holder.number.setText(NUM_NAME);
            holder.name.setText(NAME_NAME);
            return;
        }
        holder.number.setText(String.valueOf(position));
        holder.name.setText(mUsers.get(position - 1).firstName + " " + mUsers.get(position - 1).lastName);
        holder.name.setOnClickListener(getOnNameClickListener(position - 1));
        holder.del_image.setOnClickListener(getOnDelButtonListener(position - 1));
    }

    private View.OnClickListener getOnDelButtonListener(int pos) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }

    private View.OnClickListener getOnNameClickListener(final int pos) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, UserDetailActivity.class)
                        .putExtra(UserDetailActivity.INCOME, mUsers.get(pos).income)
                        .putExtra(UserDetailActivity.CITY, mUsers.get(pos).city)
                        .putExtra(UserDetailActivity.SEX, mUsers.get(pos).sex)
                        .putExtra(UserDetailActivity.AGE, mUsers.get(pos).age)
                        .putExtra(UserDetailActivity.LAST_NAME, mUsers.get(pos).lastName)
                        .putExtra(UserDetailActivity.FIRST_NAME, mUsers.get(pos).firstName)
                        .putExtra(UserDetailActivity.ID, mUsers.get(pos).id));
            }
        };
    }

    @Override
    public int getItemCount() {
        return mUsers.size() + 1;
    }

    public void changeData(List<UserData> body) {
        this.mUsers = body;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView number;
        private final TextView name;
        private final ImageView del_image;

        ViewHolder(View itemView) {
            super(itemView);
            this.number = (TextView) itemView.findViewById(R.id.view_recycler_item_numberTV);
            this.name = (TextView) itemView.findViewById(R.id.view_recycler_item_nameTV);
            this.del_image = (ImageView) itemView.findViewById(R.id.view_recycler_item_deleteIV);
        }
    }
}
