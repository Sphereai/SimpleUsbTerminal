package de.kai_morich.usb_terminal.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

@Entity(nameInDb = "signals")
public class Signal {
    @Id(autoincrement = true)
    @Property(nameInDb = "id")
    private Long id;

    @Property(nameInDb = "trial_data_id")
    private long trialDataId;

    @ToOne(joinProperty = "trialDataId")
    private TrialData trialData;

    @Property(nameInDb = "loop_time")
    private Integer loopTime;

    @Property(nameInDb = "magneto_x")
    private Integer magnetoX;

    @Property(nameInDb = "accel_z")
    private Integer accelZ;

    @Property(nameInDb = "error")
    private Long error;

    @Property(nameInDb = "motor_error")
    private Long motorError;

    @Property(nameInDb = "axis_state")
    private Long axisState;

    @Property(nameInDb = "app_is_running")
    private Long appIsRunning;

    @Property(nameInDb = "roadfeel")
    private Long roadFeel;

    @Property(nameInDb = "heartbeat_host")
    private Long heartBeatHost;

    @Property(nameInDb = "vbus")
    private Double vbus;

    @Property(nameInDb = "iq_measured")
    private Double iqMeasured;

    @Property(nameInDb = "pedal_torque")
    private Double pedalTorque;

    @Property(nameInDb = "pedal_vel")
    private Double pedalVel;

    @Property(nameInDb = "pedal_pos")
    private Double pedalPos;

    @Property(nameInDb = "pedal_power")
    private Double pedalPower;

    @Property(nameInDb = "encoder_pos")
    private Double encoderPos;

    @Property(nameInDb = "encoder_vel")
    private Double encoderVel;

    @Property(nameInDb = "vel_cmd")
    private Double velCmd;

    @Property(nameInDb = "acc_cmd")
    private Double accCmd;

    @Property(nameInDb = "torque_cmd")
    private Double torqueCmd;

    @Property(nameInDb = "inertia")
    private Double inertia;

    @Property(nameInDb = "accel")
    private Double accel;

    @Property(nameInDb = "magneto")
    private Double magneto;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 51506229)
    private transient SignalDao myDao;

    @Generated(hash = 867877679)
    public Signal(Long id, long trialDataId, Integer loopTime, Integer magnetoX,
            Integer accelZ, Long error, Long motorError, Long axisState,
            Long appIsRunning, Long roadFeel, Long heartBeatHost, Double vbus,
            Double iqMeasured, Double pedalTorque, Double pedalVel, Double pedalPos,
            Double pedalPower, Double encoderPos, Double encoderVel, Double velCmd,
            Double accCmd, Double torqueCmd, Double inertia, Double accel,
            Double magneto) {
        this.id = id;
        this.trialDataId = trialDataId;
        this.loopTime = loopTime;
        this.magnetoX = magnetoX;
        this.accelZ = accelZ;
        this.error = error;
        this.motorError = motorError;
        this.axisState = axisState;
        this.appIsRunning = appIsRunning;
        this.roadFeel = roadFeel;
        this.heartBeatHost = heartBeatHost;
        this.vbus = vbus;
        this.iqMeasured = iqMeasured;
        this.pedalTorque = pedalTorque;
        this.pedalVel = pedalVel;
        this.pedalPos = pedalPos;
        this.pedalPower = pedalPower;
        this.encoderPos = encoderPos;
        this.encoderVel = encoderVel;
        this.velCmd = velCmd;
        this.accCmd = accCmd;
        this.torqueCmd = torqueCmd;
        this.inertia = inertia;
        this.accel = accel;
        this.magneto = magneto;
    }

    @Generated(hash = 783005292)
    public Signal() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTrialDataId() {
        return this.trialDataId;
    }

    public void setTrialDataId(long trialDataId) {
        this.trialDataId = trialDataId;
    }

    public Integer getLoopTime() {
        return this.loopTime;
    }

    public void setLoopTime(Integer loopTime) {
        this.loopTime = loopTime;
    }

    public Integer getMagnetoX() {
        return this.magnetoX;
    }

    public void setMagnetoX(Integer magnetoX) {
        this.magnetoX = magnetoX;
    }

    public Integer getAccelZ() {
        return this.accelZ;
    }

    public void setAccelZ(Integer accelZ) {
        this.accelZ = accelZ;
    }

    public Long getError() {
        return this.error;
    }

    public void setError(Long error) {
        this.error = error;
    }

    public Long getMotorError() {
        return this.motorError;
    }

    public void setMotorError(Long motorError) {
        this.motorError = motorError;
    }

    public Long getAxisState() {
        return this.axisState;
    }

    public void setAxisState(Long axisState) {
        this.axisState = axisState;
    }

    public Long getAppIsRunning() {
        return this.appIsRunning;
    }

    public void setAppIsRunning(Long appIsRunning) {
        this.appIsRunning = appIsRunning;
    }

    public Long getRoadFeel() {
        return this.roadFeel;
    }

    public void setRoadFeel(Long roadFeel) {
        this.roadFeel = roadFeel;
    }

    public Long getHeartBeatHost() {
        return this.heartBeatHost;
    }

    public void setHeartBeatHost(Long heartBeatHost) {
        this.heartBeatHost = heartBeatHost;
    }

    public Double getVbus() {
        return this.vbus;
    }

    public void setVbus(Double vbus) {
        this.vbus = vbus;
    }

    public Double getIqMeasured() {
        return this.iqMeasured;
    }

    public void setIqMeasured(Double iqMeasured) {
        this.iqMeasured = iqMeasured;
    }

    public Double getPedalTorque() {
        return this.pedalTorque;
    }

    public void setPedalTorque(Double pedalTorque) {
        this.pedalTorque = pedalTorque;
    }

    public Double getPedalVel() {
        return this.pedalVel;
    }

    public void setPedalVel(Double pedalVel) {
        this.pedalVel = pedalVel;
    }

    public Double getPedalPos() {
        return this.pedalPos;
    }

    public void setPedalPos(Double pedalPos) {
        this.pedalPos = pedalPos;
    }

    public Double getPedalPower() {
        return this.pedalPower;
    }

    public void setPedalPower(Double pedalPower) {
        this.pedalPower = pedalPower;
    }

    public Double getEncoderPos() {
        return this.encoderPos;
    }

    public void setEncoderPos(Double encoderPos) {
        this.encoderPos = encoderPos;
    }

    public Double getEncoderVel() {
        return this.encoderVel;
    }

    public void setEncoderVel(Double encoderVel) {
        this.encoderVel = encoderVel;
    }

    public Double getVelCmd() {
        return this.velCmd;
    }

    public void setVelCmd(Double velCmd) {
        this.velCmd = velCmd;
    }

    public Double getAccCmd() {
        return this.accCmd;
    }

    public void setAccCmd(Double accCmd) {
        this.accCmd = accCmd;
    }

    public Double getTorqueCmd() {
        return this.torqueCmd;
    }

    public void setTorqueCmd(Double torqueCmd) {
        this.torqueCmd = torqueCmd;
    }

    public Double getInertia() {
        return this.inertia;
    }

    public void setInertia(Double inertia) {
        this.inertia = inertia;
    }

    public Double getAccel() {
        return this.accel;
    }

    public void setAccel(Double accel) {
        this.accel = accel;
    }

    public Double getMagneto() {
        return this.magneto;
    }

    public void setMagneto(Double magneto) {
        this.magneto = magneto;
    }

    @Generated(hash = 678545556)
    private transient Long trialData__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 122119654)
    public TrialData getTrialData() {
        long __key = this.trialDataId;
        if (trialData__resolvedKey == null
                || !trialData__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TrialDataDao targetDao = daoSession.getTrialDataDao();
            TrialData trialDataNew = targetDao.load(__key);
            synchronized (this) {
                trialData = trialDataNew;
                trialData__resolvedKey = __key;
            }
        }
        return trialData;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1643873434)
    public void setTrialData(@NotNull TrialData trialData) {
        if (trialData == null) {
            throw new DaoException(
                    "To-one property 'trialDataId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.trialData = trialData;
            trialDataId = trialData.getId();
            trialData__resolvedKey = trialDataId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1271154172)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSignalDao() : null;
    }
}
