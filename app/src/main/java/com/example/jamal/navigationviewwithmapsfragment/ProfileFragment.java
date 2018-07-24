package com.example.jamal.navigationviewwithmapsfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/**
 * Provides UI for the view with List.
 */
public class ProfileFragment extends Fragment {

    DrawerLayout profileLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        profileLayout= (DrawerLayout) inflater.inflate(
                R.layout.profile_layout, container, false);
        navigationView=(NavigationView)profileLayout.findViewById(R.id.navigationView);

        setHasOptionsMenu(true);
        return profileLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getActivity().setTitle("Profile");
        toggle = new ActionBarDrawerToggle((AppCompatActivity)getActivity(),profileLayout,R.string.open,R.string.close);
        profileLayout.addDrawerListener(toggle);
        toggle.syncState();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.home_nave :  changeFragmentPosition(0);
                        break;
                    case R.id.profile_nav :  changeFragmentPosition(1);
                        break;
                }
                return false;
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void changeFragmentPosition(int position) {
        Intent intent = new Intent("com.example.jamal.navigationviewwithmapsfragment.MainActivity");
        intent.putExtra("fragmentPosition", position);
        startActivity(intent);
    }

    public void showMessage(String message){
        Toast.makeText(getActivity().getBaseContext(),message,Toast.LENGTH_SHORT).show();
    }



}
