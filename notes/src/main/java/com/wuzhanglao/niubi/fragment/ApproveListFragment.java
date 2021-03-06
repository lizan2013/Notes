package com.wuzhanglao.niubi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wuzhanglao.niubi.R;
import com.wuzhanglao.niubi.mvp.presenter.ApproveListFragmentPresenter;
import com.wuzhanglao.niubi.mvp.view.ApproveListFragmentView;
import com.wuzhanglao.niubi.utils.AppUtils;
import com.wuzhanglao.niubi.widget.ApproveListLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuming on 2016/10/23.
 */

public class ApproveListFragment extends BaseMvpFragment<ApproveListFragmentView, ApproveListFragmentPresenter>
        implements ApproveListFragmentView, View.OnClickListener {

    private ApproveListLayout approveListLayout;
    private List<Integer> approveList;

    @Override
    public ApproveListFragmentPresenter initPresenter() {
        return new ApproveListFragmentPresenter();
    }

    @Override
    public int setResId() {
        return R.layout.fragment_approve_list;
    }

    @Override
    public void initView(View view, @Nullable Bundle savedInstanceState) {
        initData();
        approveListLayout = (ApproveListLayout) view.findViewById(R.id.approve_list_layout);
        approveListLayout.updateApproveList(approveList);

        view.findViewById(R.id.apprive_list_mv1_approve).setOnClickListener(this);
        view.findViewById(R.id.apprive_list_mv1_unapprove).setOnClickListener(this);
        view.findViewById(R.id.apprive_list_mv2_approve).setOnClickListener(this);
        view.findViewById(R.id.apprive_list_mv2_unapprove).setOnClickListener(this);
        view.findViewById(R.id.apprive_list_mv3_approve).setOnClickListener(this);
        view.findViewById(R.id.apprive_list_mv3_unapprove).setOnClickListener(this);
    }

    private void initData() {
        approveList = new ArrayList<>();
        approveList.add(R.drawable.avatar);
        approveList.add(R.drawable.avatar);
        approveList.add(R.drawable.avatar);
        approveList.add(R.drawable.avatar);
        approveList.add(R.drawable.avatar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.apprive_list_mv1_approve:
                if (!approveList.contains(R.drawable.img1)) {
                    approveList.add(0, R.drawable.img1);
                } else {
                    AppUtils.showToast("该用户已经点过赞了");
                }
                break;
            case R.id.apprive_list_mv1_unapprove:
                approveList.remove(new Integer(R.drawable.img1));
                break;
            case R.id.apprive_list_mv2_approve:
                if (!approveList.contains(R.drawable.img2)) {
                    approveList.add(0, R.drawable.img2);
                } else {
                    AppUtils.showToast("该用户已经点过赞了");
                }
                break;
            case R.id.apprive_list_mv2_unapprove:
                approveList.remove(new Integer(R.drawable.img2));
                break;
            case R.id.apprive_list_mv3_approve:
                if (!approveList.contains(R.drawable.img3)) {
                    approveList.add(0, R.drawable.img3);
                } else {
                    AppUtils.showToast("该用户已经点过赞了");
                }
                break;
            case R.id.apprive_list_mv3_unapprove:
                approveList.remove(new Integer(R.drawable.img3));
                break;
        }
        approveListLayout.updateApproveList(approveList);
    }
}
