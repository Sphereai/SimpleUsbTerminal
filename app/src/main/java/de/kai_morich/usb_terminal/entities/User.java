package de.kai_morich.usb_terminal.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(nameInDb = "users")
public class User {
    @Id(autoincrement = true)
    @Property(nameInDb = "id")
    private Long id;

    @NotNull
    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "birth_date")
    private Date birthDate;

    @Property(nameInDb = "weight")
    private int weight;

    @Property(nameInDb = "height")
    private int height;

    @ToMany(referencedJoinProperty = "userId")
    private List<CustomSequence> customSequences;

    @ToMany(referencedJoinProperty = "userId")
    private List<Trial> trials;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;

    @Generated(hash = 1372470532)
    public User(Long id, @NotNull String name, Date birthDate, int weight,
            int height) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.weight = weight;
        this.height = height;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1528023399)
    public List<CustomSequence> getCustomSequences() {
        if (customSequences == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CustomSequenceDao targetDao = daoSession.getCustomSequenceDao();
            List<CustomSequence> customSequencesNew = targetDao
                    ._queryUser_CustomSequences(id);
            synchronized (this) {
                if (customSequences == null) {
                    customSequences = customSequencesNew;
                }
            }
        }
        return customSequences;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 259111466)
    public synchronized void resetCustomSequences() {
        customSequences = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 2058250086)
    public List<Trial> getTrials() {
        if (trials == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TrialDao targetDao = daoSession.getTrialDao();
            List<Trial> trialsNew = targetDao._queryUser_Trials(id);
            synchronized (this) {
                if (trials == null) {
                    trials = trialsNew;
                }
            }
        }
        return trials;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 290036725)
    public synchronized void resetTrials() {
        trials = null;
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
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }
}
