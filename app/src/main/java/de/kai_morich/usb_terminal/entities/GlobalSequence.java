package de.kai_morich.usb_terminal.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(nameInDb = "global_sequences")
public class GlobalSequence {
    @Id(autoincrement = true)
    @Property(nameInDb = "id")
    private Long id;

    @NotNull
    @Property(nameInDb = "name")
    private String name;

    @ToMany(referencedJoinProperty = "globalSequenceId")
    private List<SequenceRecord> sequenceRecords;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 776928674)
    private transient GlobalSequenceDao myDao;

    @Generated(hash = 1147120329)
    public GlobalSequence(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 923468169)
    public GlobalSequence() {
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

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 134278997)
    public List<SequenceRecord> getSequenceRecords() {
        if (sequenceRecords == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SequenceRecordDao targetDao = daoSession.getSequenceRecordDao();
            List<SequenceRecord> sequenceRecordsNew = targetDao
                    ._queryGlobalSequence_SequenceRecords(id);
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
    @Generated(hash = 540057344)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGlobalSequenceDao() : null;
    }
}
