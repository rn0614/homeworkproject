package com.example.homeworkproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeworkproject.CustomAdapter;
import com.example.homeworkproject.DBHelper;
import com.example.homeworkproject.MainActivity;
import com.example.homeworkproject.R;
import com.example.homeworkproject.databinding.FragmentHomeBinding;
import com.example.homeworkproject.TodoItem;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView mRv_todo;
    private ArrayList<TodoItem> mTodoItems;
    private DBHelper mDBHelper;
    private CustomAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding =FragmentHomeBinding.inflate(inflater,container, false);
        View root = binding.getRoot();


        mDBHelper = new DBHelper(root.getContext());
        mRv_todo=root.findViewById(R.id.rv_todo);
        LoadRecentDB();

        return root;
    }

    @Override
    public void onResume() {
        View root = binding.getRoot();
        LoadRecentDB();
        super.onResume();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void LoadRecentDB() {
        // 저장된 DB 가져오기
        mTodoItems = mDBHelper.getTodoList();
        mAdapter = new CustomAdapter(mTodoItems,this.getContext());
        mRv_todo.setHasFixedSize(true);
        mRv_todo.setAdapter(mAdapter);
    }
}