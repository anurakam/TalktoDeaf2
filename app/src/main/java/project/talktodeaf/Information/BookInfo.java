package project.talktodeaf.Information;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.cengalabs.flatui.views.FlatTextView;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

import project.talktodeaf.Model.Book;
import project.talktodeaf.Rest.ApiService;
import project.talktodeaf.main.R;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class BookInfo extends ActionBarActivity {
    String method ="book.php";
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);
        listView = (ListView)findViewById(R.id.listView);
        GsonBuilder builder = new GsonBuilder();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("http://192.168.46.1:80")
                .setConverter(new GsonConverter(builder.create()))
                .build();
        ApiService retrofit = restAdapter.create(ApiService.class);
        retrofit.getBookByMethodWithCallback(new Callback<List<Book>>() {
            @Override
            public void success(List<Book> book, Response response) {
                // accecss the items from you shop list here

                List<Book> ep = book;
                /*Example[] array = ep.toArray(new Example[ep.size()]);
                List<Example> listsample = ep.getSaleDate();*/
                listView.setAdapter(new BookListAdapter(ep));

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(BookInfo.this,
                        "Connect Failure Please Try Again",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public class BookListAdapter extends BaseAdapter {

        List<Book> Book;
        public BookListAdapter(List<Book> sd) {
            Book = sd;
        }
        @Override
        public int getCount() {
            return Book.size();
        }

        @Override
        public Object getItem(int position) {
            return Book.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        private class ViewHolder {
            FlatTextView bookName;
            FlatTextView position;
            ImageView image;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder  holder;
            LayoutInflater inflater = getLayoutInflater();

            if(convertView == null){
                convertView = inflater.inflate(R.layout.activity_book_info_column, parent,false);
                holder = new ViewHolder();
                holder.position=(FlatTextView)convertView.findViewById(R.id.position);
                holder.bookName=(FlatTextView)convertView.findViewById(R.id.bookName);
                holder.image=(ImageView)convertView.findViewById(R.id.img);
                convertView.setTag(holder);
            }else{
                holder=(ViewHolder)convertView.getTag();
            }
            Book bk = Book.get(position);
            holder.position.setText(""+(position+1));
            holder.bookName.setText("" + bk.getBook_name());
            Picasso.with(BookInfo.this).load(bk.getBook_image()).into(holder.image);




            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
