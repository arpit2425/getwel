package com.example.arpit.getwel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class list extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    int f=0;
   int total_price=0;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle mToggle;
    private RecyclerView mrecycle;
    private ExampleAdaptor madap;
    private RecyclerView.LayoutManager mlayout;
    ArrayList<exampleitem> exampleitems;
    ArrayList<String> iitems=new ArrayList<>();
    Map <String,String> quant=new HashMap<>();
    TextView textView;
    SharedPreferences sharedpreferences;
    android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        drawer=(DrawerLayout)findViewById( R.id.drawer );
        mToggle=new ActionBarDrawerToggle( this,drawer,R.string.open,R.string.close );
        drawer.addDrawerListener( mToggle );
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        NavigationView navigationView=(NavigationView)findViewById(R.id.drawerLayout);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager=getSupportFragmentManager();

        addItems();
        buildRecycle();
        sharedpreferences = getSharedPreferences("My_pref", Context.MODE_PRIVATE);
        textView=(TextView) findViewById(R.id.price);

    }
    public void addItems()
    {
        exampleitems=new ArrayList<>();
        exampleitems.add(new exampleitem(R.drawable.abc50,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"ABC","50gm","220","0"));
        exampleitems.add(new exampleitem(R.drawable.abc50,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"ABC","200gm","675","0"));
        exampleitems.add(new exampleitem(R.drawable.aquatone,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Aqua Tone","1 Lit","320","0"));
        exampleitems.add(new exampleitem(R.drawable.aquatone,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Aqua Tone","5 Lit","1265","0"));
        exampleitems.add(new exampleitem(R.drawable.beachwel1,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Beachwel","100ml","135","0"));
        exampleitems.add(new exampleitem(R.drawable.beachwel1,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Beachwel","500ml","402","0"));
        exampleitems.add(new exampleitem(R.drawable.beachwel1,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Beachwel","1 Lit","750","0"));
        exampleitems.add(new exampleitem(R.drawable.beachwel1,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Beachwel","5 Lit","3450","0"));
        exampleitems.add(new exampleitem(R.drawable.beachwel1,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Beachwel","25 Lit","15525","0"));
        exampleitems.add(new exampleitem(R.drawable.bevet1,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Bevet","1 Lit","153","0"));
        exampleitems.add(new exampleitem(R.drawable.bevet1,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Bevet","5 Lit","515","0"));
        exampleitems.add(new exampleitem(R.drawable.bevet1,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Bevet","25 Lit","2450","0"));
        exampleitems.add(new exampleitem(R.drawable.calcivet1,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Calcivet","1 Lit","100","0"));
        exampleitems.add(new exampleitem(R.drawable.calcivet1,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Calcivet","5 Lit","380","0"));
        exampleitems.add(new exampleitem(R.drawable.calcivet1,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Calcivet","10 Lit","700","0"));
        exampleitems.add(new exampleitem(R.drawable.calcivetgold10,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Calcivet Gold","1 Lit","125","0"));
        exampleitems.add(new exampleitem(R.drawable.calcivetgold10,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Calcivet Gold","5 Lit","510","0"));
        exampleitems.add(new exampleitem(R.drawable.calcivetgold10,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Calcivet Gold","10 Lit","842","0"));
        exampleitems.add(new exampleitem(R.drawable.calcivetpgold,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Calcivet-P Gold","1 Lit","140","0"));
        exampleitems.add(new exampleitem(R.drawable.calcivetpgold,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Calcivet-P Gold","5 Lit","420","0"));
        exampleitems.add(new exampleitem(R.drawable.calcivetp5,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Calcivet-P ","1 Lit","115","0"));
        exampleitems.add(new exampleitem(R.drawable.calcivetp5,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Calcivet-P ","5 Lit","370","0"));
        exampleitems.add(new exampleitem(R.drawable.cipweltz200g,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Cipwel-TZ","200 gm","220","0"));
        exampleitems.add(new exampleitem(R.drawable.cipweltz200g,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Cipwel-TZ","500 gm","515","0"));
        exampleitems.add(new exampleitem(R.drawable.coughcure1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Cough cure","1 Lit","320","0"));
        exampleitems.add(new exampleitem(R.drawable.coughcure1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Cough cure","5 Lit","1265","0"));
        exampleitems.add(new exampleitem(R.drawable.electrowel1kg,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Electrowel","200 gm","45","0"));
        exampleitems.add(new exampleitem(R.drawable.electrowel1kg,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Electrowel","1 Kg","165","0"));
        exampleitems.add(new exampleitem(R.drawable.electrowel1kg,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Electrowel","5 Kg","825","0"));
        exampleitems.add(new exampleitem(R.drawable.esevet1kg,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"ESevet","200gm","160","0"));
        exampleitems.add(new exampleitem(R.drawable.esevet1kg,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"ESevet","1 Kg","640","0"));
        exampleitems.add(new exampleitem(R.drawable.esevet1kg,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"ESevet","500ml","370","0"));
        exampleitems.add(new exampleitem(R.drawable.esevet1kg,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"ESevet","1 Lit","715","0"));
        exampleitems.add(new exampleitem(R.drawable.esevet1kg,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"ESevet","5 Lit","3000","0"));
        exampleitems.add(new exampleitem(R.drawable.getmin1kg,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Getmin Chelated","1 kg","120","0"));
        exampleitems.add(new exampleitem(R.drawable.getmin1kg,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Getmin Chelated","5 kg","525","0"));
        exampleitems.add(new exampleitem(R.drawable.getzole1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Getzole","30 ml","24","0"));
        exampleitems.add(new exampleitem(R.drawable.getzole1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Getzole","90 ml","48","0"));
        exampleitems.add(new exampleitem(R.drawable.getzole1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Getzole","1 Lit","255","0"));
        exampleitems.add(new exampleitem(R.drawable.grownup505lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Grown Up","1 Lit","280","0"));
        exampleitems.add(new exampleitem(R.drawable.grownup505lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Grown Up","5 Lit","1130","0"));
        exampleitems.add(new exampleitem(R.drawable.livvet1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Liv vet","1 Lit","160","0"));
        exampleitems.add(new exampleitem(R.drawable.livvet1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Liv vet","5 Lit","560","0"));
        exampleitems.add(new exampleitem(R.drawable.livvet1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Liv vet","25 Lit","2550","0"));
        exampleitems.add(new exampleitem(R.drawable.livvetstrong,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Liv vet strong","1 Lit","300","0"));
        exampleitems.add(new exampleitem(R.drawable.livvetstrong,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Liv vet strong","5 Lit","1180","0"));
        exampleitems.add(new exampleitem(R.drawable.livvetstrong,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Liv vet strong","25 Lit","5300","0"));
        exampleitems.add(new exampleitem(R.drawable.nefrovet1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Nefrovet","1 Lit","225","0"));
        exampleitems.add(new exampleitem(R.drawable.nefrovet1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Nefrovet","5 Lit","980","0"));
        exampleitems.add(new exampleitem(R.drawable.nefrovet1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Nefrovet","25 Lit","4500","0"));
        exampleitems.add(new exampleitem(R.drawable.nefrovetds1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Nefrovet Ds","1 Lit","280","0"));
        exampleitems.add(new exampleitem(R.drawable.nefrovetds1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Nefrovet Ds","5 Lit","1130","0"));
        exampleitems.add(new exampleitem(R.drawable.nefrovetds1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Nefrovet Ds","30 Lit","5750","0"));
        exampleitems.add(new exampleitem(R.drawable.rap1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"RAP","100 ml","120","0"));
        exampleitems.add(new exampleitem(R.drawable.rap1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"RAP","500 ml","435","0"));
        exampleitems.add(new exampleitem(R.drawable.rap1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"RAP","1 Lit","795","0"));
        exampleitems.add(new exampleitem(R.drawable.rap1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"RAP","5 Lit","3685","0"));
               exampleitems.add(new exampleitem(R.drawable.toxivet1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Toxivet","500 ml","145","0"));
        exampleitems.add(new exampleitem(R.drawable.toxivet1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Toxivet","1 Lit","225","0"));
        exampleitems.add(new exampleitem(R.drawable.toxivet1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Toxivet","5 Lit","890","0"));
        exampleitems.add(new exampleitem(R.drawable.toxivet1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Toxivet","25 Lit","4125","0"));
        exampleitems.add(new exampleitem(R.drawable.utrovet1lit,R.drawable.ic_add_circle,R.drawable.ic_remove_circle,"Utrovet","1 Lit","179","0"));

    }
    public void addFrag(String s)
    {
        Bundle b1=new Bundle();
        Bundle b2=new Bundle();
        checkout f1=new checkout();
        android.support.v4.app.FragmentTransaction transaction=fragmentManager.beginTransaction();
        b1.putString("name",s);
        transaction.add(R.id.fragments,f1);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("product", iitems.toString());
        editor.putString("Quantity",quant.toString());
        editor.putString("price",Integer.toString(total_price));
        editor.commit();

        transaction.commit();
        f1.setArguments(b1);


    }
    public void update(String s)
    {
        Bundle b1=new Bundle();
        Bundle b2=new Bundle();
        checkout m1=new checkout();
        android.support.v4.app.FragmentTransaction transaction=fragmentManager.beginTransaction();
        b1.putString("name",s);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("product", iitems.toString());
        editor.putString("Quantity",quant.toString());
        editor.putString("price",Integer.toString(total_price));
        editor.commit();
        m1.setArguments(b1);
        transaction.replace(R.id.fragments,m1);

        transaction.commit();

    }
    public void removeFrag()
    {
        Bundle b2=new Bundle();
        checkout f2=(checkout)fragmentManager.findFragmentById(R.id.fragments);
        android.support.v4.app.FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.remove(f2);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("product", iitems.toString());
        editor.putString("Quantity",quant.toString());
        editor.putString("price",Integer.toString(total_price));

        editor.commit();

        transaction.commit();

    }
    public void buildRecycle()
    {
        mrecycle=findViewById(R.id.recycle);
        mrecycle.setHasFixedSize(true);
        mlayout=new LinearLayoutManager(this);
        madap=new ExampleAdaptor(exampleitems);
        mrecycle.setLayoutManager(mlayout);
        mrecycle.setAdapter(madap);
        madap.setOnItemClickListener(new ExampleAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {


                if (i == 0)
                    startActivity(new Intent(list.this, proDetail.class));
                else if (i == 1)
                    startActivity(new Intent(list.this, abc200.class));
                else if (i == 2)
                    startActivity(new Intent(list.this, aqua1.class));
                else if (i == 3)
                    startActivity(new Intent(list.this, aqua5.class));
                else if (i == 4)
                    startActivity(new Intent(list.this, beachwel.class));
                else if (i == 5)
                    startActivity(new Intent(list.this, beachwel500ml.class));
                else if (i == 6)
                    startActivity(new Intent(list.this, beachwel1lit.class));
                else if (i == 7)
                    startActivity(new Intent(list.this, beachwel5lit.class));
                else if (i == 8)
                    startActivity(new Intent(list.this, beachwel25lit.class));
                else if (i == 9)
                    startActivity(new Intent(list.this, bevet.class));
                else if (i == 10)
                    startActivity(new Intent(list.this, bevet5lit.class));
                else if (i == 11)
                    startActivity(new Intent(list.this, bevet25lit.class));
                else if (i == 12)
                    startActivity(new Intent(list.this, calcivet.class));
                else if (i == 13)
                    startActivity(new Intent(list.this, calcivet5lit.class));
                else if (i == 14)
                    startActivity(new Intent(list.this, calcivet10lit.class));
                else if (i == 15)
                    startActivity(new Intent(list.this, calcivetgold.class));
                else if (i == 16)
                    startActivity(new Intent(list.this, calcivetgold5lit.class));
                else if (i == 17)
                    startActivity(new Intent(list.this, calcivetgold10lit.class));
                else if (i == 18)
                    startActivity(new Intent(list.this, calcivetpgold.class));
                else if (i == 19)
                    startActivity(new Intent(list.this, calcivetpgold5lit.class));
                else if (i == 20)
                    startActivity(new Intent(list.this, calcivetp.class));
                else if (i == 21)
                    startActivity(new Intent(list.this, calcivetp5lit.class));
                else if (i == 22)
                    startActivity(new Intent(list.this, cipwel.class));
                else if (i == 23)
                    startActivity(new Intent(list.this, cipwel500gm.class));
                else if (i == 24)
                    startActivity(new Intent(list.this, coughcure.class));
                else if (i == 25)
                    startActivity(new Intent(list.this, coughcure5lit.class));
                else if (i == 26)
                    startActivity(new Intent(list.this, electrowel.class));
                else if (i == 27)
                    startActivity(new Intent(list.this, electrowel1kg.class));
                else if (i == 28)
                    startActivity(new Intent(list.this, electrowel5kg.class));
                else if (i == 29)
                    startActivity(new Intent(list.this, esevet.class));
                else if (i == 30)
                    startActivity(new Intent(list.this, esevet1kg.class));
                else if (i == 31)
                    startActivity(new Intent(list.this, esevet500ml.class));
                else if (i == 32)
                    startActivity(new Intent(list.this, esevet1lit.class));
                else if (i == 33)
                    startActivity(new Intent(list.this, esevet5lit.class));
                else if (i == 34)
                    startActivity(new Intent(list.this, getmin.class));
                else if (i == 35)
                    startActivity(new Intent(list.this, getmin5kg.class));
                else if (i == 36)
                    startActivity(new Intent(list.this, getzole.class));
                else if (i == 37)
                    startActivity(new Intent(list.this, getzole90ml.class));
                else if (i == 38)
                    startActivity(new Intent(list.this, getzole1lit.class));
                else if (i == 39)
                    startActivity(new Intent(list.this, grownup.class));
                else if (i == 40)
                    startActivity(new Intent(list.this, grownup5lit.class));
                else if (i == 41)
                    startActivity(new Intent(list.this, livvet.class));
                else if (i == 42)
                    startActivity(new Intent(list.this, livvet5lit.class));
                else if (i == 43)
                    startActivity(new Intent(list.this, livvet25lit.class));
                else if (i == 44)
                    startActivity(new Intent(list.this, livvetstrong.class));
                else if (i == 45)
                    startActivity(new Intent(list.this, livvetstrong5lit.class));
                else if (i == 46)
                    startActivity(new Intent(list.this, livvetstrong25lit.class));

                else if (i == 47)
                    startActivity(new Intent(list.this, nefrovet.class));
                else if (i == 48)
                    startActivity(new Intent(list.this, nefrovet5lit.class));
                else if (i == 49)
                    startActivity(new Intent(list.this, nefrovet25lit.class));
                else if (i == 50)
                    startActivity(new Intent(list.this, nefrovetds.class));
                else if (i == 51)
                    startActivity(new Intent(list.this, nefrovetds5lit.class));
                else if (i == 52)
                    startActivity(new Intent(list.this, nefrovetds30lit.class));
                else if (i == 53)
                    startActivity(new Intent(list.this, rap.class));
                else if (i == 54)
                    startActivity(new Intent(list.this, rap500ml.class));
                else if (i == 55)
                    startActivity(new Intent(list.this, rap1lit.class));
                else if (i == 56)
                    startActivity(new Intent(list.this, rap5lit.class));
                else if (i == 57)
                    startActivity(new Intent(list.this, toxivet.class));
                else if (i == 58)
                    startActivity(new Intent(list.this, toxivet1lit.class));
                else if (i == 59)
                    startActivity(new Intent(list.this, toxivet5lit.class));
                               else if (i == 60)
                    startActivity(new Intent(list.this, toxivet25lit.class));
                else if (i == 61)
                    startActivity(new Intent(list.this, utrovet.class));

            }
            @Override
            public void onIncrease(int i,ArrayList<exampleitem> mlis) {
                exampleitems.get(i).change();
                exampleitem current=mlis.get(i);
                String s=current.getTxt3();
                String pname=current.getTxt1()+current.getTxt2();
                if(iitems.indexOf(pname)==-1) {
                    iitems.add(pname);
                    quant.put(pname,"1");


                }
                else {
                    String ss=quant.get(pname);
                    String qua=Integer.toString(Integer.parseInt(ss)+1);
                    quant.put(pname,qua);

                    iitems.add(pname);

                }total_price+=Integer.parseInt(s);
                if(f==0) {
                    addFrag(Integer.toString(total_price));
                    f++;
                }
                else
                    update(Integer.toString(total_price));
                madap.notifyItemChanged(i);
            }




            @Override
            public void onDecrease(int i,ArrayList<exampleitem> mlis) {
                exampleitem current = mlis.get(i);
                String s = current.getTxt3();
                String s1 = current.getTxt4();
                String pname=current.getTxt1()+current.getTxt2();

                exampleitems.get(i).changeDecrease();


                int l = Integer.parseInt(s);
                if (total_price >= l&&(!s1.equals("0"))) {
                    if(iitems.indexOf(pname)!=-1)
                    {
                        iitems.remove(pname);
                        if(iitems.indexOf(pname)==-1) {
                            quant.remove(pname);

                        }
                            else {
                            String ss=quant.get(pname);
                            String qua=Integer.toString(Integer.parseInt(ss)-1);
                            quant.put(pname,qua);

                        }

                    }


                    total_price -= l;
                    if (total_price != 0) {
                        update(Integer.toString(total_price));
                        madap.notifyItemChanged(i);

                    } else if (total_price == 0) {
                        removeFrag();
                        madap.notifyItemChanged(i);
                    }

                }
            }

        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
         if(mToggle.onOptionsItemSelected( item ))
        {
            return true;
        }
        return super.onOptionsItemSelected( item );
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.Products) {
            drawer.closeDrawers();
            startActivity(new Intent(getApplicationContext(), list.class));

        }     else if(id==R.id.home) {
            drawer.closeDrawers();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        else if(id==R.id.Findus) {
            drawer.closeDrawers();
            startActivity(new Intent(getApplicationContext(), MapsActivity.class));
        }
        else if(id==R.id.Contactus) {
            drawer.closeDrawers();
            startActivity(new Intent(getApplicationContext(), contact.class));
        }
        else if(id==R.id.about) {
            drawer.closeDrawers();
            startActivity(new Intent(getApplicationContext(), about.class));
        }
        else if(id==R.id.Close)
            drawer.closeDrawers();
        else if(id==R.id.exit)
            System.exit(0);
        return false;

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.dot,menu);
        return true;
    }
}
