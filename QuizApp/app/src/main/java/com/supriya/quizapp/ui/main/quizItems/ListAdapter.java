package com.supriya.quizapp.ui.main.quizItems;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.supriya.quizapp.R;
import com.supriya.quizapp.network.model.quizList.QuizListModel;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<QuizListModel> quizList;
    private OnItemClickedListener OnItemClickedListener;

    public void updateQuizList(List<QuizListModel> updatedList){
        this.quizList = quizList;
    }

    public void setDataModels(List<QuizListModel> dataModels) {
        this.quizList = dataModels;
        this.notifyDataSetChanged();
    }

    public ListAdapter(OnItemClickedListener onItemClickedListener){
        this.OnItemClickedListener = onItemClickedListener;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_quiz , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
           QuizListModel model = quizList.get(position);
           holder.title.setText(model.getTitle());
           Glide.with(holder.title).load(model.getImage()).into(holder.quizImage);
    }

    @Override
    public int getItemCount() {

        if (quizList == null){
            return 0;
        }else {
            return quizList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private ImageView quizImage;
        private ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {super(itemView);

            title = itemView.findViewById(R.id.tvQuizTitle);
            quizImage = itemView.findViewById(R.id.ivQuizImage);
            constraintLayout = itemView.findViewById(R.id.parentContainer);
            constraintLayout.setOnClickListener(this);
        }
        public void onClick(View v){
            OnItemClickedListener.onItemClick(getAdapterPosition());
        }
    }
    public interface OnItemClickedListener {
        void onItemClick(int position);
    }
}
