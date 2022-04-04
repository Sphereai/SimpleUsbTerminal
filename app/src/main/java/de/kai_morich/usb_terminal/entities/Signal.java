package de.kai_morich.usb_terminal.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(nameInDb = "signals")
public class Signal {

    @Id(autoincrement = true)
    @Property(nameInDb = "id")
    private Long id;

    private long trialDataId;

    @ToOne(joinProperty = "trialDataId")
    private TrialData trialData;

    @NotNull
    @Property(nameInDb = "type")
    private String type;

    @NotNull
    @Property(nameInDb = "key")
    private String key;

    @NotNull
    @Property(nameInDb = "value")
    private String value;

    @NotNull
    @Property(nameInDb = "units")
    private String units;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 51506229)
    private transient SignalDao myDao;

    @Generated(hash = 2124423585)
    public Signal(Long id, long trialDataId, @NotNull String type,
            @NotNull String key, @NotNull String value, @NotNull String units) {
        this.id = id;
        this.trialDataId = trialDataId;
        this.type = type;
        this.key = key;
        this.value = value;
        this.units = units;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnits() {
        return this.units;
    }

    public void setUnits(String units) {
        this.units = units;
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
