package com.example.shiyuankeji.utils;

import android.app.Activity;
import android.os.CountDownTimer;
import android.view.View;

import java.util.Random;

import me.samlss.bloom.Bloom;
import me.samlss.bloom.effector.BloomEffector;
import me.samlss.bloom.particle.BloomParticle;
import me.samlss.bloom.shape.ParticleCircleShape;
import me.samlss.bloom.shape.ParticleRectShape;
import me.samlss.bloom.shape.ParticleShape;
import me.samlss.bloom.shape.ParticleStarShape;
import me.samlss.bloom.shape.distributor.ParticleShapeDistributor;

/**
 * Demo class
 *
 * @author zhanghui
 * @date 2020/8/24
 */
public class PBombUtil {
/**
 * explain ：使用本工具类必须导入bloom库,如下：
 *      dependencies {
 *          implementation 'me.samlss:bloom:1.0.0'
 *     }
 *
 * */


    /**
     * 默认 圆形特效(建议使用)
     */
    public static void starics(Activity activity, float radius, long duration, View view) {
        Bloom.with(activity)
                .setParticleRadius(radius)
                .setEffector(new BloomEffector.Builder()
                        .setDuration(duration)
                        .setAnchor(view.getWidth() / 2, view.getHeight() / 2)
                        .build())
                .boom(view);
    }

    /**
     * 在该库中，支持三种粒子形状
     */

    public static void starics1(Activity activity, float radius, View view, ParticleShapeDistributor particleShapeDistributor) {
        Bloom.with(activity)
                .setParticleRadius(radius)
                .setShapeDistributor(particleShapeDistributor)
                //圆形特效
//                .setShapeDistributor(new CircleShapeDistributor())
                //矩形特效
                //or setShapeDistributor(new RectShapeDistributor())
                //星型特效
                //or setShapeDistributor(new StarShapeDistributor())
                .boom(view);
    }


    /**
     * 随机特效
     */
    public static void starics2(Activity activity, float radius, View view) {
        Bloom.with(activity)
                .setParticleRadius(radius)
                .setShapeDistributor(new ParticleShapeDistributor() {
                    @Override
                    public ParticleShape getShape(BloomParticle particle) {
                        Random random = new Random();
                        switch (random.nextInt(3)) {
                            case 0:
                                return new ParticleCircleShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
                            case 1:
                                return new ParticleRectShape(2, 2, particle.getInitialX(), particle.getInitialY(), particle.getRadius());//设置圆角效果
                            case 2:
                                return new ParticleStarShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
                        }
                        return new ParticleCircleShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
                    }
                }).boom(view);

    }

    /**
     * 组合起来(强力推存)
     */
    public static void starics3(Activity activity, float radius, long duration, View view) {
//            Bloom.with(LoginActivity.this)
//                        .setParticleRadius(5)
//                        .setShapeDistributor(new ParticleShapeDistributor() {
//                            @Override
//                            public ParticleShape getShape(BloomParticle particle) {
//                                switch (random.nextInt(3)){
//                                    case 0:
//                                        return new ParticleCircleShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
//                                    case 1:
//                                        return new ParticleRectShape(2, 2, particle.getInitialX(), particle.getInitialY(), particle.getRadius());//设置圆角效果
//                                    case 2:
//                                        return new ParticleStarShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
//                                }
//                                return new ParticleCircleShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
//                            }
//                        })
//                        .setEffector(new BloomEffector.Builder()
//                                .setDuration(800)
//                                .setAnchor(mScratchView.getWidth() / 2, mScratchView.getHeight() / 2)
//                                .build())
//                        .boom(view);

        Bloom.with(activity)
                .setParticleRadius(radius)
                .setShapeDistributor(new ParticleShapeDistributor() {
                    @Override
                    public ParticleShape getShape(BloomParticle particle) {
                        Random random = new Random();
                        switch (random.nextInt(3)) {
                            case 0:
                                return new ParticleCircleShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
                            case 1:
                                return new ParticleRectShape(2, 2, particle.getInitialX(), particle.getInitialY(), particle.getRadius());//设置圆角效果
                            case 2:
                                return new ParticleStarShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
                        }
                        return new ParticleCircleShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
                    }
                })
                .setEffector(new BloomEffector.Builder()
                        .setDuration(duration)
                        .setAnchor(view.getWidth() / 2, view.getHeight() / 2)
                        .build())
                .boom(view);
    }

    /**
     * 组合起来(强力推存 带跳转)
     */
    public static CountDownTimer starics4(Activity activity, float radius, long duration, View view, CountDownTimer countDownTimer) {
//            Bloom.with(LoginActivity.this)
//                        .setParticleRadius(5)
//                        .setShapeDistributor(new ParticleShapeDistributor() {
//                            @Override
//                            public ParticleShape getShape(BloomParticle particle) {
//                                switch (random.nextInt(3)){
//                                    case 0:
//                                        return new ParticleCircleShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
//                                    case 1:
//                                        return new ParticleRectShape(2, 2, particle.getInitialX(), particle.getInitialY(), particle.getRadius());//设置圆角效果
//                                    case 2:
//                                        return new ParticleStarShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
//                                }
//                                return new ParticleCircleShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
//                            }
//                        })
//                        .setEffector(new BloomEffector.Builder()
//                                .setDuration(800)
//                                .setAnchor(mScratchView.getWidth() / 2, mScratchView.getHeight() / 2)
//                                .build())
//                        .boom(view);

        Bloom.with(activity)
                .setParticleRadius(radius)
                .setShapeDistributor(new ParticleShapeDistributor() {
                    @Override
                    public ParticleShape getShape(BloomParticle particle) {
                        Random random = new Random();
                        switch (random.nextInt(3)) {
                            case 0:
                                return new ParticleCircleShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
                            case 1:
                                return new ParticleRectShape(2, 2, particle.getInitialX(), particle.getInitialY(), particle.getRadius());//设置圆角效果
                            case 2:
                                return new ParticleStarShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
                        }
                        return new ParticleCircleShape(particle.getInitialX(), particle.getInitialY(), particle.getRadius());
                    }
                })
                .setEffector(new BloomEffector.Builder()
                        .setDuration(duration)
                        .setAnchor(view.getWidth() / 2, view.getHeight() / 2)
                        .build())
                .boom(view);
        return countDownTimer.start();
    }
}
