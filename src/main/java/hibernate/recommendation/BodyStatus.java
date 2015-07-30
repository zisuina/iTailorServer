package hibernate.recommendation;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by liker on 24/07/2015 0024.
 * Group iTailor.hunters.neu.edu.cn
 */

@Entity
@Table(name = "body_status")
public class BodyStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bodyStatusID;
    private Timestamp timestamp;
    private String skin = "undefine";
    private int height = 0;
    private int waistHeight = 0;
    private int crotchHeight = 0;
    private int bust = 0;
    private int waist = 0;
    private int hips = 0;
    private int armLength = 0;
    private int legLength = 0;
    private int crossShoulder = 0;
    private int calfGirth = 0;
    private int thighCircumference = 0;
    private float headBodyRatio = 0;
    private float bodyProportion = 0;
    private float footLength = 0;
    private int physicalAge = 0;
    private int heartRate = 0;
    private int wristGirth = 0;
    private int fatRatio = 0;
    private int mood = 0;

    public BodyStatus() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public int getBodyStatusID() {
        return bodyStatusID;
    }

    public void setBodyStatusID(int bodyStatusID) {
        this.bodyStatusID = bodyStatusID;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWaistHeight() {
        return waistHeight;
    }

    public void setWaistHeight(int waistHeight) {
        this.waistHeight = waistHeight;
    }

    public int getCrotchHeight() {
        return crotchHeight;
    }

    public void setCrotchHeight(int crotchHeight) {
        this.crotchHeight = crotchHeight;
    }

    public int getBust() {
        return bust;
    }

    public void setBust(int bust) {
        this.bust = bust;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getHips() {
        return hips;
    }

    public void setHips(int hips) {
        this.hips = hips;
    }

    public int getArmLength() {
        return armLength;
    }

    public void setArmLength(int armLength) {
        this.armLength = armLength;
    }

    public int getLegLength() {
        return legLength;
    }

    public void setLegLength(int legLength) {
        this.legLength = legLength;
    }

    public int getCrossShoulder() {
        return crossShoulder;
    }

    public void setCrossShoulder(int crossShoulder) {
        this.crossShoulder = crossShoulder;
    }

    public int getCalfGirth() {
        return calfGirth;
    }

    public void setCalfGirth(int calfGirth) {
        this.calfGirth = calfGirth;
    }

    public int getThighCircumference() {
        return thighCircumference;
    }

    public void setThighCircumference(int thighCircumference) {
        this.thighCircumference = thighCircumference;
    }

    public float getHeadBodyRatio() {
        return headBodyRatio;
    }

    public void setHeadBodyRatio(float headBodyRatio) {
        this.headBodyRatio = headBodyRatio;
    }

    public float getBodyProportion() {
        return bodyProportion;
    }

    public void setBodyProportion(float bodyProportion) {
        this.bodyProportion = bodyProportion;
    }

    public float getFootLength() {
        return footLength;
    }

    public void setFootLength(float footLength) {
        this.footLength = footLength;
    }

    public int getPhysicalAge() {
        return physicalAge;
    }

    public void setPhysicalAge(int physicalAge) {
        this.physicalAge = physicalAge;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getWristGirth() {
        return wristGirth;
    }

    public void setWristGirth(int wristGirth) {
        this.wristGirth = wristGirth;
    }

    public int getFatRatio() {
        return fatRatio;
    }

    public void setFatRatio(int fatRatio) {
        this.fatRatio = fatRatio;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }
}
