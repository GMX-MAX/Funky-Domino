/*
 *   This file is part of Funky Domino.
 *
 *   Funky Domino is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   Funky Domino is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with Funky Domino.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.gmxteam.funkydomino.activities;

// Importation de l'api d'android.
import android.app.Activity;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

// Importations pour le moteur de collisions
import org.jbox2d.collision.AABB;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

// Importations pour le moteur de rendu
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;

/**
 * Classe abstraite permettant une implémentation efficace d'un interface JBox2D. 
 * @author Guillaume Poirier-Morency
 */
public abstract class JBox2DActivity extends Activity implements GLSurfaceView.Renderer {

    /**
     * On dessine sur une surface OpenGL ES 2.0.
     */
    private GLSurfaceView glDrawingArea;
    ////////////////////////////////////////////////////////////////////////////
    // Variables pour le moteur de collisions
    private int targetFPS = 40;
    private int timeStep = (1000 / targetFPS);
    private int iterations = 5;
    private Body[] bodies;
    private int count = 0;
    private AABB worldAABB;
    protected World world;
    private Handler mHandler;
    private Runnable update = new Runnable() {

        public void run() {
            update();
            mHandler.postDelayed(update, (long) (timeStep * 1000));
        }
    };
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Initialisation du rendu 2D.
     */
    protected void create() {

        // On crée la surface de dessin et on ajoute son handler
        glDrawingArea = new GLSurfaceView(this);
        glDrawingArea.setRenderer(this);
        // On configure le moteur de physique

        worldAABB = new AABB();
        worldAABB.lowerBound.set(new Vec2((float) -100.0, (float) -100.0));
        worldAABB.upperBound.set(new Vec2((float) 100.0, (float) 100.0));

        world = new World(worldAABB, new Vec2(0.0f, -9.8f), false);



        mHandler = new Handler();
        mHandler.post(update);


        // On cache le menu
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // On mets l'application en plein écran
        final Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // On définit la surface OpenGL comme surface de dessin
        setContentView(glDrawingArea);
    }

    /**
     * Méthode appelée pour mettre à jour le rendu graphique et le moteur de physique.
     */
    private void update() {
        // Update Physics World  

        Log.v("funky-domino physic engine", "Updating...");



        world.step(timeStep, iterations);

        //Print info of latest body  
        Body b = this.world.getBodyList();
        do {
            Vec2 position = b.getPosition();
            float angle = b.getAngle();

            Log.v("funky-domino physic engine", "Pos: (" + position.x + ", " + position.y + "), Angle: " + angle);




        } while ((b = b.getNext()) != null);



    }

    ////////////////////////////////////////////////////////////////////////////
    // Contrôleurs
    @Override
    protected void onPause() {
        super.onPause();
        glDrawingArea.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        glDrawingArea.onResume();
    }

    ////////////////////////////////////////////////////////////////////////////
    // Handler pour le rendu 2D (se fait automatiquement)
    /**
     * Méthode appelée quand la surface est créée.
     * @param gl
     * @param config 
     */
    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
    }

    /**
     * Méthode appelée quand la surface change.
     * @param gl
     * @param w
     * @param h 
     */
    public void onSurfaceChanged(GL10 unused, int w, int h) {
        GLES20.glViewport(0, 0, w, h);
    }

    /**
     * Méthode appelée quand la surface est dessinée.
     * @param gl 
     */
    public void onDrawFrame(GL10 unused) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

    }
    ////////////////////////////////////////////////////////////////////////////
}
