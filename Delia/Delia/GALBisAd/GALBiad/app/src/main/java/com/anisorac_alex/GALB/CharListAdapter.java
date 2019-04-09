package com.anisorac_alex.GALB;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by Napoca_MoveUp on 8/18/2017.
 */

public class CharListAdapter extends BaseAdapter implements  Filterable{
    private Activity mActivity;
    private DatabaseReference mDatabaseReference;
    private ArrayList<DataSnapshot> mSnapshot;
    private ArrayList<MesajInstant> list = new ArrayList<MesajInstant>();
    private ArrayList<MesajInstant> Dlist= new ArrayList<MesajInstant>();
    private String mString;
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

    public CharListAdapter(Activity activity, DatabaseReference reference,String string)
    {

        mActivity=activity;
        mDatabaseReference=reference.child("Anunt");
        mDatabaseReference.addChildEventListener(mListener);
        mSnapshot=new ArrayList<>();
        mString = string;

        Dlist = list;
    }
    static class ViewHolder{
        TextView autor;
        TextView text;
        LinearLayout.LayoutParams params;
    }
    @Override
    public int getCount() {
        if(Dlist.size() != 0 && Dlist != null)
        {
            if(mString != "")
              return Dlist.size();
        }

            return mSnapshot.size();


    }


    @Override
    public MesajInstant getItem(int position) {

        DataSnapshot snapshot=mSnapshot.get(position);
        return snapshot.getValue(MesajInstant.class);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            LayoutInflater inflater=(LayoutInflater)mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.chat_msg_row,parent,false);

            final ViewHolder holder=new ViewHolder();
            holder.autor=(TextView)convertView.findViewById(R.id.author);
            holder.text=(TextView)convertView.findViewById(R.id.message);
            holder.params=(LinearLayout.LayoutParams)holder.text.getLayoutParams();

            convertView.setTag(holder);
        }

        final MesajInstant msj=getItem(mSnapshot.size()-position-1);
        final ViewHolder holder=(ViewHolder)convertView.getTag();


                list.add(position, msj);
                holder.autor.setText(msj.getAutor().toString());
                holder.text.setText(msj.getText().toString());



        return convertView;
    }
    public void cleaner()
    {
        mDatabaseReference.removeEventListener(mListener);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                ArrayList<MesajInstant> Filetr= new ArrayList<MesajInstant>();
                if(list == null)
                {
                    list = new ArrayList<MesajInstant>(Dlist);
                }


                if(constraint == null || constraint.length() == 0)
                {
                    filterResults.count = list.size();
                    filterResults.values = list;
                }
                else
                {
                    constraint = constraint.toString().toLowerCase();
                    for(int i=0;i<list.size();i++)
                    {
                        String data =  list.get(i).getText();
                        if(data.contains(constraint))
                            Filetr.add(list.get(i));
                    }

                    filterResults.count = Filetr.size();
                    filterResults.values = Filetr;

                }

                return  filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                Dlist = (ArrayList<MesajInstant>)results.values;
                notifyDataSetChanged();

            }
        };

    }

}
