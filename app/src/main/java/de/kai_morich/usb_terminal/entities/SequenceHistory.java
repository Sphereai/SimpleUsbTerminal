package de.kai_morich.usb_terminal.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(nameInDb = "sequence_histories")
public class SequenceHistory {
    @Id(autoincrement = true)
    @Property(nameInDb = "id")
    private Long id;

    @Property(nameInDb = "trial_data_id")
    private long trialDataId;

    @ToOne(joinProperty = "trialDataId")
    private TrialData trialData;

    @Property(nameInDb = "name")
    private String name;

    @NotNull
    @Property(nameInDb = "date_creation")
    private Date date;

    @NotNull
    @Property(nameInDb = "mode")
    private int mode;

    @Property(nameInDb = "as_pedaling_dir")
    private boolean assistancePedalingDirection;

    @Property(nameInDb = "as_max_speed")
    private int assistanceMaxSpeed;

    @Property(nameInDb = "as_min_speed")
    private int assistanceMinSpeed;

    @Property(nameInDb = "as_variation_form")
    private boolean assistanceVariationForm;

    @Property(nameInDb = "as_variation_period")
    private int assistanceVariationPeriod;

    @Property(nameInDb = "res_max_resistance")
    private int resistanceMaxResistance;

    @Property(nameInDb = "res_min_resistance")
    private int resistanceMinResistance;

    @Property(nameInDb = "res_variation_form")
    private boolean resistanceVariationForm;

    @Property(nameInDb = "res_variation_period")
    private int resistanceVariationPeriod;

    @Property(nameInDb = "cycling_min_resistance")
    private int cyclingMinResistance;

    @Property(nameInDb = "cycling_max_resistance")
    private int cyclingMaxResistance;

    @Property(nameInDb = "cycling_min_angle")
    private int cyclingMinAngle;

    @Property(nameInDb = "cycling_max_angle")
    private int cyclingMaxAngle;

    @Property(nameInDb = "cycling_leg_applied")
    private boolean cyclingLegApplied;

    @Property(nameInDb = "cycling_repetition")
    private int cyclingRepetition;

    @Property(nameInDb = "cycling_variation_form")
    private boolean cyclingVariationForm;

    @Property(nameInDb = "cycling_variation_period")
    private int cyclingVariationPeriod;

    @Property(nameInDb = "sequence_time")
    private int sequenceTime;

    @Property(nameInDb = "road_feel")
    private int roadFeel;

    @Property(nameInDb = "record_sequence")
    private boolean recordSequence;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 893218992)
    private transient SequenceHistoryDao myDao;

    @Generated(hash = 1891948753)
    public SequenceHistory(Long id, long trialDataId, String name,
            @NotNull Date date, int mode, boolean assistancePedalingDirection,
            int assistanceMaxSpeed, int assistanceMinSpeed,
            boolean assistanceVariationForm, int assistanceVariationPeriod,
            int resistanceMaxResistance, int resistanceMinResistance,
            boolean resistanceVariationForm, int resistanceVariationPeriod,
            int cyclingMinResistance, int cyclingMaxResistance, int cyclingMinAngle,
            int cyclingMaxAngle, boolean cyclingLegApplied, int cyclingRepetition,
            boolean cyclingVariationForm, int cyclingVariationPeriod,
            int sequenceTime, int roadFeel, boolean recordSequence) {
        this.id = id;
        this.trialDataId = trialDataId;
        this.name = name;
        this.date = date;
        this.mode = mode;
        this.assistancePedalingDirection = assistancePedalingDirection;
        this.assistanceMaxSpeed = assistanceMaxSpeed;
        this.assistanceMinSpeed = assistanceMinSpeed;
        this.assistanceVariationForm = assistanceVariationForm;
        this.assistanceVariationPeriod = assistanceVariationPeriod;
        this.resistanceMaxResistance = resistanceMaxResistance;
        this.resistanceMinResistance = resistanceMinResistance;
        this.resistanceVariationForm = resistanceVariationForm;
        this.resistanceVariationPeriod = resistanceVariationPeriod;
        this.cyclingMinResistance = cyclingMinResistance;
        this.cyclingMaxResistance = cyclingMaxResistance;
        this.cyclingMinAngle = cyclingMinAngle;
        this.cyclingMaxAngle = cyclingMaxAngle;
        this.cyclingLegApplied = cyclingLegApplied;
        this.cyclingRepetition = cyclingRepetition;
        this.cyclingVariationForm = cyclingVariationForm;
        this.cyclingVariationPeriod = cyclingVariationPeriod;
        this.sequenceTime = sequenceTime;
        this.roadFeel = roadFeel;
        this.recordSequence = recordSequence;
    }

    @Generated(hash = 1302297994)
    public SequenceHistory() {
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public boolean getAssistancePedalingDirection() {
        return this.assistancePedalingDirection;
    }

    public void setAssistancePedalingDirection(
            boolean assistancePedalingDirection) {
        this.assistancePedalingDirection = assistancePedalingDirection;
    }

    public int getAssistanceMaxSpeed() {
        return this.assistanceMaxSpeed;
    }

    public void setAssistanceMaxSpeed(int assistanceMaxSpeed) {
        this.assistanceMaxSpeed = assistanceMaxSpeed;
    }

    public int getAssistanceMinSpeed() {
        return this.assistanceMinSpeed;
    }

    public void setAssistanceMinSpeed(int assistanceMinSpeed) {
        this.assistanceMinSpeed = assistanceMinSpeed;
    }

    public boolean getAssistanceVariationForm() {
        return this.assistanceVariationForm;
    }

    public void setAssistanceVariationForm(boolean assistanceVariationForm) {
        this.assistanceVariationForm = assistanceVariationForm;
    }

    public int getAssistanceVariationPeriod() {
        return this.assistanceVariationPeriod;
    }

    public void setAssistanceVariationPeriod(int assistanceVariationPeriod) {
        this.assistanceVariationPeriod = assistanceVariationPeriod;
    }

    public int getResistanceMaxResistance() {
        return this.resistanceMaxResistance;
    }

    public void setResistanceMaxResistance(int resistanceMaxResistance) {
        this.resistanceMaxResistance = resistanceMaxResistance;
    }

    public int getResistanceMinResistance() {
        return this.resistanceMinResistance;
    }

    public void setResistanceMinResistance(int resistanceMinResistance) {
        this.resistanceMinResistance = resistanceMinResistance;
    }

    public boolean getResistanceVariationForm() {
        return this.resistanceVariationForm;
    }

    public void setResistanceVariationForm(boolean resistanceVariationForm) {
        this.resistanceVariationForm = resistanceVariationForm;
    }

    public int getResistanceVariationPeriod() {
        return this.resistanceVariationPeriod;
    }

    public void setResistanceVariationPeriod(int resistanceVariationPeriod) {
        this.resistanceVariationPeriod = resistanceVariationPeriod;
    }

    public int getCyclingMinResistance() {
        return this.cyclingMinResistance;
    }

    public void setCyclingMinResistance(int cyclingMinResistance) {
        this.cyclingMinResistance = cyclingMinResistance;
    }

    public int getCyclingMaxResistance() {
        return this.cyclingMaxResistance;
    }

    public void setCyclingMaxResistance(int cyclingMaxResistance) {
        this.cyclingMaxResistance = cyclingMaxResistance;
    }

    public int getCyclingMinAngle() {
        return this.cyclingMinAngle;
    }

    public void setCyclingMinAngle(int cyclingMinAngle) {
        this.cyclingMinAngle = cyclingMinAngle;
    }

    public int getCyclingMaxAngle() {
        return this.cyclingMaxAngle;
    }

    public void setCyclingMaxAngle(int cyclingMaxAngle) {
        this.cyclingMaxAngle = cyclingMaxAngle;
    }

    public boolean getCyclingLegApplied() {
        return this.cyclingLegApplied;
    }

    public void setCyclingLegApplied(boolean cyclingLegApplied) {
        this.cyclingLegApplied = cyclingLegApplied;
    }

    public int getCyclingRepetition() {
        return this.cyclingRepetition;
    }

    public void setCyclingRepetition(int cyclingRepetition) {
        this.cyclingRepetition = cyclingRepetition;
    }

    public boolean getCyclingVariationForm() {
        return this.cyclingVariationForm;
    }

    public void setCyclingVariationForm(boolean cyclingVariationForm) {
        this.cyclingVariationForm = cyclingVariationForm;
    }

    public int getCyclingVariationPeriod() {
        return this.cyclingVariationPeriod;
    }

    public void setCyclingVariationPeriod(int cyclingVariationPeriod) {
        this.cyclingVariationPeriod = cyclingVariationPeriod;
    }

    public int getSequenceTime() {
        return this.sequenceTime;
    }

    public void setSequenceTime(int sequenceTime) {
        this.sequenceTime = sequenceTime;
    }

    public int getRoadFeel() {
        return this.roadFeel;
    }

    public void setRoadFeel(int roadFeel) {
        this.roadFeel = roadFeel;
    }

    public boolean getRecordSequence() {
        return this.recordSequence;
    }

    public void setRecordSequence(boolean recordSequence) {
        this.recordSequence = recordSequence;
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
    @Generated(hash = 1748006377)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSequenceHistoryDao() : null;
    }
}
