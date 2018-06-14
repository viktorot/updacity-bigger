package io.viktorot.ui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class JokeActivity extends AppCompatActivity {

    private static final String ARG_JOKE = "arg_joke";

    private String joke;

    public static Intent getStartIntent(@NonNull Context context, @NonNull String joke) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(ARG_JOKE, joke);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Bundle args;
        if (savedInstanceState != null) {
            args = savedInstanceState;
        } else {
            args = getIntent().getExtras();
        }

        joke = getJoke(args);

        TextView tvJoke = findViewById(R.id.joke);
        tvJoke.setText(joke);
    }

    @NonNull
    private String getJoke(@NonNull Bundle args) {
        Objects.requireNonNull(args);

        String joke = args.getString(ARG_JOKE);
        if (joke == null) {
            throw new IllegalArgumentException("joke cannot be null");
        }
        return joke;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(ARG_JOKE, joke);
        super.onSaveInstanceState(outState);
    }
}
