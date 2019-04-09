package com.anisorac_alex.GALBi;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Napoca_MoveUp on 8/18/2017.
 */

public class ListAdaptor extends BaseAdapter implements Filterable{
    private Activity mActivity;
    private DatabaseReference mDatabaseReference;
    private ArrayList<DataSnapshot> mSnapshot;
    private ChildEventListener mListener=new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            mSnapshot.add(dataSnapshot);
            notifyDataSetChanged();
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    public ListAdaptor(Activity activity,DatabaseReference reference)
    {
        mActivity=activity;
        mDatabaseReference=reference.child("Anunt");
        mDatabaseReference.addChildEventListener(mListener);
        mSnapshot=new ArrayList<>();
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        };
        return filter;
    }

    static class ViewHolder{
        TextView autor;
        TextView text;
        LinearLayout.LayoutParams params;

    }

    @Override
    public int getCount() {
        return mSnapshot.size();
    }

    @Override
    public MesajInstant getItem(int position) {
        DataSnapshot snapshot=mSnapshot.get(position) ;
        return snapshot.getValue(MesajInstant.class);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.chat_msg_row,parent,false);

            final ViewHolder holder=new ViewHolder();
            holder.autor=(TextView)convertView.findViewById(R.id.author);
            holder.text=(TextView)convertView.findViewById(R.id.message);
            holder.params=(LinearLayout.LayoutParams)holder.autor.getLayoutParams();

            convertView.setTag(holder);
        }
        final MesajInstant msj=getItem(position);
        final ViewHolder holder=(ViewHolder)convertView.getTag();

      //  setRowModel(holder);
        String autor=msj.getAutor();
        holder.autor.setText(autor);

        String text=msj.getText();
        holder.text.setText(text);


        return convertView;
    }

    private void setRowModel(ViewHolder holder)
    {
        holder.text.setBackgroundResource(R.drawable.blue);
    }

    public void cleaner()
    {
        mDatabaseReference.removeEventListener(mListener);
    }
}
