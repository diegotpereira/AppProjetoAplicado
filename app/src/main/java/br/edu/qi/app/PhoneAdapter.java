package br.edu.qi.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/13.
 */
public class PhoneAdapter extends BaseAdapter {
    private String name;
    private List<PhoneBean> phoneBeanLists;
    private Context context;
    private LinearLayout linearLayout;


    public PhoneAdapter(List<PhoneBean> phoneBeanLists,Context context) {
        this.phoneBeanLists = phoneBeanLists;
        this.context = context;


    }



    public List<PhoneBean> getPhoneBeanLists(){
        return phoneBeanLists;
    }
    @Override
    public int getCount() {
        //返回集合的数量
        return phoneBeanLists.size();
    }

    @Override
    public Object getItem(int position) {
        //获取当条数据
        return phoneBeanLists.get(position);
        //return null;
    }

    @Override
    public long getItemId(int position) {
        //获取当前ID
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //必需要加载View,而这个View就是要将数据加载到的视图。
        //需求创建电话内容每一条显示的格式
        //获取加载View权限
        /*LayoutInflater inflater = LayoutInflater.from(context);
        linearLayout =(LinearLayout)inflater.inflate(R.layout.callstyle,null);
        TextView phoneNameTv = (TextView)linearLayout.findViewById(R.id.phoneName);
        TextView phoneNumberTv = (TextView)linearLayout.findViewById(R.id.phoneNumber);
        phoneNameTv.setText(phoneBeanLists.get(position).getPhoneName());
        phoneNumberTv.setText(phoneBeanLists.get(position).getPhoneNumber());*/
        final ViewHolder holder;

        if (convertView ==null){
            //并没有加载View
            convertView = LayoutInflater.from(context).inflate(R.layout.phone_item,null);
            holder = new ViewHolder();
            holder.nameTv = (TextView) convertView.findViewById(R.id.phoneName);
            holder.numberTv = (TextView) convertView.findViewById(R.id.phoneNumber);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.cb);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.nameTv.setText(phoneBeanLists.get(position).getPhoneName());
        holder.numberTv.setText(phoneBeanLists.get(position).getPhoneNumber()  );

        holder.checkBox.setText("");


        holder.checkBox.setChecked(phoneBeanLists.get(position).getSelected());

        holder.checkBox.setTag(R.integer.btnplusview, convertView);
        holder.checkBox.setTag( position);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                View tempview = (View) holder.checkBox.getTag(R.integer.btnplusview);
                Integer pos = (Integer)  holder.checkBox.getTag();
                ///Toast.makeText(context, "Checkbox "+pos+" clicked!", Toast.LENGTH_SHORT).show();

                if(phoneBeanLists.get(pos).getSelected()){
                    phoneBeanLists.get(pos).setSelected(false);
                }else {
                    phoneBeanLists.get(pos).setSelected(true);
                }

            }
        });




        return convertView;

    }
    //定义ViewHolder
    private static class ViewHolder{
        TextView nameTv;
        TextView numberTv;
        protected CheckBox checkBox;


    }

    public static abstract class MyListener implements View.OnClickListener {
        int mPosition;
        ViewHolder holder;
        /*  public MyListener(int inPosition){
              mPosition= inPosition;
          }*/
        @Override
        public void onClick(View v) {
            myOnClick((Integer) v.getTag(), v);
            // holder.btntry.setText("haha");
            //  Toast.makeText(context,"ji",Toast.LENGTH_SHORT).show();
            // TODO Auto-generated method stub
           /* Intent callitt=new Intent();
            callitt.setAction(Intent.ACTION_CALL);
            callitt.setData(Uri.parse("tel:18363853385"));
            context.startActivity(callitt);
            */
        }
        public abstract void myOnClick(int position, View v);

    }
    public static abstract class SMSListener implements View.OnClickListener {
        public void onClick(View v) {
            myOnClick((Integer) v.getTag(), v);
        }
        public abstract void myOnClick(int position, View v);
    }

}