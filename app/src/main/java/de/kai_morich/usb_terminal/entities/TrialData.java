package de.kai_morich.usb_terminal.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(nameInDb = "trial_data")
public class TrialData {
    @Id(autoincrement = true)
    @Property(nameInDb = "id")
    private Long id;

    private long trialId;

    @ToOne(joinProperty = "trialId")
    private Trial trial;

    @ToMany(referencedJoinProperty = "trialDataId")
    private List<SequenceHistory> sequenceHistories;

    @ToMany(referencedJoinProperty = "trialDataId")
    private List<Signal> signals;

    @NotNull
    @Property(nameInDb = "device_id")
    private int deviceId;

    @Property(nameInDb = "cadence")
    private Double cadence;

    @Property(nameInDb = "position")
    private Double position;

    @Property(nameInDb = "torque")
    private Double torque;

    @Property(nameInDb = "power")
    private Double power;

    @Property(nameInDb = "date")
    private Date date;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 463436282)
    private transient TrialDataDao myDao;

    @Generated(hash = 2035947855)
    public TrialData(Long id, long trialId, int deviceId, Double cadence,
            Double position, Double torque, Double power, Date date) {
        this.id = id;
        this.trialId = trialId;
        this.deviceId = deviceId;
        this.cadence = cadence;
        this.position = position;
        this.torque = torque;
        this.power = power;
        this.date = date;
    }

    @Generated(hash = 17878854)
    public TrialData() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTrialId() {
        return this.trialId;
    }

    public void setTrialId(long trialId) {
        this.trialId = trialId;
    }

    public int getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public Double getCadence() {
        return this.cadence;
    }

    public void setCadence(Double cadence) {
        this.cadence = cadence;
    }

    public Double getPosition() {
        return this.position;
    }

    public void setPosition(Double position) {
        this.position = position;
    }

    public Double getTorque() {
        return this.torque;
    }

    public void setTorque(Double torque) {
        this.torque = torque;
    }

    public Double getPower() {
        return this.power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Generated(hash = 1475249320)
    private transient Long trial__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 117836054)
    public Trial getTrial() {
        long __key = this.trialId;
        if (trial__resolvedKey == null || !trial__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TrialDao targetDao = daoSession.getTrialDao();
            Trial trialNew = targetDao.load(__key);
            synchronized (this) {
                trial = trialNew;
                trial__resolvedKey = __key;
            }
        }
        return trial;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 885665178)
    public void setTrial(@NotNull Trial trial) {
        if (trial == null) {
            throw new DaoException(
                    "To-one property 'trialId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.trial = trial;
            trialId = trial.getId();
            trial__resolvedKey = trialId;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1101730900)
    public List<SequenceHistory> getSequenceHistories() {
        if (sequenceHistories == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SequenceHistoryDao targetDao = daoSession.getSequenceHistoryDao();
            List<SequenceHistory> sequenceHistoriesNew = targetDao
                    ._queryTrialData_SequenceHistories(id);
            synchronized (this) {
                if (sequenceHistories == null) {
                    sequenceHistories = sequenceHistoriesNew;
                }
            }
        }
        return sequenceHistories;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1993471931)
    public synchronized void resetSequenceHistories() {
        sequenceHistories = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 556882717)
    public List<Signal> getSignals() {
        if (signals == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SignalDao targetDao = daoSession.getSignalDao();
            List<Signal> signalsNew = targetDao._queryTrialData_Signals(id);
            synchronized (this) {
                if (signals == null) {
                    signals = signalsNew;
                }
            }
        }
        return signals;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1483993965)
    public synchronized void resetSignals() {
        signals = null;
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
    @Generated(hash = 826987804)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTrialDataDao() : null;
    }
}
