package com.theironyard;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelloGameMain extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    float x, y, xv, yv;

    static final float MAXVELOCITY = 100;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void render() {
        move();


        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, x, y);
        batch.end();
    }


    public float decelerate(float velocity ) {

      float deceleration = 0.97f; //closer to 1, slower the decel
        velocity *= deceleration;
        if (Math.abs(velocity) < 1) {
         velocity = 0;
        }
        return velocity;
    }

    void move() {
        //grabbing a keystroke
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            yv = MAXVELOCITY;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            yv = MAXVELOCITY * -1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            xv = MAXVELOCITY;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            xv = MAXVELOCITY * -1;
        }

        y += yv * Gdx.graphics.getDeltaTime();
        x += xv * Gdx.graphics.getDeltaTime();

        yv = decelerate(yv);
        xv = decelerate(xv);

    }


}
