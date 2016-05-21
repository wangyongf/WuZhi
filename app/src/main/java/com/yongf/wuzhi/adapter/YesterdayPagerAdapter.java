package com.yongf.wuzhi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yongf.wuzhi.R;
import com.yongf.wuzhi.bean.GetPostAnswersBean.AnswersBean;

import java.util.ArrayList;
import java.util.List;

public class YesterdayPagerAdapter extends RecyclerView.Adapter<YesterdayPagerAdapter.MyViewHolder> {

    private List<AnswersBean> mAnswers = new ArrayList<>();
    private LayoutInflater mInflater;
    private OnItemClickListener mOnItemClickListener;

    public YesterdayPagerAdapter(Context context, List<AnswersBean> answers) {
        mInflater = LayoutInflater.from(context);
        mAnswers = answers;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(
                R.layout.item_reply, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.mTvTitle.setText(mAnswers.get(position).getTitle());
        holder.mTvReply.setText(mAnswers.get(position).getSummary());
        holder.mTvDate.setText(mAnswers.get(position).getTime());
        holder.mTvVote.setText(mAnswers.get(position).getVote());

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, pos);

                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mAnswers.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    class MyViewHolder extends ViewHolder {

        TextView mTvTitle;       //问题
        TextView mTvReply;          //回答
        TextView mTvDate;           //最后更新日期
        TextView mTvVote;           //点赞数

        public MyViewHolder(View view) {
            super(view);

            mTvTitle = (TextView) view.findViewById(R.id.tv_title);
            mTvReply = (TextView) view.findViewById(R.id.tv_reply);
            mTvDate = (TextView) view.findViewById(R.id.tv_date);
            mTvVote = (TextView) view.findViewById(R.id.tv_vote);
        }
    }
}
