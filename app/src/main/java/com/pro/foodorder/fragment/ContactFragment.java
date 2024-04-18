package com.pro.foodorder.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import com.pro.foodorder.R;
import com.pro.foodorder.activity.MainActivity;
import com.pro.foodorder.adapter.ContactAdapter;
import com.pro.foodorder.constant.AboutUsConfig;
import com.pro.foodorder.constant.GlobalFunction;
import com.pro.foodorder.databinding.FragmentContactBinding;
import com.pro.foodorder.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends BaseFragment {

    private FragmentContactBinding mFragmentContactBinding;
    private ContactAdapter mContactAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentContactBinding = FragmentContactBinding.inflate(inflater, container, false);

        initUi();
        initListener();

        return mFragmentContactBinding.getRoot();
    }

    private void initUi() {
        mFragmentContactBinding.tvAboutUsTitle.setText(AboutUsConfig.ABOUT_US_TITLE);
        mFragmentContactBinding.tvAboutUsContent.setText(AboutUsConfig.ABOUT_US_CONTENT);
        mFragmentContactBinding.tvAboutUsWebsite.setText(AboutUsConfig.ABOUT_US_WEBSITE_TITLE);

        mContactAdapter = new ContactAdapter(getActivity(), getListContact(),
                () -> GlobalFunction.callPhoneNumber(getActivity()));
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        mFragmentContactBinding.rcvData.setNestedScrollingEnabled(false);
        mFragmentContactBinding.rcvData.setFocusable(false);
        mFragmentContactBinding.rcvData.setLayoutManager(layoutManager);
        mFragmentContactBinding.rcvData.setAdapter(mContactAdapter);
    }

    private void initListener() {
        mFragmentContactBinding.layoutWebsite.setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse(AboutUsConfig.WEBSITE))));
    }

    public List<Contact> getListContact() {
        List<Contact> contactArrayList = new ArrayList<>();
        contactArrayList.add(new Contact(Contact.FACEBOOK, R.drawable.ic_facebook));
        contactArrayList.add(new Contact(Contact.HOTLINE, R.drawable.ic_hotline));
        contactArrayList.add(new Contact(Contact.GMAIL, R.drawable.ic_gmail));
        contactArrayList.add(new Contact(Contact.YOUTUBE, R.drawable.ic_youtube));
        contactArrayList.add(new Contact(Contact.ZALO, R.drawable.ic_zalo));

        return contactArrayList;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mContactAdapter.release();
    }

    @Override
    protected void initToolbar() {
        if (getActivity() != null) {
            ((MainActivity) getActivity()).setToolBar(false, getString(R.string.contact));
        }
    }
}
