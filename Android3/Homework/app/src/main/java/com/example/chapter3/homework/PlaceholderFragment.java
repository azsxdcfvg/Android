package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {
    private final String Tag = "PlaceholderFragment";
    private String[] stres = new String[]{"张三", "李四", "王二"};
    ListView friend_list;
    LottieAnimationView lottie;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(Tag, "onCreateView");
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(Tag, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                Log.d(Tag, "控制淡入淡出");
                View view= getView();



                lottie = view.findViewById(R.id.animation_view);
                friend_list = view.findViewById(R.id.friend_list);
                friend_list.setAdapter(new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, stres));
                ObjectAnimator animator3_1 = ObjectAnimator.ofFloat(friend_list, "alpha", 0, 1);
                ObjectAnimator animator3_2 = ObjectAnimator.ofFloat(lottie, "alpha", 1, 0);
                animator3_2.setDuration(2000);
                view.postInvalidateDelayed(1000);
                animator3_1.setDuration(2000);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator3_1, animator3_2);
                animatorSet.start();
            }
        }, 5000);
    }
}
