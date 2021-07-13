package special;

import elements.*;
import geometries.*;
import org.junit.jupiter.api.Test;
import primitives.*;
import renderer.*;
import scene.Scene;

/**
 * Testing general scene
 */
class generalTest {
    private final Scene scene = new Scene("Test general scene");
    private final Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
            .setViewPlaneSize(400, 400).setDistance(1000);

    @Test
    public void generalTest1() {
        scene.geometries.add( //
                new Sphere(60, new Point3D(0, 0, -100)) //
                        .setEmission(new Color(java.awt.Color.RED)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(30)), //
                new Sphere(60, new Point3D(100, 60, 100)) //
                        .setEmission(new Color(java.awt.Color.RED)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(30)), //
                new Triangle(new Point3D(90, -100, 0), new Point3D(90, -30, 0), new Point3D(60, -70, -4)) //
                        .setEmission(new Color(java.awt.Color.RED)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(30)),
                new Sphere(10, new Point3D(-100, -100, 0)) //
                        .setEmission(new Color(java.awt.Color.white)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(10))
        );
//        scene.lights.add( //
//                new SpotLight(new Color(400, 240, 0), new Point3D(-100, -100, 200), new Vector(1, 1, -3)) //
//                        .setKl(1E-5).setKq(1.5E-7));
        scene.lights.add(new PointLight(new Color(java.awt.Color.white), new Point3D(-100, -100, 0)).setKl(1E-5).setKq(1.5E-7));
        scene.lights.add(new PointLight(new Color(java.awt.Color.white), new Point3D(-100, 100, 0)).setKl(1E-5).setKq(1.5E-7));
        Render render = new Render(). //
                setImageWriter(new ImageWriter("generalTest1", 1400, 1400)) //
                .setCamera(camera) //
                .setRayTracer(new BasicRayTracer(scene))
                .setMultithreading(4);
        render.renderImage();
        render.writeToImage();
    }


    @Test
    public void generalTest2() {
        Scene scene2 = new Scene("Test general scene2");
        Camera camera2 = new Camera(new Point3D(0, 0, 500), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
                .setViewPlaneSize(2000, 2000).setDistance(500);

        Color c = new Color(100, 0, 100);

        scene2.geometries.add( //
                new Plane(new Point3D(0, 0, -1000), new Vector(0, 0, -1)),
                new Sphere(150, new Point3D(0, 0, -600)) //
                        .setEmission(new Color(java.awt.Color.RED)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(20)),
                new Sphere(300, new Point3D(0, 0, -600))
                        .setEmission(new Color(200, 50, 50)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(20)),
                new Triangle(new Point3D(-700, -400, -600), new Point3D(700, -400, -600), new Point3D(700, -650, -600)) //
                        .setEmission(new Color(java.awt.Color.RED)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(20)),
                new Triangle(new Point3D(0, 375, -605), new Point3D(700, 0, -605), new Point3D(0, -375, -605)) //
                        .setEmission(new Color(250, 0, 50)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(20)),
                new Triangle(new Point3D(-300, -650, -600), new Point3D(300, -650, -600), new Point3D(600, -2000, -600)) //
                        .setEmission(new Color(100, 0, 100)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(20)),
                new Triangle( new Point3D(800, 500, -600),
                        new Point3D(200, -400, -600),
                        new Point3D(700, -400, -600)) //
                        .setEmission(new Color(100, 0, 100)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(20)),
                new Triangle( new Point3D(750, 1500, -800),
                        new Point3D(2750, -2000, -800),
                        new Point3D(-1250, -2000, -800)) //
                        .setEmission(new Color(100, 0, 0)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(20)),
                new Triangle(new Point3D(-800, 500, -600),
                        new Point3D(-200, -400, -600),
                        new Point3D(-700, -400, -600))
                        .setEmission(new Color(100, 0, 100)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(20)),
                new Triangle(new Point3D(-750, 1500, -700),
                        new Point3D(-2750, -2000, -700),
                        new Point3D(1250, -2000, -700))
                        .setEmission(new Color(150, 0, 0)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(20)));

        //light
        scene.lights.add(new DirectionalLight(new Color(0, 50, 0), new Vector(0, 1, -0.5)));
        scene.lights.add(new DirectionalLight(new Color(50, 0, 0), new Vector(-1, 1, -0.5)));
        scene.lights.add(new DirectionalLight(new Color(50, 50, 0), new Vector(1, 1, -0.5)));
        scene.lights.add(new DirectionalLight(new Color(50, 0, 50), new Vector(0, 1, 0)));

        Render render = new Render(). //
                setImageWriter(new ImageWriter("generalTest2", 1000, 1000)) //
                .setCamera(camera2) //
                .setRayTracer(new BasicRayTracer(scene2))
                .setMultithreading(4);
        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void generalTest3() {
        Scene scene3 = new Scene("Test general scene");
        Camera camera3 = new Camera(new Point3D(0, 0, 1000), new Vector(0.14, 0, -1), new Vector(0, 1, 0))  //
                .setViewPlaneSize(400, 400).setDistance(1000);
        scene3.geometries.add( //
                new Sphere(60, new Point3D(0, 0, -100)) //
                        .setEmission(new Color(java.awt.Color.RED)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(30)), //
                new Sphere(60, new Point3D(100, 60, 100)) //
                        .setEmission(new Color(java.awt.Color.RED)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(30)), //
                new Triangle(new Point3D(90, -100, 0), new Point3D(90, -30, 0), new Point3D(60, -70, -4)) //
                        .setEmission(new Color(java.awt.Color.RED)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(30)),
                new Sphere(10, new Point3D(-100, -100, 0)) //
                        .setEmission(new Color(java.awt.Color.white)) //
                        .setMaterial(new Material().setKd(0.5).setkS(0.5).setShininess(10))
        );
//        scene.lights.add( //
//                new SpotLight(new Color(400, 240, 0), new Point3D(-100, -100, 200), new Vector(1, 1, -3)) //
//                        .setKl(1E-5).setKq(1.5E-7));
        scene3.lights.add(new PointLight(new Color(java.awt.Color.white), new Point3D(-100, -100, 0)).setKl(1E-5).setKq(1.5E-7));
        scene3.lights.add(new PointLight(new Color(java.awt.Color.white), new Point3D(-100, 100, 0)).setKl(1E-5).setKq(1.5E-7));
        Render render = new Render(). //
                setImageWriter(new ImageWriter("generalTest3", 1400, 1400)) //
                .setCamera(camera3) //
                .setRayTracer(new BasicRayTracer(scene3))
                .setMultithreading(4);
        render.renderImageSuperSampling(4);
        render.writeToImage();
    }//
}