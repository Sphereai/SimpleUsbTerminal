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

@Entity(nameInDb = "custom_sequences")
public class CustomSequence {
    @Id(autoincrement = true)
    @Property(nameInDb = "id")
    private Long id;

    private long userId;

    @ToOne(joinProperty = "userId")
    private User user;

    @ToMany(referencedJoinProperty = "customSequenceId")
    private List<SequenceRecord> sequenceRecords;

    @NotNull
    @Property(nameInDb = "name")
    private String name;

    @NotNull
    @Property(nameInDb = "date")
    private Date date;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 672548954)
    private transient CustomSequenceDao myDao;

    @Generated(hash = 335050026)
    public CustomSequence(Long id, long userId, @NotNull String name,
            @NotNull Date date) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.date = date;
    }

    @Generated(hash = 730137588)
    public CustomSequence() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    @Generated(hash = 251390918)
    private transient Long user__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 115391908)
    public User getUser() {
        long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 462495677)
    public void setUser(@NotNull User user) {
        if (user == null) {
            throw new DaoException(
                    "To-one property 'userId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.user = user;
            userId = user.getId();
            user__resolvedKey = userId;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1404128081)
    public List<SequenceRecord> getSequenceRecords() {
        if (sequenceRecords == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SequenceRecordDao targetDao = daoSession.getSequenceRecordDao();
            List<SequenceRecord> sequenceRecordsNew = targetDao
                    ._queryCustomSequence_SequenceRecords(id);
            synchronized (this) {
                if (sequenceRecords == null) {
                    sequenceRecords = sequenceRecordsNew;
                }
            }
        }
        return sequenceRecords;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1353086926)
    public synchronized void resetSequenceRecords() {
        sequenceRecords = null;
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
    @Generated(hash = 1917440391)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCustomSequenceDao() : null;
    }
}
