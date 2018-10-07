package yishengma.sino_tetris.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import yishengma.sino_tetris.R;

/**
 * Created by PirateHat on 18-10-7.
 */

public class TetrisDialogFragment extends DialogFragment {

    @BindView(R.id.imv_title)
    ImageView mImvTitle;
    @BindView(R.id.btn_operate)
    Button mBtnOperate;
    Unbinder unbinder;
    private String mButtonText;

    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(String s);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0x00000000));
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.fragment_dialog,container, false
        );

        unbinder = ButterKnife.bind(this, rootView);
        mBtnOperate.setText(mButtonText);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void setOperate(String s) {
        mButtonText = s;
    }

    @OnClick(R.id.btn_operate)
    public void onViewClicked() {
        if (mOnClickListener != null) {
            mOnClickListener.onClick((String) mBtnOperate.getText());
        }
    }
}
