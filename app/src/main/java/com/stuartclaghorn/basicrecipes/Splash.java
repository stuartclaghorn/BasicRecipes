package com.stuartclaghorn.basicrecipes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import android.widget.ImageView;

/**
 * Created by stuart on 1/2/15.
 */
public class Splash extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        beginAnimation();
    }

    private void beginAnimation() {
        // Header animation
        TextView header = (TextView) findViewById(R.id.SplashHeader);
        Animation headerAnim = AnimationUtils.loadAnimation(this, R.anim.splash_text);
        header.startAnimation(headerAnim);
        
        // Image animation
        ImageView logo = (ImageView) findViewById(R.id.SplashImageCenter);
        Animation logoAnim = AnimationUtils.loadAnimation(this, R.anim.splash_image);
        logo.startAnimation(logoAnim);

        // Footer animation
        TextView footer = (TextView) findViewById(R.id.SplashFooter);
        Animation footerAnim = AnimationUtils.loadAnimation(this,R.anim.splash_text);
        footer.startAnimation(footerAnim);

        // Prepare for end of animation event
        logoAnim.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(Splash.this, MainMenu.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Clear animation. Start fresh on resume
        TextView header = (TextView) findViewById(R.id.SplashHeader);
        header.clearAnimation();

        TextView footer = (TextView) findViewById(R.id.SplashFooter);
        footer.clearAnimation();

        ImageView logo = (ImageView) findViewById(R.id.SplashImageCenter);
        logo.clearAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Start the animation from the beginning
        beginAnimation();
    }
}
